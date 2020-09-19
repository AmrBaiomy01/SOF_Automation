package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class SearchAcquirerPojo extends MainPOJO {

	private String Bank_Code;

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

	private String BIN;
	private String Status;


}
