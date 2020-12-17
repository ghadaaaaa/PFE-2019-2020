package com.turath.servlets;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	
	 public static void resize(File imageFile, int height, int width) throws IOException {
		 
		    BufferedImage img = ImageIO.read(imageFile);
	        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resized.createGraphics();
	        g2d.drawImage(tmp, 0, 0, null);
	        g2d.dispose();
	        ImageIO.write(resized,"jpg", imageFile);
	     
	    }
	 public static void main(String args[]) throws IOException {
		 File fil=new File("C:\\Users\\Clt\\git\\1st_prototype\\PFE_jena_sdb\\WebContent\\img\\Casbah.jpg");
		 resize (fil, 259,194);
	 }
 }

