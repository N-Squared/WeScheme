package org.wescheme.data;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

/** Data Access Object for all the data we're managing with Objectify.
 * 
 * @author dyoo
 *
 */

public class DAOIMG extends DAOBase {
	static {
		ObjectifyService.register(Picture.class);
	}
	
	public void savePicture(Picture picture) {
		ofy().put(picture);
	}	
	
	public void deletePicture(Picture picture) {
		ofy().delete(picture);
	}	
}
