package cn.hezhiling.users.system.utils;

import cn.hezhiling.users.system.annotation.TokenUser;
import cn.hezhiling.users.system.constants.MaskConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * @author hezhiling
 */
public class JwtDecodeUtils {

	private static final String USER_ID = "userId";

	private JwtDecodeUtils() {}

	public static TokenUser decode(String token) throws Exception {
		Key key = new SecretKeySpec(MaskConstants.SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
		Claims body = claimsJws.getBody();
		String tokenUserId = body.get(USER_ID).toString();
		String tokenType = body.getSubject();
		String id = body.getId();

		TokenUser tokenUser = new TokenUser();
		tokenUser.setToken(token);
		tokenUser.setUserId(tokenUserId);
		tokenUser.setClientId(id);
		tokenUser.setTokenType(tokenType);
		return tokenUser;
	}
}
