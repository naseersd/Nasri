package com.parker.techm.mdmcs.item;

import java.io.PrintWriter;

import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.catalog.item.Item;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunction;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunctionArguments;

public class DisplayItem implements ScriptingSandboxFunction
{
	public void scriptingSandbox(ScriptingSandboxFunctionArguments arg0) 
	{
		Context ctx = PIMContextFactory.getCurrentContext();
		
		ctx.getAdminHelper().flushScriptCache();
		CatalogManager catLg = ctx.getCatalogManager();
		Catalog catalog = catLg.getCatalog("PMCS Repository");
		Item listitem = catalog.getItemByPrimaryKey("949464541");		
		Double val = (Double) listitem.getAttributeValue("PMCS Part Info Spec/Weight");
		String val1 = (String) listitem.getAttributeValue("PMCS Part Info Spec/Part Description");
		String val2 = (String) listitem.getAttributeValue("PMCS Part Info Spec/Weight UOM");
		String val3 = (String) listitem.getAttributeValue("PMCS Part Info Spec/Product Code");
		PrintWriter pW = arg0.getOutput();
		pW.write("Weight is : "+val);
		pW.write("Part Description : "+val1);
		pW.write("Weight UOM : "+val2);
		pW.write("Product Code : "+val3);		
		
	}
	}