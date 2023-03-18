import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cShip {
    Cabin[] cabins;
    Scanner input = new Scanner(System.in);

    //Creating a static circularQueue object to use inside all the static methods inside cabin class.
    static CircularQueue queue = new CircularQueue();

    cShip(int size) {
        cabins = new Cabin[size];
        for (int i = 0; i < size; i++) {
            cabins[i] = new Cabin(i ,0);   //initializing cabin with cabin number and passenger count.
        }
    }

    public void addPassengers() {
        int cNumber;
        double cExpense;
        int pCount;
        boolean result = true;
        String optionB;

        System.out.println("ADD A PASSENGER\n");

        while (result) {

            int eCabins = 0;
            for (int x = 0; x < cabins.length; x++) {
                if (cabins[x].getPassengersCount()==0) {   //checking cabin is empty
                    eCabins++;
                }
            }

            if(eCabins==0){
                //Displaying a message if both the cabin and the waiting list is full.
                if (queue.isFull()) {
                    System.out.println("Sorry! all the cabins and waiting list are  full.");
                    break;
                } else {
                    //Adding the passengers in to a waiting list if the queue is not full.
                    System.out.println("There are no empty cabins. You will be added to the waiting list.\n");
                    Cabin lastPosition = queue.enQueue();

                    //input the cabin number
                    while (true) {
                        try {
                            //get passenger count
                            System.out.print("Enter passenger count for cabin (1-3) : ");

                            pCount = input.nextInt();

                            //Checking if the entered passenger count is valid.
                            if (pCount < 1 || pCount > 3) {
                                System.out.println("Please enter a valid passenger count.\n");
                            } else {
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("Enter an integer for passenger count...");
                            input.nextLine();
                        }
                    }

                    //Get passenger details
                    for (int i = 0; i < pCount; i++) {
                        System.out.println("Enter the passenger's first name for cabin :");
                        String customerFirstName = input.next().toUpperCase();
                        System.out.println("Enter the passenger's surname for cabin :");
                        String customerSurname = input.next().toUpperCase();

                        //input the passenger expense
                        while (true) {
                            System.out.print("Enter the passenger " + i + "'s expense : Rs");
                            try {
                                //get cabin number
                                cExpense = input.nextInt();
                                break;
                            } catch (Exception e) {
                                System.out.println("Enter expense correctly...");
                                input.nextLine();
                            }
                        }

                        if (lastPosition.getPassenger1().getFirstName().equals("-")) {
                            lastPosition.getPassenger1().setFirstName(customerFirstName);
                            lastPosition.getPassenger1().setSurname(customerSurname);
                            lastPosition.getPassenger1().setExpenses(cExpense);
                        } else if (lastPosition.getPassenger2().getFirstName().equals("-")) {
                            lastPosition.getPassenger2().setFirstName(customerFirstName);
                            lastPosition.getPassenger2().setSurname(customerSurname);
                            lastPosition.getPassenger2().setExpenses(cExpense);
                        } else if (lastPosition.getPassenger3().getFirstName().equals("-")) {
                            lastPosition.getPassenger3().setFirstName(customerFirstName);
                            lastPosition.getPassenger3().setSurname(customerSurname);
                            lastPosition.getPassenger3().setExpenses(cExpense);
                        }
                    }
                    lastPosition.setPassengersCount(pCount);
                    System.out.println("Successfully passengers added to the waiting list ");
                    break;
                }
            }else {

                try {
                    //get cabin number
                    System.out.print("Enter a cabin number cabin (0 - 11) : ");
                    cNumber = input.nextInt();

                    //Checking if the entered cabin number is valid.
                    if (cNumber < 0 || cNumber > 11) {
                        System.out.println("Please enter a valid cabin number.\n");
                        continue;
                    }

                    //Checking if the entered cabin is empty.
                    if (!(cabins[cNumber].getPassengersCount() == 0)) {
                        System.out.println("Cabin " + cNumber + " is already occupied by " + cabins[cNumber].getPassengersCount() + "passengers");

                        //Ask to add another user or not
                        while (true) {
                            System.out.println("Do you want to add passengers to another cabin?");
                            System.out.println("press (Y/N)");
                            optionB = input.next().toUpperCase();
                            if (optionB.equals("Y") || optionB.equals("N")) {
                                break;
                            } else {
                                System.out.println("Wrong input... Try again...");
                            }
                        }

                        if (optionB.equals("N")) {
                            result = false;
                            input.nextLine();
                            break;
                        } else {
                            continue;
                        }
                    }

                    //input passenger count
                    while (true) {
                        try {
                            //get passenger count
                            System.out.print("Enter passenger count for cabin (1-3) : ");
                            pCount = input.nextInt();

                            //Checking if the entered passenger count is valid.
                            if (pCount >0 && pCount < 4) {
                                break;
                            } else {
                                System.out.println("Please enter a valid passenger count.\n");
                            }

                        } catch (Exception e) {
                            System.out.println("Enter an integer for passenger count...");
                            input.nextLine();
                        }
                    }

                    //Get passenger details
                    for (int i = 0; i < pCount; i++) {
                        System.out.println("Enter the passenger's first name for cabin " + cNumber + " :");
                        String customerFirstName = input.next().toUpperCase();
                        System.out.println("Enter the passenger's surname for cabin " + cNumber + " :");
                        String customerSurname = input.next().toUpperCase();

                        //passenger expense input
                        while (true) {
                            System.out.print("Enter the passenger " + i + "'s expense : Rs");
                            try {
                                //get cabin number
                                cExpense = input.nextInt();
                                break;
                            } catch (Exception e) {
                                System.out.println("Enter the expenses correctly...");
                                input.nextLine();

                            }
                        }

                        //Set passenger details
                        if (cabins[cNumber].getPassenger1().getFirstName().equals("-")) {
                            cabins[cNumber].getPassenger1().setFirstName(customerFirstName);
                            cabins[cNumber].getPassenger1().setSurname(customerSurname);
                            cabins[cNumber].getPassenger1().setExpenses(cExpense);
                        } else if (cabins[cNumber].getPassenger2().getFirstName().equals("-")) {
                            cabins[cNumber].getPassenger2().setFirstName(customerFirstName);
                            cabins[cNumber].getPassenger2().setSurname(customerSurname);
                            cabins[cNumber].getPassenger2().setExpenses(cExpense);
                        } else if (cabins[cNumber].getPassenger3().getFirstName().equals("-")) {
                            cabins[cNumber].getPassenger3().setFirstName(customerFirstName);
                            cabins[cNumber].getPassenger3().setSurname(customerSurname);
                            cabins[cNumber].getPassenger3().setExpenses(cExpense);
                        }
                        cabins[cNumber].setPassengersCount(pCount);
                    }
                    System.out.println("passengers added completely...\n");

                    //Ask to add new passenger set or not
                    while (true) {
                        System.out.println("Do you want to add another passenger?");
                        System.out.println("press (Y/N)");
                        optionB = input.next().toUpperCase();
                        if (optionB.equals("Y") || optionB.equals("N")) {
                            break;
                        } else {
                            System.out.println("Wrong input... Try again...");
                        }
                    }

                    if (optionB.equals("N")) {
                        result = false;
                        input.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid cabin number.\n");
                    input.nextLine();
                }
            }
        }
    }

    public void viewCabins() {   //to view all cabins.
        for (int x = 0; x < cabins.length; x++) {
            if (cabins[x].getPassengersCount()==0) {   //checking the cabin is empty
                System.out.println("cabin "+ cabins[x].getCabinNumber()+" is empty ");
                System.out.println();
            } else {
                System.out.println("\nCabin number :- " + cabins[x].getCabinNumber() +"\n\nPassenger 1 details \nFirst name :- " + cabins[x].getPassenger1().getFirstName() +"\nSurname :- "+ cabins[x].getPassenger1().getSurname() + "\nExpense :- "+ cabins[x].getPassenger1().getExpenses() +"\n\nPassenger 2 details \nFirst name :- " + cabins[x].getPassenger2().getFirstName() +"\nSurname :- "+ cabins[x].getPassenger2().getSurname() + "\nExpense :- "+ cabins[x].getPassenger2().getExpenses()+"\n\nPassenger 3 details \nFirst name :- " + cabins[x].getPassenger3().getFirstName() +"\nSurname :- "+ cabins[x].getPassenger3().getSurname() + "\nExpense :- "+ cabins[x].getPassenger3().getExpenses());
                System.out.println();
            }
        }
    }

    public void displayEmptyCabins() {   // view all empty cabins.

        System.out.println( "Cabin-Number\t\t" + "Status");
        System.out.println();

        for (int x = 0; x < cabins.length; x++) {
            if (cabins[x].getPassengersCount()==0) {   //checking cabin is empty
                System.out.println( cabins[x].getCabinNumber() + "\t\t\t\t\tAvailable");
                System.out.println();
            }
        }

    }

    public void deletePassengers() { //deleting the passengers
        int cNumber = 0;
        boolean result = true;
        String optionB;
        boolean cabinOEmpty = false;

        while(true) {

            int eCabins = 0;
            for (int x = 0; x < cabins.length; x++) {
                if (cabins[x].getPassengersCount()==0) {   //checking cabin is empty
                    eCabins++;
                }
            }

            if(eCabins==0){
                cabinOEmpty = true;
            }

            while (result) {
                try {
                    //get cabin number
                    System.out.print("Enter a cabin number (0 - 11) to delete passengers : ");
                    cNumber = input.nextInt();

                    //Checking if the entered cabin number is valid.
                    if (cNumber < 0 || cNumber > 11) {
                        System.out.println("Please enter a valid cabin number.\n");
                        continue;
                    }

                    //Checking if the entered cabin is empty.
                    if (cabins[cNumber].getPassengersCount() == 0) {
                        System.out.println("This cabin is empty");

                        //Ask to delete another user or not
                        while (true) {
                            System.out.println("Do you want to delete another passenger set?");
                            System.out.println("press (Y/N)");
                            optionB = input.next().toUpperCase();
                            if (optionB.equals("Y") || optionB.equals("N")) {
                                break;
                            } else {
                                System.out.println("Wrong input... Try again...");
                            }
                        }

                        if (optionB.equals("N")) {
                            result = false;
                            input.nextLine();
                            break;
                        }
                    } else {
                        cabins[cNumber].getPassenger1().setFirstName("-");
                        cabins[cNumber].getPassenger1().setSurname("-");
                        cabins[cNumber].getPassenger1().setExpenses(0);
                        cabins[cNumber].getPassenger2().setFirstName("-");
                        cabins[cNumber].getPassenger2().setSurname("-");
                        cabins[cNumber].getPassenger2().setExpenses(0);
                        cabins[cNumber].getPassenger3().setFirstName("-");
                        cabins[cNumber].getPassenger3().setSurname("-");
                        cabins[cNumber].getPassenger3().setExpenses(0);
                        cabins[cNumber].setPassengersCount(0);
                        System.out.println("Passenger deleted");
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid cabin number.\n");
                    input.nextLine();
                }
            }


            //Checking if all the cabins are full.
            if (cabinOEmpty) {
                //Adding the customer into the deleted cabin from the waiting list if the queue is not empty.
                if (!(queue.isEmpty())) {
                    //Getting the details of the person who is in the front of the queue.
                    Cabin frontPerson = queue.deQueue();

                    //Storing the details to the deleted cabin from the waiting list.
                    cabins[cNumber].setCabinNumber(cNumber);
                    cabins[cNumber].getPassenger1().setFirstName(frontPerson.getPassenger1().getFirstName());
                    cabins[cNumber].getPassenger1().setSurname(frontPerson.getPassenger1().getSurname());
                    cabins[cNumber].getPassenger1().setExpenses(frontPerson.getPassenger1().getExpenses());
                    cabins[cNumber].getPassenger2().setFirstName(frontPerson.getPassenger2().getFirstName());
                    cabins[cNumber].getPassenger2().setSurname(frontPerson.getPassenger2().getSurname());
                    cabins[cNumber].getPassenger2().setExpenses(frontPerson.getPassenger2().getExpenses());
                    cabins[cNumber].getPassenger3().setFirstName(frontPerson.getPassenger3().getFirstName());
                    cabins[cNumber].getPassenger3().setSurname(frontPerson.getPassenger3().getSurname());
                    cabins[cNumber].getPassenger3().setExpenses(frontPerson.getPassenger3().getExpenses());
                    cabins[cNumber].setPassengersCount(frontPerson.getPassengersCount());

                    //Clearing the information of the added passengers from the waiting list.
                    frontPerson.getPassenger1().setFirstName("-");
                    frontPerson.getPassenger1().setSurname("-");
                    frontPerson.getPassenger1().setExpenses(0);
                    frontPerson.getPassenger2().setFirstName("-");
                    frontPerson.getPassenger2().setSurname("-");
                    frontPerson.getPassenger2().setExpenses(0);
                    frontPerson.getPassenger3().setFirstName("-");
                    frontPerson.getPassenger3().setSurname("-");
                    frontPerson.getPassenger3().setExpenses(0);
                }
            }

            //Ask to delete another user or not
            while (true) {
                System.out.println("Do you want to delete another passenger set?");
                System.out.println("press (Y/N)");
                optionB = input.next().toUpperCase();
                if (optionB.equals("Y") || optionB.equals("N")) {
                    break;
                } else {
                    System.out.println("Wrong input... Try again...");
                }
            }

            if (optionB.equals("N")) {
                input.nextLine();
                break;
            }
        }
    }

    public void findCabin() {
        System.out.println("Enter the customer's first name to find the cabin number :");
        String passengerFname= input.next().toUpperCase();
        for(int i = 0; i< cabins.length; i++){
            if(cabins[i].getPassenger1().getFirstName().equals(passengerFname)|| cabins[i].getPassenger2().getFirstName().equals(passengerFname)|| cabins[i].getPassenger3().getFirstName().equals(passengerFname)){       //checking customer name
                System.out.println(passengerFname + "'s cabin number is " + cabins[i].getCabinNumber());
            }
        }
    }

    public void storeData(){
        try{
            File outTXT = new File("Udara ship.txt");
            FileWriter fileW = new FileWriter(outTXT);


            fileW.write("Cruise Ship Boarding Cabin Data File\n\n");

            for (int x = 0; x < cabins.length; x++) {
                if (cabins[x].getPassengersCount()==0) {   //checking cabin is empty
                    fileW.write(cabins[x].getCabinNumber()+ "empty cabin");
                    fileW.write("\n");
                } else {
                    fileW.write("\nCabin number :- " + cabins[x].getCabinNumber() +"\n\nPassenger 1 details \nFirst name :- " + cabins[x].getPassenger1().getFirstName() +"\nSurname :- "+ cabins[x].getPassenger1().getSurname() + "\nExpense :- "+ cabins[x].getPassenger1().getExpenses() +"\n\nPassenger 2 details \nFirst name :- " + cabins[x].getPassenger2().getFirstName() +"\nSurname :- "+ cabins[x].getPassenger2().getSurname() + "\nExpense :- "+ cabins[x].getPassenger2().getExpenses()+"\n\nPassenger 3 details \nFirst name :- " + cabins[x].getPassenger3().getFirstName() +"\nSurname :- "+ cabins[x].getPassenger3().getSurname() + "\nExpense :- "+ cabins[x].getPassenger3().getExpenses());
                    fileW.write("\n");
                }
            }
            fileW.close();

            System.out.println("Data Storing complete\n");

        }catch (IOException e){
            System.out.println("File not written...");
        }
    }

    public void loadData(){
        int line = 0;
        try {
            File fileR = new File("Udara ship.txt");
            Scanner myReader = new Scanner(fileR);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(line>0) {
                    System.out.println(data);
                }
                line++;
            }
            System.out.println("Data loading is completed\n");


        }catch (FileNotFoundException e){
            System.out.println("File not Found...");
        }
    }

    public void passengersByAlphabetically(){
        int emptyCabins = 0;
        int cn=0;
        String[] sortedArray = new String[36];
        for (int tcn = 0; tcn < (cabins.length)*3; tcn+=3) {
            if (cabins[cn].getPassenger1().getFirstName().equals("-")) {   //checking cabin is empty
                emptyCabins += 1;
            }
            sortedArray[tcn] = cabins[cn].getPassenger1().getFirstName();
            sortedArray[tcn+1] = cabins[cn].getPassenger2().getFirstName();
            sortedArray[tcn+2] = cabins[cn].getPassenger3().getFirstName();

            cn++;
        }

        if(emptyCabins==12){
            System.out.println("All cabins are empty");
        }else {

            for (int i = 0; i < sortedArray.length - 1; i++){
                for(int j = 0; j <= sortedArray.length - 2; j++){
                    if (sortedArray[j].compareTo(sortedArray[j + 1]) > 0) {
                        String temp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = temp;
                    }
                }
            }

            for (int tcn = 0; tcn < sortedArray.length; tcn+=1) {
                String name = sortedArray[tcn];
                if(!(name.equals("-"))){
                    System.out.print(name);
                    for (int k = 0; k < cabins.length; k++) {
                        if(cabins[k].getPassenger1().getFirstName().equals(name)|| cabins[k].getPassenger2().getFirstName().equals(name)|| cabins[k].getPassenger3().getFirstName().equals(name)){       //checking customer name

                            System.out.println("\t  " + k);
                        }
                    }
                }
            }
        }

    }

    public void expense() {
        String optionB;
        double totalExpenses = 0;

        //Ask to add new passenger set or not(1 passenger expense or total expenses
        while (true) {
            System.out.println("Do you want");
            System.out.println("1. Total expense \n2. Expenses per passenger");
            optionB = input.next().toUpperCase();
            if (optionB.equals("1") || optionB.equals("2")) {
                break;
            } else {
                System.out.println("Wrong input... Try again...");
            }
        }

        if(optionB.equals("1")){  //cal tot expenses
            for (int x = 0; x < cabins.length; x++) {
                totalExpenses = totalExpenses+cabins[x].getPassenger1().getExpenses()+ cabins[x].getPassenger2().getExpenses() + cabins[x].getPassenger3().getExpenses();
            }
            System.out.println("Total expenses for ship : Rs"+totalExpenses);
        } else if (optionB.equals("2")){
            for (int x = 0; x < cabins.length; x++) {
                System.out.println("Cabin "+x);
                System.out.println("passenger 1 expense : Rs"+cabins[x].getPassenger1().getExpenses());
                System.out.println("passenger 2 expense : Rs"+cabins[x].getPassenger2().getExpenses());
                System.out.println("passenger 3 expense : Rs"+cabins[x].getPassenger3().getExpenses());
            }
        }
    }
}
