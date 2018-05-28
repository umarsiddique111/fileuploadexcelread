package com.excelunit.test.Excelunittest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jxl.Sheet;
import jxl.read.biff.BiffException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelunittestApplicationTests {
	
	
	private final static Logger logger = Logger.getLogger(ExcelunittestApplication.class.getName());
	
 private User user;
	
	@Test 
	public void checkdatatest() throws BiffException, IOException {
		String filepath1 = "D:\\detail.xls";
		 ReadExcelFile readExcelFile = new ReadExcelFile();
		 Sheet sh1 = readExcelFile.readExcel(filepath1);
		 String url = sh1.getCell(0, 1).getContents();
		 String path = sh1.getCell(1, 1).getContents();
		 logger.log( Level.INFO,"detail sheet URL"+url+"detail sheet Path!!"+path);

		
		
		ReadExcelFile readExcelFile1 = new ReadExcelFile();
		Sheet sh = readExcelFile1.readExcel(path);
		String emailexcel = sh.getCell(1,2).getContents();
		String passwordexcel = sh.getCell(2,2).getContents();
		
		User user = new User();
		user.setEmailAddress("saleem@gmail.com");
		user.setpassword("saleem12345");
		
		logger.log( Level.INFO, "get email"+sh.getCell(1,2).getContents());
		assertEquals(passwordexcel, user.getpassword());
		assertEquals(emailexcel, user.getEmailAddress());
		
		
	}
	
//	@Test
//	public final void testUploadfile() throws IOException {
//		
//		
//		Path tempFile = Files.createTempFile("upload-test-file", ".txt");
//        Files.write(tempFile, "some test content...\nline1\nline2".getBytes());
//        File file = tempFile.toFile();
//        System.out.println(file);
//        UploadClient uploadClient = new UploadClient();
//       String resut = uploadClient.uploadfile(file);
//		assertEquals("File uploaded succefully", resut);
//		
//		
//		
//	}

	
	
}
