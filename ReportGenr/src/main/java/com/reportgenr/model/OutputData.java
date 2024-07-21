package com.reportgenr.model;

import lombok.Getter;
import lombok.Setter;

public class OutputData {

	@Setter @Getter public String outfield1;
	@Setter @Getter public String outfield2;
	@Setter @Getter public String outfield3;
	@Setter @Getter public Double outfield4;
	@Setter @Getter public Double outfield5;
	
	public OutputData(InputData inp, ReferenceData ref) {
		this.outfield1 = inp.field1+inp.field2;
		this.outfield2 = ref.refdata1;
		this.outfield3 = ref.refdata2+ref.refdata3;
		this.outfield4 = inp.field3 * Math.max(inp.field5,ref.refdata4);
		this.outfield5 = Math.max(inp.field5,ref.refdata4);
	}
	
	
	public String[] toArray() {
        return new String[]{
            this.outfield1,
            this.outfield2,
            this.outfield3,
            String.valueOf(this.outfield4),
            String.valueOf(this.outfield5)
        };
    }

	
}
