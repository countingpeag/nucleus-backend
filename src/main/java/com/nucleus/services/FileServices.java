package com.nucleus.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.nucleus.files.FileOperations;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/file")
public class FileServices {
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/upload")
	public Response uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		
		String uploadedFileLocation = "C:\\Users\\Omar\\Desktop\\test" + fileDetail.getFileName();
		
		writeToFile(uploadedInputStream, uploadedFileLocation);

		FileOperations operations = new FileOperations();
		try {
			operations.redFile(uploadedFileLocation);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return Response.status(200).entity("fail").build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(200).entity("fail").build();
		}

		return Response.status(200).entity("successful").build();
	}
	
	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
