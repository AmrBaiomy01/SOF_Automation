package fawry.sofAutomation.dbVerification.lookupDefinitions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fawry.sofAutomation.pojos.accounts.TerminalPojo;
import fawry.sofAutomation.pojos.acquirerMerchants.AcquirerPojo;
import fawry.sofAutomation.pojos.acquirerMerchants.SearchPojo;
import fawry.sofAutomation.utils.DatabaseConnection;

public class AddacquirerVefication {

	// SENDING SEARCH POJO 'has data from pojo'
	public ArrayList<AcquirerPojo> addAcquirerveri(SearchPojo srchacquirer, String flag)
	{
		// 	RETURN ACCOUNT POJO 'from database'
		ArrayList<AcquirerPojo> addAcqu = new ArrayList<AcquirerPojo>();

		try {
			DatabaseConnection conn= new DatabaseConnection();
			Connection myconection=conn.openConnection();
			StringBuilder queryCond = new StringBuilder();

			//
			
			queryCond.append("SELECT\n" + 
					"m.MERCHANT_ID as mID,\n" + 
					"m.NAME_ARABIC_LANG as merchantArName,\n" + 
					"m.NAME_ENGLISH_LANG as merchantEnName,\n" + 
					"ms.NAME_PRIMARY_LANG as merchantStatus,\n" + 
					"AB.NAME_PRIMARY_LANG as aquirerBankName,\n" + 
					"pmt.NAME_PRIMARY_LANG as pmtType,\n" + 
					"btc.NAME_PRIMARY_LANG as billTypeName,\n" + 
					"medp.value as merchantParamValue,\n" + 
					"mpl.NAME_PRIMARY_LANG as merchantParam\n" + 
					"--csbt.id as xyz\n" + 
					"From Merchants m\n" + 
					"LEFT JOIN AQUIRE_BANK AB ON m.AQUIRER_BANK_ID = AB.ID\n" + 
					"LEFT JOIN PAYMENT_TYPES_LOOKUP pmt ON m.PAYMENT_TYPE_ID = pmt.ID\n" + 
					"LEFT JOIN MERCHANT_STATUS_LOOKUP ms ON m.MERCHANT_STATUS_ID = ms.ID\n" + 
					"lEFT JOIN BTC btc on m.id = btc.MERCHANT_ID\n" + 
					"lEFT JOIN MERCHANT_EXTRA_DEF_PARAMETERS medp on m.id = medp.MERCHANT_ID\n" + 
					"lEFT JOIN MERCHANT_PARAMETERS_LOOKUP mpl on medp.MERCHANT_PARAMETER_ID = mpl.id\n" + 
					"--lEFT JOIN CSP_BTC csbt on btc.id = csbt.BTC_ID\n" + 
					"where\n" + 
					"m.Merchant_id= '" +srchacquirer.getMerchant_ID() +"'\n"+	
					"AND ab.NAME_PRIMARY_LANG ='" +srchacquirer.getAcquirer_Bank()+"'\n"
					);
			
					

			ArrayList<String> myQuary= new ArrayList<String>(); 

			//System.out.println(srchacquirer.getAccountCode());
			
			ResultSet resultOfSearchAcquirer=conn.executeVerificationQuery(myconection, queryCond.toString());



			while(resultOfSearchAcquirer.next())
			{
				AcquirerPojo addAcquirer = new AcquirerPojo();
				addAcquirer.setArabic_Name(resultOfSearchAcquirer.getString("merchantArName")==null?"":resultOfSearchAcquirer.getString("merchantArName"));
				addAcquirer.setEnglish_Name(resultOfSearchAcquirer.getString("merchantEnName")==null?"":resultOfSearchAcquirer.getString("merchantEnName"));
				addAcquirer.setMerchantStatus(resultOfSearchAcquirer.getString("merchantStatus")==null?"":resultOfSearchAcquirer.getString("merchantStatus"));
				addAcquirer.setAcquirer_Bank(resultOfSearchAcquirer.getString("aquirerBankName")==null?"":resultOfSearchAcquirer.getString("aquirerBankName"));
				addAcquirer.setPayment_Type(resultOfSearchAcquirer.getString("pmtType")==null?"":resultOfSearchAcquirer.getString("pmtType"));
				addAcquirer.setAll_Bill_Types(resultOfSearchAcquirer.getString("billTypeName")==null?"":resultOfSearchAcquirer.getString("billTypeName"));
				addAcquirer.setValue(resultOfSearchAcquirer.getString("merchantParamValue")==null?"":resultOfSearchAcquirer.getString("merchantParamValue"));
				addAcquirer.setMerchant_Param(resultOfSearchAcquirer.getString("merchantParam")==null?"":resultOfSearchAcquirer.getString("merchantParam"));
				
				addAcqu.add(addAcquirer);
			}
			conn.closeDBConnection(myconection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return addAcqu;
	}


		

	public String add_and(ArrayList<String> myquary)
	{
		String newstring="";
		for(int i=0;i<myquary.size();i++)
		{
			newstring+=" AND "+myquary.get(i);
		}
		return newstring;
	}

}


