package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements IPaymentDAO {

	@Override
	public void saveData() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//begin Transaction
			tx=ses.beginTransaction();
			  //prepare objs
			 CardPayment cardPayment=new CardPayment();
			 cardPayment.setAmount(75676777.0);
			 cardPayment.setCardNo(123455566L);
			 cardPayment.setCardType("credit-card");
			 cardPayment.setGateway("VISA");
			 
			 ChequePayment chequePayment=new ChequePayment();
			 chequePayment.setAmount(54545435.0);
			 chequePayment.setChequeType("SELF");
			 chequePayment.setChequeNo(112344567L);
			 //save objs
			 ses.save(cardPayment);
			 ses.save(chequePayment);
			 tx.commit();
			 System.out.println("Objects are saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving objects");
			}
		}//catch

	}//saveData
	
	@Override
	public void loadData() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			System.out.println("-----------Using Payment--------------");
			Query query=ses.createQuery("from Payment");
			List<Payment> list=query.getResultList();
			list.forEach(payment->{
				System.out.println(payment);
			});
			System.out.println("-----------Using CardPayment--------------");
			Query query1=ses.createQuery("from CardPayment");
			List<CardPayment> list1=query1.getResultList();
			list1.forEach(cpayment1->{
				System.out.println(cpayment1);
			});
			System.out.println("-----------Using ChequePayment--------------");
			Query query2=ses.createQuery("from ChequePayment");
			List<ChequePayment> list2=query2.getResultList();
			list2.forEach(chpayment2->{
				System.out.println(chpayment2);
			});
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			}
	}

}//class
