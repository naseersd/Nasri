package com.parker.techm.mdmcs.item;

import java.io.PrintWriter;

import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunction;
import com.ibm.pim.extensionpoints.ScriptingSandboxFunctionArguments;

public class GetCount implements ScriptingSandboxFunction
{
	public void scriptingSandbox(ScriptingSandboxFunctionArguments arg0) 
	{
		PrintWriter pW = null;
		try
		{
			Context ctx		 = PIMContextFactory.getCurrentContext();
			
			CatalogManager ctg	 = ctx.getCatalogManager();
		    Catalog pmcsrep		 = ctg.getCatalog("Digital Asset Repository");
		    int a				 =  pmcsrep.getItems().size();
		    pW		 = arg0.getOutput();
		    pW.write("Size of catalog : "+a);
	
		}
		catch(Exception e)
		{
			pW.write("Exception : "+e);
		}
	}

}
