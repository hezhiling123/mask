package cn.hezhiling.users.system.annotation;

import cn.hezhiling.core.exception.BusinessException;
import cn.hezhiling.core.exception.MaskRuntimeException;
import cn.hezhiling.core.exception.ResultStatusCode;
import cn.hezhiling.core.utils.response.ResponseCodeConstant;
import cn.hezhiling.users.system.utils.JwtDecodeUtils;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
@Aspect
public class TokenAspect {
	private static final String APPID = "appid";
	private static final String TOKEN = "token";
	private static final String USERID = "userid";

	@Pointcut("@annotation(cn.hezhiling.users.system.annotation.NeedToken)" +
			" || @within(cn.hezhiling.users.system.annotation.NeedToken)")
	public void tokenPointcut() {
	}

	@Around("tokenPointcut()")
	public Object tokenInterceptorAround(ProceedingJoinPoint pjp) throws Throwable {
		try {
			MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
			NeedToken needToken = AnnotationUtils.findAnnotation(methodSignature.getMethod(), NeedToken.class);
			if (needToken == null) {
				needToken = AnnotationUtils.findAnnotation(pjp.getTarget().getClass(), NeedToken.class);
			}
			if (needToken == null) {
				throw new BusinessException(ResponseCodeConstant.USER_LOGIN_FAIL,
						ResponseCodeConstant.USER_LOGIN_FAIL_FREEZEED_MSG);
			}
			if (!needToken.require()) {
				return pjp.proceed();
			}
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = Objects.requireNonNull(requestAttributes).getRequest();
			if (!checkToken(request, needToken)) {
				throw new MaskRuntimeException("Token 失效，请重新获取", ResultStatusCode.INVALID_TOKEN.getCode());
			}
			return pjp.proceed();
		} finally {
			TokenUser.remove();
		}
	}

	private boolean checkToken(HttpServletRequest request, NeedToken needToken) throws Exception {
		try {
			String appid = request.getHeader(APPID);
			String token = request.getHeader(TOKEN);
			String userid = request.getHeader(USERID);
			if (StrUtil.hasBlank(appid, token)) {
				throw new MaskRuntimeException("Token 不能为空", ResultStatusCode.INVALID_TOKEN.getCode());
			}
			TokenUser tokenUser = JwtDecodeUtils.decode(token);
			//校验userid
			checkUserId(needToken, tokenUser.getUserId(), userid);
			TokenUser.setUser(tokenUser);
			return Objects.equals(appid, tokenUser.getClientId());
		} catch (ExpiredJwtException e) {
			throw new MaskRuntimeException("Token 过期，请重新获取", ResultStatusCode.INVALID_TOKEN.getCode());
		} catch (Exception e) {
			throw new MaskRuntimeException(e.getMessage(), ResultStatusCode.UNAUTHO_ERROR.getCode());
		}
	}

	private void checkUserId(NeedToken needToken, String tokenUserId, String userid) throws Exception {
		//校验用户id
		if (needToken != null && needToken.needUserId()) {
			if (!tokenUserId.equals(userid)) {
				throw new MaskRuntimeException("用户没有权限", ResultStatusCode.UNAUTHO_ERROR.getCode());
			}
		}
	}
}
