package com.example.demo.Templet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class UploadFile  {
	
	public final String DIR = new ClassPathResource("static/img").getFile().getAbsolutePath();

	//public final String DIR = "C:\\Users\\DELL\\eclipse-workspace\\SpringBootRestAPI\\src\\main\\resources\\static";
	
	public UploadFile() throws IOException{
		System.out.println("exception");
	}

	public boolean UpdateFile(MultipartFile file){
		boolean f = false;

		try {

			// read file
			InputStream inputStream = file.getInputStream();

			byte data[] = new byte[inputStream.available()];

			inputStream.read(data);

			// write file
			FileOutputStream fos = new FileOutputStream(DIR + File.separator + file.getOriginalFilename());

			fos.flush();
			fos.close();

			f = true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;
	}

	

	

}
