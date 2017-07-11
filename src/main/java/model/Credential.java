package model;

import java.util.Map;

public class Credential {
	String username;
	String password;

	public Credential(Map<String, Object> map) {
		username = map.get("e-mail").toString();
		password = map.get("password").toString();

	}

	public String getUserName() {
		return username;
	}

	public String getpassword() {
		return password;
	}


}
