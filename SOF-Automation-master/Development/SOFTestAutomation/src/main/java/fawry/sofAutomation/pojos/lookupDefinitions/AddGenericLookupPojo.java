package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddGenericLookupPojo extends MainPOJO {

	private String lookupType_List;
	public String getLookupType_List() {
		return lookupType_List;
	}
	public void setLookupType_List(String lookupType_List) {
		this.lookupType_List = lookupType_List;
	}
	public String getCode_txt() {
		return Code_txt;
	}
	public void setCode_txt(String code_txt) {
		Code_txt = code_txt;
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
	private String Code_txt;
	private String Name_txt;
	private String Description_txt;
		
	
}
