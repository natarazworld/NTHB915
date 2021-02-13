//RandomIdGenerator.java
package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerator implements IdentifierGenerator {
	
	public RandomIdGenerator() {
		System.out.println("RandomIdGenerator:: 0-param constructor");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("RandomIdGenerator.generate(-)");
		  //generate random number
		Random rad=new Random();
		int idVal=rad.nextInt(100000);
		
		return new Long(idVal);  // returns  id value as the Long wrapper class obj (which Serializable obj internally)
	}

}
