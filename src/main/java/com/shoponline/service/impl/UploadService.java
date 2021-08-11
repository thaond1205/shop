package com.shoponline.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shoponline.service.IUploadService;

@Service
public class UploadService implements IUploadService{
	
	@Autowired
	private ServletContext context;
	@Override
	public File save(MultipartFile file, String folder) {
		

		File dir = new File(context.getRealPath(folder));
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savedFile = new File(dir, name);
			file.transferTo(savedFile);
			System.out.printf(savedFile.getAbsolutePath());
			return savedFile;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
