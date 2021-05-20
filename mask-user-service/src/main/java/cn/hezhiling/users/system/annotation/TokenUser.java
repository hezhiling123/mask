package cn.hezhiling.users.system.annotation;

public class TokenUser {
	private String userId;
	private String tokenType;
	private String clientId;
	private String token;
	private static final ThreadLocal<TokenUser> TOKEN_USER = new ThreadLocal<>();

	public TokenUser() {
	}



	public String getUserId() {
		return userId;
	}

    public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTokenType() {
		return tokenType;
	}

    public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getClientId() {
		return clientId;
	}

    public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static void setUser(String userId, String tokenType, String clientId) {
		TokenUser tokenUser = new TokenUser();
		tokenUser.setUserId(userId);
		tokenUser.setTokenType(tokenType);
		tokenUser.setClientId(clientId);
		TOKEN_USER.set(tokenUser);
	}

	public static void setUser(TokenUser tokenUser) {
		TOKEN_USER.set(tokenUser);
	}

	public static void setUser(String userId, String tokenType, String clientId, String token) {
		TokenUser tokenUser = new TokenUser();
		tokenUser.setUserId(userId);
		tokenUser.setTokenType(tokenType);
		tokenUser.setClientId(clientId);
		tokenUser.setToken(token);
		TOKEN_USER.set(tokenUser);
	}

	public static TokenUser getUser() {
		return TOKEN_USER.get();
	}

	public static String getCurrentUserId() {
		TokenUser tokenUser = TOKEN_USER.get();
		return tokenUser != null ? tokenUser.getUserId() : null;
	}

	public static void remove() {
		TOKEN_USER.remove();
	}
}
