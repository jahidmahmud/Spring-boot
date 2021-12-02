package com.sts.rest.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;

@Component
public class FileUploadHelper {
	//public final String UPLOAD_DIR="G:\\STS Projects\\com.rest.web\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR=new ClassPathResource("/static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper()throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean uploadFile(MultipartFile file) {
		boolean f=false;
		try {
			InputStream inputStream = file.getInputStream();
			byte data[]=new byte[inputStream.available()];
			inputStream.read(data);
			FileOutputStream stream=new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
			stream.write(data);
			stream.flush();
			stream.close();
			
			//alternative
			//Files.copy(file.getInputStream(),UPLOAD_DIR+File.separator+file.getOriginalFilename(),StandardCopyOption.REPLACE_EXISTING);
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
}
