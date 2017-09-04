package UI;

import Model.TakeAway;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TakeAway newTakeAway = new TakeAway();
        int ch=0;

        do{
            System.out.println("\n1-) Place Order \n2-) Check order status \n3-) Print status\n");
            ch=sc.nextInt();
            switch (ch){
                case 1: newTakeAway.order();
                        break;
                case 2: newTakeAway.checkOrderStatus();
                        break;
                case 3: newTakeAway.printOrder();
                        break;
            }
        }while(ch!=0);
    }
}
