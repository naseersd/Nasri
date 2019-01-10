package com.parker.techm.mdmcs.item;

import java.io.PrintWriter;

import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.catalog.item.Item;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunction;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunctionArguments;

public class InsertItem implements ScriptingSandboxFunction
{
	public void scriptingSandbox(ScriptingSandboxFunctionArguments arg0) 
	{
		PrintWriter pw = arg0.getOutput();
		Context ctx = PIMContextFactory.getCurrentContext();
		ctx.getAdminHelper().flushScriptCache();
		CatalogManager catLg = ctx.getCatalogManager();
		Catalog catalog = catLg.getCatalog("PMCS Repository");
		Item listitem = catalog.getItemByPrimaryKey("949464541");	
		listitem.setAttributeValue("PMCS Part Info Spec/Weight", "15");
		listitem.setAttributeValue("PMCS Part Info Spec/Part Description", "TAPE INDICATOR New");
		listitem.setAttributeValue("PMCS Part Info Spec/Weight UOM","KG");
	    listitem.setAttributeValue("PMCS Part Info Spec/Product Code","UMPkar");
		pw.println(listitem.save());	
		
		
		
		
	}
}