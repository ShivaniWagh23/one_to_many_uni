package com.jsp.person.accounts;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestPersonAccounts {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	Person person= new Person();
	person.setName("shivani");
	person.setEmail("shiv@mail.com");
	person.setCno(8495672685l);
    person.setGender("female");	
    
    Account account1=new Account();
    account1.setAccno(856210002354l);
    account1.setBank_name("SBI");
    account1.setIfsc_code("SBI588BVF87");
    
    Account account2=new Account();
    account2.setAccno(46210002354l);
    account2.setBank_name("hdfc");
    account2.setIfsc_code("HDFC2541");
    
    Account account3=new Account();
    account3.setAccno(32210002354l);
    account3.setBank_name("Maharashtra");
    account3.setIfsc_code("MAHARASHTRA2541");
    
    ArrayList<Account> account=new ArrayList<Account>();
    account.add(account1);
    account.add(account2);
    account.add(account3);
   
    
//    set a person with multiple accounts
    person.setAccount(account);
    
    entityTransaction.begin();
    entityManager.persist(person);
    entityManager.persist(account1);
    entityManager.persist(account2);
    entityManager.persist(account3);
entityTransaction.commit();

}
}
