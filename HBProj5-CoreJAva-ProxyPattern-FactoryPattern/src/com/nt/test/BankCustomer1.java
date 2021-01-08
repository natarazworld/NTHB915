package com.nt.test;

import com.nt.command.IBankService;
import com.nt.factory.BankServiceFactory;
import com.nt.proxy.BankServiceProxy;

public class BankCustomer1 {

	public static void main(String[] args) {
		IBankService  service=BankServiceFactory.getInstance(true);
		  System.out.println(service.withdraw(1001, 20000));
		  System.out.println("...................................");
			IBankService  service1=BankServiceFactory.getInstance(false);
			  System.out.println(service1.withdraw(1001, 20000));

	}

}
