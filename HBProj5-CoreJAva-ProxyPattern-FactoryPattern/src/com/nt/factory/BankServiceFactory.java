package com.nt.factory;

import com.nt.command.BankServiceImpl;
import com.nt.command.IBankService;
import com.nt.proxy.BankServiceProxy;

public class BankServiceFactory {
    public static  IBankService  getInstance(boolean demonitiazation) {
    	IBankService  service=null;
    	        if(demonitiazation)
    	        	  service=new BankServiceProxy(); //proxy obj
    	        else
    	        	service=new BankServiceImpl(); //reaal obj
    	        return service;
    }
}
