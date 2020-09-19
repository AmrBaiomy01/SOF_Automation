package fawry.sofAutomation.pojos.acquirerMerchants;

import java.util.ArrayList;

import fawry.sofAutomation.pojos.main.MainPOJO;

public class SearchPojo extends MainPOJO {
	
	private String acquirer_Bank;
	public String getAcquirer_Bank() {
		return acquirer_Bank;
	}
	public void setAcquirer_Bank(String acquirer_Bank) {
		this.acquirer_Bank = acquirer_Bank;
	}
	public String getPayment_Type() {
		return Payment_Type;
	}
	public void setPayment_Type(String payment_Type) {
		Payment_Type = payment_Type;
	}
	public String getBiller() {
		return Biller;
	}
	public void setBiller(String biller) {
		Biller = biller;
	}
	public String getBill_type() {
		return Bill_type;
	}
	public void setBill_type(String bill_type) {
		Bill_type = bill_type;
	}
	public String getMerchant_ID() {
		return Merchant_ID;
	}
	public void setMerchant_ID(String merchant_ID) {
		Merchant_ID = merchant_ID;
	}
	public String getRetailer_code() {
		return Retailer_code;
	}
	public void setRetailer_code(String retailer_code) {
		Retailer_code = retailer_code;
	}
	private String Payment_Type;
	private String Biller;
	private String Bill_type;
	private String Merchant_ID;
	private String Retailer_code;
	
	
	
	

}
