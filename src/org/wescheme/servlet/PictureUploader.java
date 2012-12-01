import java.IO.File;

import Java.IO.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

import java.util.Date;

import org.wescheme.data.Picture;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wescheme.data.Picture;

public class PictureUploader extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException{
		
		String author = req.getParameter("author");
		File file = new File(req.getParameter("file"));
		Picture picture = new Picture(author, file.getName(), ImageIO.read(file));
		
		new DAOIMG().putPicture(picture);
		
		response.setContentType("text/plain");
		response.getWriter().write("Image was uploaded successfully!");
	}
}