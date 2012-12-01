package org.wescheme.servlet;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wescheme.user.Session;
import org.wescheme.user.SessionManager;
import org.wescheme.user.WeSchemeUser;

/**
*	Checks if file is compatible;
*	Creates picture file increment's user's current data. 
*	Checks if max data hasn't been met.
*	Uploads image, if compatible.
*	@authors Lisa Xu, Jamielyn Abad
*/

public class PictureChecker extends HttpServlet {
	
	private File theFile;
	
	public int Service(HttpServletRequest req, HttpServletResponse res){
		SessionManager sm = new SessionManager();
		theFile = new File(req.getParameter("file"));
		Session session = sm.authenticate(req, res);
		WeSchemeUser theUser = session.getUser();
		if(checkExtension() == false)
			return 1;
		if(checkSize() == false)
			return 2;
		if(checkDataLimit(theUser) == false)
			return 3;
		return 0;
	}

	private boolean checkExtension(){
		String accept[] = {".gif", ".jpeg", ".png", ".jpg"};
		
		int i;
		String name = theFile.getName();
		for(i = name.length()-1; i > 0; i--){
			if(name.charAt(i) == '.')
				break;
			else
				continue;
		}
		String extension = name.substring(i,name.length());
		for(int j = 0; j < accept.length; j++){
			if(extension.equalsIgnoreCase(accept[j]))
				return true;				
		}
		return false;
	}
	
	private boolean checkDataLimit(WeSchemeUser user){
		if(user.getDataSize()+theFile.length() <= 5242880)
			return true;
		return false;
	}
	
	
	public boolean checkSize() {
		return (theFile.length()<51200);
	}
	
	
}