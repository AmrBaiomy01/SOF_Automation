package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddPSPPojo extends MainPOJO {

	private String PSP_status;
	public String getPSP_status() {
		return PSP_status;
	}
	public void setPSP_status(String pSP_status) {
		PSP_status = pSP_status;
	}

	public String getName_txt() {
		return Name_txt;
	}
	public void setName_txt(String name_txt) {
		Name_txt = name_txt;
	}
	public String getDescription_txt() {
		return Description_txt;
	}
	public void setDescription_txt(String description_txt) {
		Description_txt = description_txt;
	}
	public String getCode_txt() {
		return Code_txt;
	}
	public void setCode_txt(String code_txt) {
		Code_txt = code_txt;
	}
	private String Code_txt;
	private String Name_txt;
	private String Description_txt;
		
	
}
