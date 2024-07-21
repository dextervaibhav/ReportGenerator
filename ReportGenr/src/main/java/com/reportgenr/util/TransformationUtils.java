package com.reportgenr.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.reportgenr.model.InputData;
import com.reportgenr.model.OutputData;
import com.reportgenr.model.ReferenceData;

public class TransformationUtils {

    public static List<OutputData> applyTransformationRules(List<InputData> inputRecords, List<ReferenceData> referenceRecords) {
       
    	List<OutputData> outputdata =new ArrayList<OutputData>();
    	for(int i=0;i<inputRecords.size();i++) {
    		OutputData ou = new OutputData(inputRecords.get(i),referenceRecords.get(i));
    		outputdata.add(ou);
    	}
    	return outputdata;
    	
    }
}
