package utilities;
import java.util.*;
import java.io.*;
import java.util.Scanner; 

 public class TakePayment  
{ int id=101,success=0;
	Scanner sc = new Scanner(System.in);
	public int pay(float totalPrice) throws Exception
	{
		System.out.println("Your Total cost: "+totalPrice);
		Properties p = new Properties();
		System.out.println("Please Enter that amount: ");
		String amt=sc.next();
		float amount=Float.parseFloat(amt);
	if(amount==totalPrice){
		p.setProperty("TransID", Integer.toString(id++));
		p.store(new FileWriter("info.properties"),"Properties Written");
		System.out.println("Payment of "+totalPrice+" Successfull");
		success=1;
		System.out.println("----------------------------------------");
	
		}
	else{
	System.out.println("Please Enter the Correct Amount");
	System.out.println("----------------------------------------");
	success=0;
	}
	TakePayment payment=new TakePayment();
	payment.printMsg();
		
		
	return 0;
	}

	public void printMsg()throws Exception
	{
	FileReader reader = new FileReader("info.properties");
  
        // create properties object
        Properties p = new Properties();
	p.load(reader);
	

	System.out.println("Your Transaction ID: "+p.getProperty("TransID"));
	}
	
	
}