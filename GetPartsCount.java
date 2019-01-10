package com.parker.techm.mdmcs.item;

import java.io.PrintWriter;

import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.catalog.item.Item;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunction;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunctionArguments;

public class GetPartsCount implements ScriptingSandboxFunction
{
	public void scriptingSandbox(ScriptingSandboxFunctionArguments arg0) 
	{
		Context ctx = PIMContextFactory.getCurrentContext();
		ctx.getAdminHelper().flushScriptCache();
		
		CatalogManager ctgMgr = ctx.getCatalogManager();
		Catalog pmcsCtg = ctgMgr.getCatalog("PMCS Repository");
		Item currentItem = pmcsCtg.getItemByPrimaryKey("19375827");
		Double val = (Double) currentItem.getAttributeValue("PMCS Part Info Spec/Weight"); 
		
		//currentItem.setAttributeValue("PMCS Part Info Spec/Weight", "55");
		//currentItem.save();
	
		PrintWriter pW = arg0.getOutput();
		pW.write("Weight is : "+val);
	}
}
