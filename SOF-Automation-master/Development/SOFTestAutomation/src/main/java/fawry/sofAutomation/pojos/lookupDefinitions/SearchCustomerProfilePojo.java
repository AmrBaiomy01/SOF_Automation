package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class SearchCustomerProfilePojo extends MainPOJO {

	
	private String Customerprofilecode_txt;
	public String getCustomerprofilecode_txt() {
		return Customerprofilecode_txt;
	}
	public void setCustomerprofilecode_txt(String customerprofilecode_txt) {
		Customerprofilecode_txt = customerprofilecode_txt;
	}
	public String getCustomerMobileNumber_txt() {
		return CustomerMobileNumber_txt;
	}
	public void setCustomerMobileNumber_txt(String customerMobileNumber_txt) {
		CustomerMobileNumber_txt = customerMobileNumber_txt;
	}
	
	public String getCSPName_List() {
		return CSPName_List;
	}
	public void setCSPName_List(String cSPName_List) {
		CSPName_List = cSPName_List;
	}
	public String getCustomerName_txt() {
		return CustomerName_txt;
	}
	public void setCustomerName_txt(String customerName_txt) {
		CustomerName_txt = customerName_txt;
	}
	private String CustomerMobileNumber_txt;
	private String CustomerName_txt;
	private String CSPName_List;
	
	
}
