import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

interface welcome
{
    public void disp();
}


class risha implements welcome
{
    public void disp()
    {
        System.out.println(" WELCOME TO THE PIZZA STORE");

    }

}//delivery

class delii
{
    static int ary[][]=new int[10][10];
    static int completed[]=new int[10];
    static int n,ccost=0,kmin;
    public static void tspp()
    {
        takeInput();

        System.out.println("\n\nThe Path is:\n");
        mincost(0); //passing 0 because starting vertex

        System.out.println("\n\nMinimum cost is "+ccost);
    }


    public static void takeInput()
    {
        int i,j;
        System.out.println("The cost list is:");

        for( i=0;i < n;i++)
        {
            System.out.println("");

            for(j=0;j < n;j++)
                System.out.println(ary[i][j]);
        }
    }

    public static int least(int c)
    {
        int i,nc=999;
        int min=999;

        for(i=0;i < n;i++)
        {
            if((ary[c][i]!=0)&&(completed[i]==0))
                if(ary[c][i]+ary[i][c] < min)
                {
                    min=ary[i][0]+ary[c][i];
                    kmin=ary[c][i];
                    nc=i;
                }
        }

        if(min!=999)
            ccost+=kmin;

        return nc;
    }

    public static void mincost(int city)
    {
        int i,ncity;

        completed[city]=1;

        System.out.print((city+1)+"--->");
        ncity=least(city);

        if(ncity==999)
        {
            ncity=0;
            System.out.println(ncity+1);
            ccost+=ary[city][ncity];

            return;
        }

        mincost(ncity);
    }


    public void rr()
    {

        System.out.println("ThankYou!!");

    }

    public void rr(String joy)
    {
        System.out.println(joy);
    }
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner keyboard = new Scanner(System.in);
        risha obj=new risha();
        delii obj1=new delii();
        obj.disp();

        //  Variables

        String firstName; // first name of user
        char crustType; int ch;
        String crust; // name of crust
        int inches; // pizza size
        double cost = 0.0; // pizza cost
        final double taxRate = 0.08; // amount tax owed
        double tax; // tax amount
        double total; // total of pizza + toppings
        double lastTotal; // total of everything
        int numberOfToppings = 0;
        String toppings = "Cheese";
//int i,j;

        // Prompts for name & determines discount
        System.out.println("Enter your name: ");
        firstName = keyboard.nextLine();

        //Prompts for distance
        double distance = 0;
        double deliveryfee = 0;
        System.out.println("Please enter total distance in miles from pizza shop (0 for in store pickup):");
        distance = keyboard.nextDouble();
        if (distance == 0) {
            deliveryfee = 0;
            System.out.println("There is no delivery fee.");
        } else if (distance > 1) {
            deliveryfee = ((distance * 0.5) + 2);
            System.out.println("Your delivery fee is: $" + df.format(deliveryfee));
        } else if (distance > 0) {
            deliveryfee = 2.00;
            System.out.println("Your delivery fee is: $" + df.format(deliveryfee));
        }

        // Prompts for pizza size
        System.out.print("What size of pizza would you like (diameter in inches)? (10,   12, 14, or 16) ");
        inches = keyboard.nextInt();
        if (inches == 10) {
            cost = 10.99;
        } else if (inches == 12) {
            cost = 12.99;
        } else if (inches == 14) {
            cost = 14.99;
        } else if (inches == 16) {
            cost = 16.99;
        } else if (inches != 10 && inches != 12 && inches != 14 && inches != 16) {
            System.out.println("The number you have entered is illegal, your pizza size will    be set to 12 inches. ");
            cost = 12;
        }
        keyboard.nextLine();

        // Prompts user for type of crust
        System.out.print("What type of crust do you want? (H)and-Tossed, (T)hin-crust, or (D)eep-dish (enter H, T, or D,): ");
        crustType = keyboard.nextLine().charAt(0);

        if (crustType == 'H' || crustType == 'h') {
            crust = "Hand-Tossed";
        } else if (crustType == 'T' || crustType == 't') {
            crust = "Thin-Crust";
        } else if (crustType == 'D' || crustType == 'd') {
            crust = "Deep-Dish";
        } else if (crustType != 'H' && crustType != 'h' && crustType != 'T' && crustType != 't' && crustType != 'D' && crustType != 'd') {
            System.out.println("The crust type you have entered is illegal, your crust type will be set to hand-tossed. ");
        }
        crust = "Hand-Tossed";

        // Prompts user for additonal toppings
        System.out.println("All pizzas come with cheese.");
        System.out.println("Additional toppings are $1.25 each, choose from Pepperoni or Sausage.");

        // Pepperoni
        System.out.println("Do you want Pepperoni? (Y/N)");
        numberOfToppings = keyboard.nextLine().charAt(0);
        if (numberOfToppings == 'Y' || numberOfToppings == 'y') {
            numberOfToppings = numberOfToppings + 1;
            toppings = toppings + " and Pepperoni";
        } else {
        }

        //Sausage
        System.out.println("Do you want Sausage? (Y/N)");
        numberOfToppings = keyboard.nextLine().charAt(0);
        if (numberOfToppings == 'Y' || numberOfToppings == 'y') {
            numberOfToppings = numberOfToppings + 1;
            toppings = toppings + " and Sausage";
        } else {
        }

        // Calculations
        System.out.println(cost);
        System.out.println(numberOfToppings);
        System.out.println(deliveryfee);
        total = (cost) + (numberOfToppings * 1.25) + (deliveryfee);
        tax = total * taxRate;
        lastTotal = total * (1 + taxRate);

        // Payment Confirmation
        System.out.println(firstName + ", here is your order:");
        System.out.println(inches + " inch pizza");
        System.out.println(crust + ", " + toppings);
        System.out.println("Order Cost: $" + df.format(total));
        System.out.println("Tax: $" + df.format(tax));
        System.out.println("Total Due: $" + df.format(lastTotal));
        System.out.println("********Only for Staff********");
        System.out.println("Do you want to use the tsp function? 1/0?");
        ch=keyboard.nextInt();
        if(ch == 1 )
        {
            obj1.tspp();


            System.out.println("Enter the number of deliveries: ");
            n= keyboard.nextInt();

            System.out.println("Enter the Cost Matrix");

            for(int i=0;i < n;i++)
            {
                System.out.println("Enter Elements of Row: "+i+1);


                for(int j=0;j < n;j++)
                    ary[i][j]= keyboard.nextInt();

                completed[i]=0;
            }//for

            System.out.println("The Path is:");
            mincost(0); //passing 0 because starting vertex

            System.out.println("Minimum cost is "+ccost);


        }//if_ch
        else
            System.out.println("ThankYou!! Visit us Next");

        obj1.rr();
        obj1.rr("COME BACK SOON");
    }
}