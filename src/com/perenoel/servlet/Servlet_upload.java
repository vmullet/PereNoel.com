package com.perenoel.servlet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class Servlet_Upload
 */
@WebServlet("/Servlet_upload")
@MultipartConfig
public class Servlet_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        // sends response to client
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id_produit");
		System.out.println(id);
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = filePart.getSubmittedFileName();
	    InputStream fileContent = filePart.getInputStream();
	    System.out.println(fileName);
	    File directory=new File("C:\\Uploads");
	    if (!directory.exists())
	    {
	    	directory.mkdirs();
	    	
	    }
	    File saveFile = new File("C:\\Uploads\\"+ fileName);
	    FileOutputStream outputStream = new FileOutputStream(saveFile);
	    
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        System.out.println("Receiving data...");
        
        while ((bytesRead = fileContent.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
         
        System.out.println("Data received.");
        outputStream.close();
        fileContent.close();
        
        System.out.println("File written to: " + saveFile.getAbsolutePath());
         
        //at this point, no resources have been created
        
	}
	
	public void upload()
	{
		
	}
	}




