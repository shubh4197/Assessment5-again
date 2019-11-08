import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 int option = 0;
		
	        Scanner s = new Scanner(System.in);
            doa fd=new doa();
		 
		  do{
	            System.out.println("\nMENU");
	            System.out.println("If stockManager then:");
	            System.out.println("1. Add Product");
	            System.out.println("2. Update List of Products in Stock");
	            System.out.println("3. Delete Product details in the stock");
	            System.out.println("4. Print Product details in the stock");
	            System.out.println("Option:");
	            option=s.nextInt();
	            switch (option){
                case 1:
                    try { 
                	fd.addProducts(); 
                    }catch(Validation ex) {
                    	System.err.println(ex.getMessage());
                    }
                    break;
                case 2:
                	try {
                	System.out.println("Name of the product to update:");
                	String name=s.next();
                	fd.updateProduct(name);
                   }catch(Validation ex) {
                		System.err.println(ex.getMessage());
                	}
                break;
                case 3:
                	System.out.println("Name of the product to delete:");
                	String name1=s.next();
                	fd.deleteProduct(name1);
                	break;
                	
                case 4:
                    List<Products> gh=fd.printProducts();
                    for(Products i:gh)
                    {
                    	System.out.println(i);
                    }
 //                	Boolean isValid=true;
//                	int flag=0;
//                	do {
//                	try {
//                		j.cart(k);
//                		isValid=true;
//                		System.out.println("Do you want to add more items in the cart");
//                		System.out.println("0.No");
//                		System.out.println("1.Yes");
//                		flag=s.nextInt();
//                	}catch(Validation ex) {
//                		System.err.println(ex.getMessage());
//                		isValid=false;
//                		System.out.println("Add item again");
//                	}}while(isValid==false||flag==1);
//                	break;
//                case 5:
//                	j.generatebill();
//                	break;
//                	
                default:
                	option=8;
                	break;
            }
        }while ( option !=8);	

	}

}
