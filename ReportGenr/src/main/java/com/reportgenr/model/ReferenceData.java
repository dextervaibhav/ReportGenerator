package com.reportgenr.model;

import lombok.Getter;
import lombok.Setter;

public class ReferenceData {
	
	@Setter @Getter public String refkey1;
	@Setter @Getter public String refdata1;
	@Setter @Getter public String refkey2;
	@Setter @Getter public String refdata2;
	@Setter @Getter public String refdata3;
	@Setter @Getter public Double refdata4;
	
	public ReferenceData(String[] record) {
        this.refkey1 = record[0];
        this.refdata1 = record[1];
        this.refkey2 = record[2];
        this.refdata2 = record[3];
        this.refdata3 = record[4];
        this.refdata4 = Double.parseDouble(record[5]);
    }


}
