import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Table table1 = new Table();
        Table table2 = new Table();

        String fname;
        String lName;

        Queue <Person> waitList = new LinkedList<Person>();

        int check = 0;

        while(true)
        {
            do{
                System.out.println("Enter (1) to checkin someone or (2) to Check a person out: or -1 to exit ");
                try{
                    if(check == -1)break;
                    check = input.nextInt();
                }catch(Exception e)
                {
                    System.out.println("Incorrect value, Try again");
                    input.close();
                    System.exit(0);
                }
            }while(!(check >= 1 && check <= 2));
            
            input.nextLine();

            switch(check)
            {
                case 1:
                    System.out.println("Enter First Name: ");
                    fname = input.nextLine();
                    System.out.println("Enter Last Name: ");
                    lName = input.nextLine();
    
                    Person newCust = new Person(fname, lName);
                    //Checks if table is occupied, if so add to wait list
                    if(!table1.isOccupied())
                    {
                        checkin(newCust, table1);
                    }
                    else if(!table2.isOccupied())
                    {
                        checkin(newCust, table2);
                    }
                    else
                    {
                        waitList.add(newCust);
                        System.out.println(newCust.fName + " added to the waitlist");
                    }
                    break;
                case 2:
                    if(table1.isOccupied())
                    {
                        checkOut(table1);
                        if(!waitList.isEmpty())
                        {
                            checkin(waitList.remove(), table1);
                        }
                        else{
                            System.out.println("Wait list is empty, no one to be seated.");
                        }
                    }
                    else if(table2.isOccupied())
                    {
                        checkOut(table2);
                        if(!waitList.isEmpty())
                        {
                            checkin(waitList.remove(), table2);
                        }
                        else{
                            System.out.println("Wait list is empty, no one to be seated.");
                        }
                    }
                    else{
                        System.out.println("Wait list is empty, no one to be seated.");
                    }
                    break;
                case -1:
                input.close();
                    System.exit(0);
            }
        }
    }
    public static void checkin(Person p, Table tbl)
    {
        tbl.seatCustomer(p);
    }
    public static void checkOut(Table tbl)
    {
        tbl.removeCustomer();
    }
}
