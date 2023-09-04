import test.util1;
import test.util2;
import java.util.Scanner;
public class app2 {
    public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in); 
	int ch,qty;
	float price;

	ch= menu();
	price= price(ch); 



if(price!=0){
	price=quantity(price);
	
	doPayment(price);
        
}

    }

 static int menu(){
int choice;
Scanner sc = new Scanner(System.in); 

System.out.println("(In KGs)\n1.Rice\n2.Daal\n3.Onion\n4.Tomato\n5.Apple\n6.exit\n\nEnter Choice: ");
choice=sc.nextInt();
return choice;
}

 static float price(int choice){

switch(choice){

case 1: return 1001.0f;
case 2: return 2001.0f;
case 3: return 3001.0f;
case 4: return 150.0f;
case 5: return 1500.0f;

case 6: System.exit(0);

default: System.out.println("No valid choices");


}
return 0;
}

static float quantity(float price){
int qty;

Scanner sc = new Scanner(System.in); 

System.out.println("Enter the Quantity: ");
qty=sc.nextInt();

price=price*qty;

return price;
}


static void doPayment(float price) throws Exception
{
	util1 u1=new util1();
	price=u1.ShowOffer("SP",price);
	util2 u2=new util2();
	u2.Pay(price);
}
}