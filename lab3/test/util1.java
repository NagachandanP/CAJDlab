package test;
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class util1{

public float ShowOffer(String org,float totalPrice) throws Exception {
System.out.println("offer");
String couponCode;
		float tprice=0.0f;
		// create properties object
        	Properties p = new Properties();
		
  		
		p.setProperty("AM1K", "20");
		p.setProperty("AM2K", "35");
		p.setProperty("AM3K", "40");

		p.setProperty("SP1K", "5");
		p.setProperty("SP2K", "10");
		p.setProperty("SP3K", "20");
		
		p.store(new FileWriter("discount.properties"),"Properties Written");
		
	
	FileReader reader = new FileReader("discount.properties");
        	
		p.load(reader);
		System.out.println("Your Total price is: "+totalPrice);
		if(totalPrice<=1000)
		{ 
		tprice=totalPrice;
		return tprice;
		}


		if(totalPrice>=1000 && totalPrice<2000)
		{
		couponCode=org+"1K";
		System.out.println("You're Eligible for a Offer with coupon");
		System.out.println("Coupon code  : "+couponCode);
		
		tprice=ApplyCoupon(couponCode,totalPrice);
		}
		if(totalPrice>=2000 && totalPrice<3000)
		{
		couponCode=org+"2K";
		System.out.println("You're Eligible for a Offer with coupon");
		System.out.println("Coupon code  : "+couponCode);
		tprice=ApplyCoupon(couponCode,totalPrice);
		}
		
		if(totalPrice>=3000 )
		{
		couponCode=org+"3K";
		System.out.println("You're Eligible for a Offer with coupon");
		System.out.println("Coupon code : "+couponCode);
		tprice=ApplyCoupon(couponCode,totalPrice);
		}
return tprice;

}

public float ApplyCoupon(String couponCode,float totalPrice) throws Exception {
float price=(float)totalPrice;
System.out.println("coupon");

FileReader reader = new FileReader("discount.properties");
// create properties object
        		Properties p = new Properties();
			p.load(reader);

float disPer=Float.parseFloat(p.getProperty(couponCode));
			System.out.println(disPer+"% discount");
			price=price-price*(disPer/100);
			System.out.println("Total price has to pay: "+price);

return price;
}
}