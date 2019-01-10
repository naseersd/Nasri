package com.parker.techm.mdmcs.item;

import java.util.Collection;

import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.catalog.item.Item;
import com.ibm.pim.collection.PIMCollection;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunction;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunctionArguments;

public class MimMaxValues implements ScriptingSandboxFunction
{
	public void scriptingSandbox(ScriptingSandboxFunctionArguments arg0) 
	{
				
		Context ctx = PIMContextFactory.getCurrentContext();
		ctx.getAdminHelper().flushScriptCache();
		CatalogManager ctgMgr = ctx.getCatalogManager();
		Catalog ctgPmcs = ctgMgr.getCatalog("PMCS Repository");
		PIMCollection<Item> allItems = ctgPmcs.getItems();
		

}
	}