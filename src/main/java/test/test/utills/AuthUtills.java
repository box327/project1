package test.test.utills;

import javax.servlet.http.HttpSession;

import test.test.domain.UserData;

public class AuthUtills {
	
	private static String loginUserAttName = "loginUser";
	
	public static void login(HttpSession session, UserData loginUser)
	{
		session.setAttribute(loginUserAttName, loginUser);
	}
	
	public static void logout(HttpSession session)
	{
		session.removeAttribute(loginUserAttName);
	}
	
	
	public static boolean isLoginUser(HttpSession session){
		Object temp = session.getAttribute(loginUserAttName);
		if(temp == null)
			return false;
		else
			return true;
	}

	public static UserData getLoginUser(HttpSession session){
		
		if(isLoginUser(session))		
			return (UserData)session.getAttribute(loginUserAttName);
		return null;
	}
}
