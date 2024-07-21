package com.reportgenr.util;

import com.reportgenr.model.InputData;
import com.reportgenr.model.ReferenceData;
import com.reportgenr.model.OutputData;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<InputData> parseCsvToInputRecords(MultipartFile file) throws IOException, CsvValidationException {
    	Logger logger = LoggerFactory.getLogger(FileUtils.class);
        List<InputData> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                records.add(new InputData(nextLine));
            }
            logger.info("Input file parsed");
        }
        return records;
    }

    public static List<ReferenceData> parseCsvToReferenceRecords(MultipartFile file) throws IOException, CsvValidationException {
        List<ReferenceData> records = new ArrayList<>();
        Logger logger = LoggerFactory.getLogger(FileUtils.class);
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                records.add(new ReferenceData(nextLine));
            }
            logger.info("Reference file parsed");
        }
        return records;
    }

    public static void writeOutputRecordsToCsv(List<OutputData> records, String fileName) throws IOException {
    	Logger logger = LoggerFactory.getLogger(FileUtils.class);
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            for (OutputData record : records) {
                writer.writeNext(record.toArray());
            }
            logger.info("Output csv file created");
        }
    }
}
