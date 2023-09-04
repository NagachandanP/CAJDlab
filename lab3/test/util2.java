package test;
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class util2{

public void Pay(float totalPrice) throws Exception {
int id=101,success=0;
System.out.println("Pay");

Scanner sc = new Scanner(System.in);
System.out.println("Your Total cost: "+totalPrice);
		Properties p = new Properties();
		System.out.println("Please Enter that amount: ");
		String amt=sc.next();
		float amount=Float.parseFloat(amt);
	if(amount==totalPrice){
		p.setProperty("TransID", Integer.toString(id++));
		p.store(new FileWriter("info.properties",true),"Properties Written");
		System.out.println("Payment of "+totalPrice+" Successfull");
		success=1;
		System.out.println("----------------------------------------");
		util2 payment=new util2();
	payment.Details();
	
		}
	else{
	System.out.println("----------------------------------------");
	System.out.println("Please Enter the Correct Amount");
	System.out.println("----------------------------------------");
	success=0;
	}
	
		
		
	
}

public void Details()  throws Exception {
System.out.println("Details");
FileReader reader = new FileReader("info.properties");
  
        // create properties object
        Properties p = new Properties();
	p.load(reader);
	

	System.out.println("Your Transaction ID: "+p.getProperty("TransID"));
}
}