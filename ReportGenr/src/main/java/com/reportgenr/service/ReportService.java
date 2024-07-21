package com.reportgenr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.reportgenr.model.InputData;
import com.reportgenr.model.OutputData;
import com.reportgenr.model.ReferenceData;
import com.reportgenr.util.FileUtils;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private TransformationService transformationService;

    public void generateReport(MultipartFile inputFile, MultipartFile referenceFile) throws IOException, CsvValidationException {
        List<InputData> inputRecords = FileUtils.parseCsvToInputRecords(inputFile);
        List<ReferenceData> referenceRecords = FileUtils.parseCsvToReferenceRecords(referenceFile);

        List<OutputData> outputRecords = transformationService.transform(inputRecords, referenceRecords);

        FileUtils.writeOutputRecordsToCsv(outputRecords, "output.csv");
    }
}
