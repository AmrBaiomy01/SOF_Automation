package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddFinanceProgramTypePojo extends MainPOJO {

	
	private String financeProgram_Code;
	public String getFinanceProgram_Code() {
		return financeProgram_Code;
	}
	public void setFinanceProgram_Code(String financeProgram_Code) {
		this.financeProgram_Code = financeProgram_Code;
	}
	public String getFinanceProgram_Name() {
		return financeProgram_Name;
	}
	public void setFinanceProgram_Name(String financeProgram_Name) {
		this.financeProgram_Name = financeProgram_Name;
	}
	public String getFinanceProgram_Description() {
		return financeProgram_Description;
	}
	public void setFinanceProgram_Description(String financeProgram_Description) {
		this.financeProgram_Description = financeProgram_Description;
	}
	public String getNature_List() {
		return nature_List;
	}
	public void setNature_List(String nature_List) {
		this.nature_List = nature_List;
	}
	public String getSubAccountLength_txt() {
		return subAccountLength_txt;
	}
	public void setSubAccountLength_txt(String subAccountLength_txt) {
		this.subAccountLength_txt = subAccountLength_txt;
	}
	private String financeProgram_Name;
	private String financeProgram_Description;
	private String nature_List;
	private String subAccountLength_txt;
		
}
