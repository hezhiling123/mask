package cn.hezhiling.users.system.annotation;

import java.lang.annotation.*;

/**
 * @author system
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedToken {
	// 是否需要走token认证逻辑
	boolean require() default true;

	// 角色集合
	String[] roles() default {};

	// 只允许token所属的用户调用
	boolean needUserId() default false;

	// todo 待扩展
	// 允许第三方服务调用
	boolean thirdParty() default false;

	// 只允许内部调用
	boolean inner() default false;
}
