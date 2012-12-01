package org.wescheme.data;

import java.util.Date;
import java.util.Random;

import javax.persistence.Id;

import org.json.simple.JSONObject;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.annotation.Unindexed;


/** Represents feedback we get back from WeScheme users.
 *  The content is unstructured for the most part; we may want
 *  to enforce some structure later one to help with data mining.
 * @author dyoo
 *
 */

public class Img {
	@Id int id;
	@Unindexed String author;
	long date;
	Image image;
	
	// NoArg constructor for Objectify.
	Img() {}
	
	public Img(String author, Image img) {
		this.author = author;
		this.date = System.currentTimeMillis();
		Random rand = new Random(date);
		this.id = rand.nextInt();
		this.image = img;
	}
	
	
	
	public String getAuthor() { return this.author; }
	public Image getImage() { return this.image; }
	public int getId() { return this.id; }

	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("author", this.author);
		obj.put("Image", this.image);
		// date is represented at amount of milliseconds
		obj.put("date", this.date);
		return obj;
	}
}
