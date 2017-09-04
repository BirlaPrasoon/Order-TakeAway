package Model;

import java.util.Scanner;

public class TakeAway {

    private String customerName;
    private int customerID=1111;
    private String instructions;
    private char comboID;
    private long orderTime;
    private final long timeForCompletion = 20000;
    private double price=30;
    private int ticketID=1000;

    private static int countCustomer=0;
    private static int countTicket=0;
    Scanner sc = new Scanner(System.in);

    public TakeAway(){
        customerID +=countCustomer++;
    }

    // Modifies: this
    // Requires: comboID should be b/w A and D otherwise it'll be none.
    // Effects: takes the required input and sets as the object variables.
    //          also sets the current System time as the order time.
    public void order(){

            System.out.println("1)- Enter name: ");
            customerName = sc.nextLine();
            System.out.println("2)- Enter instructions:");
            instructions = sc.next();
            System.out.println("3)- Enter comboID:");
            comboID = sc.next().charAt(0);
            if(((int) comboID)< ((int)'A') || ((int) comboID) > ((int)'D'))
                comboID='\u0000';

            orderTime = System.currentTimeMillis();
            setPrice();
        }

        // Effects: returns true if the current system time is timeCompletion milliseconds greater than
                //  the order time also prompts the user to take their order.
                // otherwise returns false and asks the user to sit back and relax, the order is in progress.
        public boolean checkOrderStatus(){
            if(System.currentTimeMillis() >= (orderTime + timeForCompletion)) {
             System.out.println("You can take your order.");
                return true;
            }
            System.out.print("Wait for some time order in progress.");
            return false;
        }

        //Effects: if the current order statuc is true (ready) prints the order status
                // including all the details of the user, and the orderID, price.
        public void printOrder(){
            ticketID+=countTicket++;
            if(!checkOrderStatus()){
                System.out.println("Order has not been booked yet.");
                return ;
            }
            System.out.println("CustomerID: "+ customerID);
            System.out.println("Name: "+ customerName);
            System.out.println("Ticket ID: "+ ticketID++);
            System.out.println("Order: "+ instructions);
            System.out.println("comboID: "+ comboID);
            System.out.println("Price: "+ price);

        }

        //Effects: depending upon the value of comboID, sets the price of the order.
    private void setPrice(){
            switch (comboID){
                case 'A': price-= 5;
                        break;
                case 'B': price-=10;
                        break;
                case 'C': price-=15;
                        break;
                case 'D': price-=20;
                        break;
                default: break;
            }
    }
    // For testing purposes
    public String getName(){
        return customerName;
    }
    
    // For testing
    public char getComboID(){
        return comboID;
    }
    
    // For testing
    public void setComboID(char C){
        this.comboID = C;
        if(((int)this.comboID) <((int)'A')||((int)this.comboID)>((int)'D'))
            this.comboID='\u0000';
    }

    // For testing
    public int getCustomerID(){
        return customerID;
    }

    // For testing 
    public double getPrice(){
        setPrice();
        return price;
    }
}
