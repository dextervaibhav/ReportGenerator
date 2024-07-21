package com.reportgenr.model;

import lombok.Getter;
import lombok.Setter;

public class InputData {
	
	@Setter @Getter public String field1;
	@Setter @Getter public String field2;
	@Setter @Getter public Double field3;
	@Setter @Getter public String field4;
	@Setter @Getter public Double field5;
	@Setter @Getter public String refkey1;
	@Setter @Getter public String refkey2;
	
	public InputData(String[] record) {
        this.field1 = record[0];
        this.field2 = record[1];
        this.field3 = Double.parseDouble(record[2]);
        this.field4 = record[3];
        this.field5 = Double.parseDouble(record[4]);
        this.refkey1 = record[5];
        this.refkey2 = record[6];
    }

	
}
