package utilities;
import java.util.*;
import java.io.*;
import java.util.Scanner; 


public class Discount{
		
		public float showOffers(String org,int totalPrice)throws Exception
		{
		
		String couponCode;
		float tprice=0.0f;
		// create properties object
        	Properties p = new Properties();
		
  		p.setProperty("starts", "000");
		p.store(new FileWriter("discount.properties",true),"Properties Written");

		FileReader reader = new FileReader("discount.properties");
        	
		p.load(reader);
		
		if(totalPrice>=1000 && totalPrice<2000)
		{
		couponCode=org+"1K";
		
		System.out.println("Coupon code Applied : "+couponCode);
		tprice=applyCoupon(couponCode,totalPrice);
		}
		
		if(totalPrice>=2000 && totalPrice<3000)
		{
		couponCode=org+"2K";
		System.out.println("Coupon code Applied : "+couponCode);
		tprice=applyCoupon(couponCode,totalPrice);
		}
		
		if(totalPrice>=3000 )
		{
		couponCode=org+"3K";
		System.out.println("Coupon code Applied : "+couponCode);
		tprice=applyCoupon(couponCode,totalPrice);
		}
return tprice;
		
		}

		public float applyCoupon(String couponCode,int totalPrice)throws Exception
		{	
			float price=(float)totalPrice;
			
			FileReader reader = new FileReader("discount.properties");
  
        	// create properties object
        		Properties p = new Properties();
			p.load(reader);
			
			float disPer=Float.parseFloat(p.getProperty(couponCode));
			System.out.println(disPer+"% discount");
			price=price-price*(disPer/100);
			System.out.println("Total price has to pay: "+price);

			//TakePayment payment=new TakePayment();
			//payment.pay(price);
			return price;
		}

}