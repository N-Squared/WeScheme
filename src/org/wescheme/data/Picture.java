import java.awt.Image;

import java.util.Date;

import org.json.simple.JSONObject;

import com.googlecode.objectify.annotation.Unindexed;

/**
*	This class represents the user's image
*	@author Lisa Xu, Jamielyn Abad
*/
public class Picture {

	private String user;
	private Image image;
	private Date date;
	private String fileName;
	
	public picture(){}
	
	public Picture(String author, String file, Image img){
		image = img;
		user = author;
		date = System.currentTimeMillis();
		fileName = file;
	}
	
	public Image getImg(){
		return image;
	}
	
	public int getUser(){
		return user;
	}
	
	public int getSize(){
		return size;
	}
	
	public Date getDate(){
		return date;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("author", this.user);
		obj.put("image", this.image);
		obj.put("date", this.date);
		return obj;
	}
	
}