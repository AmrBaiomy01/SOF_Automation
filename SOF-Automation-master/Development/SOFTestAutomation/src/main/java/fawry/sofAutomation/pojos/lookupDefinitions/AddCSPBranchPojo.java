package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddCSPBranchPojo extends MainPOJO {

	
	
	private String Code_txt;
	public String getCode_txt() {
		return Code_txt;
	}
	public void setCode_txt(String code_txt) {
		Code_txt = code_txt;
	}
	public String getAlias_txt() {
		return Alias_txt;
	}
	public void setAlias_txt(String alias_txt) {
		Alias_txt = alias_txt;
	}
	public String getBranchname_txt() {
		return Branchname_txt;
	}
	public void setBranchname_txt(String branchname_txt) {
		Branchname_txt = branchname_txt;
	}
	public String getBranchaddress_txt() {
		return Branchaddress_txt;
	}
	public void setBranchaddress_txt(String branchaddress_txt) {
		Branchaddress_txt = branchaddress_txt;
	}
	
	public String getCSPname_list() {
		return CSPname_list;
	}
	public void setCSPname_list(String cSPname_list) {
		CSPname_list = cSPname_list;
	}

	private String Alias_txt;
	private String Branchname_txt;
	private String Branchaddress_txt;
	private String CSPname_list;

	
}
