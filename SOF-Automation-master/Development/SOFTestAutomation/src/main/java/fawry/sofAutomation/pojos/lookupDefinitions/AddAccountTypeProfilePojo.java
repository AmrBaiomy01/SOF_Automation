package fawry.sofAutomation.pojos.lookupDefinitions;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AddAccountTypeProfilePojo extends MainPOJO {
	
	private String accountType_List;
	public String getAccountType_List() {
		return accountType_List;
	}
	public void setAccountType_List(String accountType_List) {
		this.accountType_List = accountType_List;
	}
	public String getCSP_List() {
		return CSP_List;
	}
	public void setCSP_List(String cSP_List) {
		CSP_List = cSP_List;
	}
	public String getAcquirerBank_List() {
		return acquirerBank_List;
	}
	public void setAcquirerBank_List(String acquirerBank_List) {
		this.acquirerBank_List = acquirerBank_List;
	}
	public String getMerchantCode_txt() {
		return merchantCode_txt;
	}
	public void setMerchantCode_txt(String merchantCode_txt) {
		this.merchantCode_txt = merchantCode_txt;
	}
	public String getExternalAuthorizerSystemCode_txt() {
		return externalAuthorizerSystemCode_txt;
	}
	public void setExternalAuthorizerSystemCode_txt(String externalAuthorizerSystemCode_txt) {
		this.externalAuthorizerSystemCode_txt = externalAuthorizerSystemCode_txt;
	}
	public String getBiller_List() {
		return biller_List;
	}
	public void setBiller_List(String biller_List) {
		this.biller_List = biller_List;
	}
	public String getPaymentType_List() {
		return paymentType_List;
	}
	public void setPaymentType_List(String paymentType_List) {
		this.paymentType_List = paymentType_List;
	}
	public ArrayList<String> getAll_Bill_Types() {
		return all_Bill_Types;
	}
	public void setAll_Bill_Types(ArrayList<String> all_Bill_Types) {
		this.all_Bill_Types = all_Bill_Types;
	}
	private String CSP_List;
	private String acquirerBank_List;
	private String merchantCode_txt;
	private String externalAuthorizerSystemCode_txt;
	private String biller_List;
	private String paymentType_List;
	private ArrayList<String> all_Bill_Types;
		
	
}
