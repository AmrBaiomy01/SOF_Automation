package fawry.sofAutomation.pojos.acquirerMerchants;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class AcquirerPojo extends MainPOJO {

	
	public String getArabic_Name() {
		return arabic_Name;
	}
	public void setArabic_Name(String arabic_Name) {
		this.arabic_Name = arabic_Name;
	}
	public String getEnglish_Name() {
		return english_Name;
	}
	public void setEnglish_Name(String english_Name) {
		this.english_Name = english_Name;
	}
	public String getMerchant_ID() {
		return merchant_ID;
	}
	public void setMerchant_ID(String merchant_ID) {
		this.merchant_ID = merchant_ID;
	}
	public String getAcquirer_Bank() {
		return acquirer_Bank;
	}
	public void setAcquirer_Bank(String acquirer_Bank) {
		this.acquirer_Bank = acquirer_Bank;
	}
	public String getPayment_Type() {
		return payment_Type;
	}
	public void setPayment_Type(String payment_Type) {
		this.payment_Type = payment_Type;
	}
	public String getBiller() {
		return biller;
	}
	public void setBiller(String biller) {
		this.biller = biller;
	}
	public ArrayList<String> getAll_Bill_Types() {
		return all_Bill_Types;
	}
	public void setAll_Bill_Types(ArrayList<String> all_Bill_Types) {
		this.all_Bill_Types = all_Bill_Types;
	}
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}
	public String getCSP() {
		return CSP;
	}
	public void setCSP(String cSP) {
		CSP = cSP;
	}
	public String getBank_Terminal_ID() {
		return bank_Terminal_ID;
	}
	public void setBank_Terminal_ID(String bank_Terminal_ID) {
		this.bank_Terminal_ID = bank_Terminal_ID;
	}
	public String getMerchant_Param() {
		return merchant_Param;
	}
	public void setMerchant_Param(String merchant_Param) {
		this.merchant_Param = merchant_Param;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	private String arabic_Name;
	private String english_Name;
	private String merchant_ID;
	private String acquirer_Bank;
	private String payment_Type;
	private String biller;
	private ArrayList<String> all_Bill_Types;
	private String account_code;
	private String CSP;
	private String bank_Terminal_ID;
	private String merchant_Param;
	private String value;
	private String merchantStatus;
	public String getMerchantStatus() {
		return merchantStatus;
	}
	public void setMerchantStatus(String merchantStatus) {
		this.merchantStatus = merchantStatus;
	}
	
	

	
	
}
