package com.excelunit.test.Excelunittest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	private static final Logger logger = Logger.getLogger(SpringBootApplication.class.getName());

    @RequestMapping(method = RequestMethod.POST )
    public String handleFileUpload(@RequestParam("user-file") MultipartFile multipartFile) throws IOException {
    	
        String name = multipartFile.getOriginalFilename();
        
        logger.log(Level.INFO,"File name: "+name);
        
        //todo save to a file via multipartFile.getInputStream()
        byte[] bytes = multipartFile.getBytes();
        logger.log(Level.INFO,"File uploaded content:\n"+ new String(bytes));
       
        return "file uploaded";
    }
}

