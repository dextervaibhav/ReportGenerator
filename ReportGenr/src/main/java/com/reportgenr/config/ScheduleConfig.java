package com.reportgenr.config;

import com.opencsv.exceptions.CsvValidationException;
import com.reportgenr.service.ReportService;

import jakarta.servlet.annotation.MultipartConfig;

import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

@Configuration
@EnableScheduling
public class ScheduleConfig {
    @Autowired
    private ReportService reportService;
    public String inputfile = "D:\\cdost\\javaproject\\ReportGenr\\inputfile.csv";
    private String referencefile = "D:\\cdost\\javaproject\\ReportGenr\\referencefile.csv";
    Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);
    //@Scheduled(cron = "0 0 0 * * ?")
    @Scheduled(fixedDelay = 60_000)
    public void scheduledReportGeneration() throws IOException, CsvValidationException {
        // Implement the logic to fetch the scheduled files and call reportService.generateReport()
    	FileInputStream stream1 =  new FileInputStream(inputfile);
    	FileInputStream stream2 =  new FileInputStream(referencefile);
    	MultipartFile mpf1= new MockMultipartFile("inputfile", stream1);
    	MultipartFile mpf2= new MockMultipartFile("referencfile", stream2);

    	
    	try {
            
			reportService.generateReport(mpf1, mpf2);
			logger.info("Scheduled Report Generated");
           
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    	
    }

}
