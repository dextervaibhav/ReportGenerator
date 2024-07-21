package com.reportgenr.controller;



import com.reportgenr.config.ScheduleConfig;
import com.reportgenr.service.ReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
	Logger logger = LoggerFactory.getLogger(ReportController.class);
	
    @Autowired
    private ReportService reportService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@RequestParam("inputFile") MultipartFile inputFile,
                                                 @RequestParam("referenceFile") MultipartFile referenceFile) throws CsvValidationException {
        try {
            reportService.generateReport(inputFile, referenceFile);
            logger.info("Report Generated via API");
            return ResponseEntity.ok("Report generated successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing files: " + e.getMessage());
        }
    }
    @GetMapping("/tmp")
    public String tmp() {
    	return  ("Hello world");
    }
}
