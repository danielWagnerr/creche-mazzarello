package br.com.tis.services;

public interface SecurityService {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
