package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddacquirerPojo extends MainPOJO {

	
	
	
	private String Bank_Name;
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public String getBank_Code() {
		return Bank_Code;
	}
	public void setBank_Code(String bank_Code) {
		Bank_Code = bank_Code;
	}
	public String getBIN() {
		return BIN;
	}
	public void setBIN(String bIN) {
		BIN = bIN;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	private String Bank_Code;
	private String BIN;
	private String Status;
	private String Description;


	
	
}
