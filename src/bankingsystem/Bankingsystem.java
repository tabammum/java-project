package bankingsystem;
import java.util.Scanner;
import java.util.HashMap;
public class Bankingsystem {
 static void createSavingsAccount(int accNum, String name, float balance, HashMap hm){
	    SavingsAccount sa = new SavingsAccount(name , balance);
        hm.put(accNum,sa);
        System.out.println("Savings Account Created successfully with account Number - " + accNum );
	}
	static void createCurrentAccount(int accNum, String name, float balance, HashMap hm){
		CurrentAccount cu = new CurrentAccount(name , balance);
		hm.put(accNum,cu);
        System.out.println("Current Account Created successfully with account Number - " + accNum );
	}
   
    public static void main(String[] args) {
     int x,am,o,ac,r,yr,s,accNum = 1100;
            float bal;
            String n;
	         	//Scanner input = new Scanner(System.in);//
            HashMap<String, SavingsAccount> sav = new HashMap<>();
            HashMap<String, CurrentAccount> cur = new HashMap<>();
           createSavingsAccount(101,"n", 100.1f , sav);
            while (true){
                try{
                System.out.println("\nOptions:\n1)Create Account\n2)Change Interest Rate\n3) Add Interest \n4)Deposit Money");
                System.out.print("5)Withdraw Money\n6)Transfer Amount\n7)Show Account Info\n8)Exit\n \n---> ");
               Scanner input = new Scanner(System.in);
               o = input.nextInt();
                switch(o){

                    case 1 : //Creating a new account
                        System.out.print("\n 1) Create SavingsAccount\n 2) Create CurrentAccount \n---> ");
                        x = input.nextInt();
                        input.nextLine();
                        System.out.print("\nEnter name : ");
                        n = input.nextLine();
                        System.out.print("\nEnter Balance : ");
                        bal = input.nextFloat();
                        if(x==1){
                            createSavingsAccount(accNum , n , bal , sav );
                            accNum++;
                        }
                        else if(x==2){
                            createCurrentAccount(accNum, n, bal, cur);
                            accNum++;
                        }
                        else{
                            System.out.println(" Wrong Option !!!");
                        }
                        break;

                    case 2 : //Change Interest Rate
                        System.out.print("\n Enter new interest rate : ");
                        bal = input.nextFloat();
                        sav.get(101).changeInterest(bal);
                        //cur.get(accNum).changeInterest(bal);
                        break;

                    case 3 : //Update Balance after adding Interest
                        System.out.print("\n 1) Savings Account Update \n 2) Current Account Update \n---> ");
                        x= input.nextInt();
                        System.out.println("Enter Account number : ");
                        ac = input.nextInt();
                        System.out.println("Enter year of interest : ");
                        yr = input.nextInt();
                        if(x==1){
                            sav.get(ac).addInterest(yr);
                            System.out.print("\n Balance Updated Successfully\n New Balance - " + sav.get(ac).balance);
                            break;
                        }
                        else if(x==2){
                            cur.get(ac).addInterest(yr);
                            System.out.print("\n Balance Updated Successfully\n New Balance - " + cur.get(ac).balance);
                            break;
                        }
                        else{
                            System.out.println("Wrong Option !!!");
                        }

                    case 4 : //Deposit Money
                        System.out.print("\n 1) To Savings Account \n 2) To Current Account \n---> ");
                        x= input.nextInt();
                        System.out.print("\n Enter Account Number : ");
                        ac = input.nextInt();
                        System.out.print("\n Enter Amount : ");
                        am = input.nextInt() ;
                        if (x==1){
                            sav.get(ac).deposite(am);
                            System.out.print("\n Current Balance - " + sav.get(ac).balance);
                            break;
                        }
                        else if(x==2){
                            cur.get(ac).deposite(am);
                            System.out.print("\n Current Balance - " + cur.get(ac).balance);
                            break;
                        }
                        else {
                            System.out.println("Wrong Option!!!");
                        }
                        break;

                    case 5 : //Withdraw Money
                        System.out.print("\n 1) From Savings Account \n 2) From Current Account \n---> ");
                        x = input.nextInt();
                        System.out.print("\n Enter Account Number : ");
                        ac = input.nextInt();
                        System.out.print("\n Enter Amount : ");
                        am = input.nextInt();
                        if (x==1){
                            sav.get(ac).withdraw(am);
                            System.out.print("\n Current Balance- " + sav.get(ac).balance);
                            break;
                        }
                        else if(x==2){
                            cur.get(ac).withdraw(am);
                            System.out.print("\n Current Balance - " + cur.get(ac).balance);
                            break;
                        }
                        else {
                            System.out.println("Wrong Option!!!");
                        }
                        break;

                    case 6 : //Transfer Amount
                        System.out.println(" 1) From Savings to Saving Account");
                        System.out.println(" 2) From Savings to Current Account");
                        System.out.println(" 3) From Current to Savings Account");
                        System.out.println(" 4) From Current to Current Account \n --->");
                        x= input.nextInt();
                        System.out.print("\n Enter Sender Account Number : ");
                        s = input.nextInt();
                        System.out.print("\n Enter Reciever Account Number : ");
                        r = input.nextInt();
                        System.out.print(" Enter Amount : ");
                        am = input.nextInt();

                        if(x==1){
                            sav.get(s).withdraw(am);
                            sav.get(r).deposite(am);
                            System.out.println("Recievers Current Balance " + sav.get(r).balance );
                        }
                        else if(x==2){
                            sav.get(s).withdraw(am);
                            cur.get(r).deposite(am);
                            System.out.println("Recievers Current Balance " + cur.get(r).balance );
                        }
                        else if(x==3){
                            cur.get(s).withdraw(am);
                            sav.get(r).deposite(am);
                            System.out.println("Recievers Current Balance " + sav.get(r).balance );
                        }
                        else if(x==4){
                            cur.get(s).withdraw(am);
                            cur.get(r).deposite(am);
                            System.out.println("Recievers Current Balance " + cur.get(r).balance );
                        }
                        else{
                            System.out.println("Wrong option !");
                        }
                        break;

                    case 7 : //Show Account Info
                        System.out.println(" 1) Savings Account Info \n 2) Current Account Info \n---> ");
                        x = input.nextInt();
                        System.out.println("Enter Account number : ");
                        accNum = input.nextInt();
                        if(x==1){
                            System.out.println("Name : " + sav.get(accNum).name);
                            System.out.println("Balance : " + sav.get(accNum).balance);
                        }
                        else if (x==2){
                            System.out.println("Name : " + cur.get(accNum).name);
                            System.out.println("Balance : " + cur.get(accNum).balance);
                        }
                        else{
                            System.out.println("Wrong Option!!!");
                        }
                        break;

                    case 8 : //Exit
                        break;

                    default : //Invalid Option
                        System.out.println("Invalid Option!!!");
                }
            }
                catch(Exception e){
                }
            
	}
    }      
   
 

}

    