package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddCustomerProfilePojo extends MainPOJO {

	
	private String CustomerProfile_Code;
	public String getCustomerProfile_Code() {
		return CustomerProfile_Code;
	}
	public void setCustomerProfile_Code(String customerProfile_Code) {
		CustomerProfile_Code = customerProfile_Code;
	}
	public String getCustomerProfile_Name() {
		return CustomerProfile_Name;
	}
	public void setCustomerProfile_Name(String customerProfile_Name) {
		CustomerProfile_Name = customerProfile_Name;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCustomerCategory_List() {
		return CustomerCategory_List;
	}
	public void setCustomerCategory_List(String customerCategory_List) {
		CustomerCategory_List = customerCategory_List;
	}
	public String getCustomerProfiletype_List() {
		return CustomerProfiletype_List;
	}
	public void setCustomerProfiletype_List(String customerProfiletype_List) {
		CustomerProfiletype_List = customerProfiletype_List;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getCSPName_List() {
		return CSPName_List;
	}
	public void setCSPName_List(String cSPName_List) {
		CSPName_List = cSPName_List;
	}
	private String CustomerProfile_Name;
	private String CSPName_List;
	private String Description;
	private String CustomerCategory_List;
	private String CustomerProfiletype_List;
	private String MobileNumber;
	
	
}
