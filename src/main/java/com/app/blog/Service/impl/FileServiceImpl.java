package com.app.blog.Service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.blog.Service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// File name
	    String name = file.getOriginalFilename();

	    // Random name generated for the file
	    String randomID = UUID.randomUUID().toString();
	    String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));

	    // Full path
	    String filePath = path + File.separator + fileName1;

	    // Create folder if it doesn't exist
	    File f = new File(path);
	    if (!f.exists()) {
	        f.mkdir();
	    }

	    // File copy
	    Files.copy(file.getInputStream(), Paths.get(filePath));

	    return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		 // Construct the full path to the file.
	    // File.separator is used to ensure the correct path separator for the operating system.
	    String fullPath = path + File.separator + fileName;

	    // Create a new FileInputStream to read the file from the specified path.
	    // This will throw a FileNotFoundException if the file does not exist.
	    InputStream is = new FileInputStream(fullPath);

	    // This comment suggests there might be database logic to retrieve the input stream,
	    // but the code shown uses a FileInputStream.

	    // Return the InputStream.
	    return is;
	}

}
