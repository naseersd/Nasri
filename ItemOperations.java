package com.parker.techm.mdmcs.item;

import java.io.PrintWriter;

import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.catalog.item.Item;
import com.ibm.pim.collection.PIMCollection;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunction;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunctionArguments;

public class ItemOperations implements ScriptingSandboxFunction
{
	public void scriptingSandbox(ScriptingSandboxFunctionArguments arg0) 
	{
				
		Context ctx = PIMContextFactory.getCurrentContext();
		ctx.getAdminHelper().flushScriptCache();
		CatalogManager ctgMgr = ctx.getCatalogManager();
		Catalog ctgPmcs = ctgMgr.getCatalog("PMCS Repository");
		Catalog ctgPur = ctgMgr.getCatalog("Purchased Parts Repository");
		
	//*********PMCS Repository All Items Count****************	
		
		PIMCollection<Item> allItems = ctgPmcs.getItems();
		int totalSizPMCS = allItems.size();		
		PrintWriter pW = arg0.getOutput();
		pW.write("\n Total Count of PMCS Parts : "+ totalSizPMCS);
		
	//*********Purchase parts Repository All Items Count**********		
		
		PIMCollection<Item> allItems2 = ctgPur.getItems();
		int totalSizePUR = allItems2.size();		
		PrintWriter pW1 = arg0.getOutput();
		pW1.write("\n Total Count of PURC Parts: "+totalSizePUR);
		
	//**********Inserting New Values In PMCS************	
		
		Item listitem = ctgPmcs.getItemByPrimaryKey("949464541");	
		listitem.setAttributeValue("PMCS Part Info Spec/Weight", "15");
		listitem.setAttributeValue("PMCS Part Info Spec/Part Description", "TAPE INDICATOR New");
		listitem.setAttributeValue("PMCS Part Info Spec/Weight UOM","KG");
	    listitem.setAttributeValue("PMCS Part Info Spec/Product Code","UMPkar");
		PrintWriter pW2 = arg0.getOutput();
		//pW2.println(listitem.save());
		pW2.write("\n Items Saved Succesfully");
		
	//**************Displaying Values In PMCS***************
		
		Item listitem1 = ctgPmcs.getItemByPrimaryKey("949464541");		
		Double val = (Double) listitem1.getAttributeValue("PMCS Part Info Spec/Weight");
		String val1 = (String) listitem1.getAttributeValue("PMCS Part Info Spec/Part Description");
		String val2 = (String) listitem1.getAttributeValue("PMCS Part Info Spec/Weight UOM");
		String val3 = (String) listitem1.getAttributeValue("PMCS Part Info Spec/Product Code");
		PrintWriter pW3 = arg0.getOutput();
		pW3.write("\n Weight is : "+val);
		pW3.write("\n Part Description : "+val1);
		pW3.write("\n Weight UOM : "+val2);
		pW3.write("\n Product Code : "+val3);
}
}