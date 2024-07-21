package com.reportgenr.service;


import org.springframework.stereotype.Service;

import com.reportgenr.model.InputData;
import com.reportgenr.model.OutputData;
import com.reportgenr.model.ReferenceData;

import com.reportgenr.util.TransformationUtils;

import java.util.List;

@Service
public class TransformationService {

    public List<OutputData> transform(List<InputData> inputRecords, List<ReferenceData> referenceRecords) {
        return TransformationUtils.applyTransformationRules(inputRecords, referenceRecords);
    }
}
