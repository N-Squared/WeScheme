package org.wescheme.data;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

/** Data Access Object for all the data we're managing with Objectify.
 * 
 * @author dyoo
 *
 */

public class ImgDAO extends DAOBase {
	static {
		ObjectifyService.register(Img.class);
	}
	
	public void saveFeedback(Img image) {
		ofy().put(image);
	}	
}
