package org.wescheme.servlet;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wescheme.project.Program;
import org.wescheme.user.Session;
import org.wescheme.user.SessionManager;
import org.wescheme.util.PMF;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class SaveProjectServlet extends HttpServlet{

	private static final long serialVersionUID = 4038563388689831368L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)	throws IOException 
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Session userSession;
		SessionManager sm = new SessionManager();

		if( !sm.isIntentional(req, resp) ){
			resp.sendError(401);
			return;
		}
		
		try {
			userSession = sm.authenticate(req, resp);
			
			if( null != userSession ){
				long startTime = System.currentTimeMillis();
		
				String code = req.getParameter("code");
				resp.setContentType("text/plain");
			
				Program prog = new Program(code, userSession);
				pm.makePersistent(prog);
			
				resp.getWriter().println(prog.getId());
				
				long duration = System.currentTimeMillis() - startTime;
				System.out.println("Took " + duration/1000 + " seconds.");	
				System.out.println("Saved as " + userSession.getName());
			} else {
				
				resp.sendError(401);
				return;
			}

		} finally {
			pm.close();
		}
		
		
	}
}