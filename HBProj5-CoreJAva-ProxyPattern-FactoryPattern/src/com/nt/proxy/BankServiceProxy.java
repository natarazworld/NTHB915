package com.nt.proxy;

import com.nt.command.BankServiceImpl;
import com.nt.command.IBankService;

public class BankServiceProxy implements IBankService {
	private IBankService  real;
	public BankServiceProxy() {
		  real=new BankServiceImpl();
	}

	@Override
	public String withdraw(long acno, double amount) {
		if(amount<4000)
			return real.withdraw(acno, amount);
		else
			return  real.withdraw(acno, 4000);
	}

}
