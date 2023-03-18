import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //Creating Scanner object to invoke inside all the methods in Main class
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Initializing cabin array to store passenger inside each cabin.
        String[] cabin = new String[12];

        //Calling initialize method.
        initialize(cabin);

        //A menu for the user to select each option which will iterate until user enters a valid option or "Q' to quit the program.
        while (true) {
            System.out.println("_______________________________________________");
            String menu = "Welcome to Ship Menu\n\n" +
                    "A: Add a passenger\n" +
                    "V: View all cabins\n" +
                    "E: Display empty cabins\n" +
                    "D: Delete customer from cabins\n" +
                    "F: Find cabin from customer name\n" +
                    "S: Store program data into file\n" +
                    "L: Load program data from file\n" +
                    "O: View guests ordered alphabetically by name\n" +
                    "Q: Quit the program\n";

            System.out.println(menu);

            System.out.print("Enter your option out of 'A,V,E,D,F,S,L,O,Q' : ");
            String option = input.nextLine().toUpperCase();

            if (option.equals("A")) {
                addCustomer(cabin);
            } else if (option.equals("V")) {
                viewCabins(cabin);
            } else if (option.equals("E")) {
                emptyCabins(cabin);
            } else if (option.equals("D")) {
                deleteCustomer(cabin);
            } else if (option.equals("F")) {
                findCustomer(cabin);
            } else if (option.equals("S")) {
                storeDetails(cabin);
            } else if (option.equals("L")) {
                loadDetails();
            } else if (option.equals("O")) {
                passengerOrdering(cabin);
            } else if (option.equals("Q")) {
                break;
            } else {
                System.out.print("\nPlease enter a valid option.\n");
            }
        }
    }

    //Initializing all empty cabins.
    public static void initialize(String[] cabinIndex) {
        for (int x = 0; x < 12; x++ ) {
            cabinIndex[x] = "-";
        }
    }


    //A method to add a passenger to cabin.
    public static void addCustomer(String[] cabin) {
        boolean result = true;
        String optionB;
        System.out.println("ADD A PASSENGER\n");

        while (result) {
            try {
                System.out.print("Enter a cabin number (0 - 11) : ");
                int cNumber = input.nextInt();

                //Checking if the entered cabin number is valid.
                if (cNumber < 0 || cNumber > 11) {
                    System.out.println("Please enter a valid cabin number.\n");
                    continue;
                }

                //Checking if the entered cabin is empty.
                if (!(cabin[cNumber].equals("-"))) {
                    System.out.println("Cabin " + cNumber + " is already occupied by " + cabin[cNumber]);

                    //Ask to add another user or not
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
                        break;
                    }else {
                        continue;
                    }
                }

                //Get passenger name
                System.out.print("Enter the customer's name for cabin no " + cNumber + " : ");
                String name = input.next().toUpperCase();
                cabin[cNumber] = name;


                //Displaying the entered details by the user for the cabin.
                System.out.println(cabin[cNumber]+" successfully added to cabin " + cNumber);

                //Ask to add another user or not
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

    //A method to view the current state of every cabin inside the ship.
    public static void viewCabins(String[] cabin) {
        System.out.println("_______________________________________________");
        System.out.println("VIEW ALL CABINS\n");

        for (int cabinNumber = 0; cabinNumber < cabin.length; cabinNumber++ ) {
            if (cabin[cabinNumber].equals("-")) {
                System.out.println("Cabin " + cabinNumber + " is empty");
            } else {
                System.out.println("Cabin " + cabinNumber + " is occupied by " + cabin[cabinNumber]);
            }
        }
    }

    //A method to view all the empty cabins available inside the ship.
    public static void emptyCabins(String[] cabin) {
        System.out.println("_______________________________________________");
        System.out.println("DISPLAY EMPTY CABINS\n");

        //Initializing a variable to count the number of empty cabins.
        int emptyCabins = 0;

        for (int cabinNum = 0; cabinNum < cabin.length; cabinNum++ ) {
            if (cabin[cabinNum].equals("-")) {
                System.out.println("Cabin " + cabinNum + " is empty");
                emptyCabins += 1;
            }
        }

        //Displaying a message if all the cabins are full.
        if (emptyCabins == 0) {
            System.out.println(" All the cabins are full.");
        }
    }

    //A method to delete a passenger in cabin.
    public static void deleteCustomer(String[] cabin) {
        boolean result = true;
        String optionB;

        System.out.println("_______________________________________________");
        System.out.println("DELETE PASSENGER FROM CABIN\n");

        while (result) {
            try {
                System.out.print("Enter a cabin number (0 - 11) : ");
                int cNumber = input.nextInt();
                input.nextLine();

                //Checking if the entered cabin number is valid.
                if (cNumber < 0 || cNumber >11) {
                    System.out.println("Please enter a valid cabin number.\n");
                    continue;
                }

                //Checking if the entered cabin is empty or not.
                if (cabin[cNumber].equals("-")) {
                    System.out.println("Cabin " + cNumber + "is empty");
                } else {
                    System.out.println(cabin[cNumber] + " successfully deleted from cabin " + cNumber);
                    cabin[cNumber] = "-";
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid cabin number.\n");
                input.nextLine();
            }

            //Ask to delete another passenger or not
            while (true) {
                System.out.println("Do you want to delete another passenger?");
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
        }
    }

    //A method to find a cabin by customer name.
    public static void findCustomer(String[] cabin) {
        //Initializing a variable to check if the cabin is found.
        boolean notFound = true;

        System.out.println("_______________________________________________");
        System.out.println("FIND CABIN FROM PASSENGER'S NAME\n");

        while (notFound) {

            System.out.print("Enter the passenger's name : ");
            String pName = input.next().toUpperCase();
            input.nextLine();

            for (int cabinNum = 0; cabinNum < cabin.length; cabinNum++ ) {
                if (cabin[cabinNum].equals(pName)) {
                    System.out.println(pName + " is in cabin no " + cabinNum);
                    notFound = false;
                }
            }

            //Displaying a message if the cabin is not found.
            if (notFound) {
                System.out.println("Your search -  " + pName + " - did not match any passenger.");
            }

        }
    }

    //A method to store the program data into a file as a table.
    public static void storeDetails(String[] cabin) {
        System.out.println("_______________________________________________");
        System.out.println("STORE PROGRAM DATA INTO FILE\n");

        try {
            FileWriter oFile = new FileWriter("Udara Cabin.txt");
            //Setting the column headings.
            oFile.write("Cabin\tPassenger's name\n\n");

            for (int caninNum = 0; caninNum < cabin.length; caninNum++ ) {
                //Checking if the cabin is empty or not.
                if (cabin[caninNum].equals("-")) {
                    oFile.write(  caninNum + "\t\t-\n");
                } else {
                    oFile.write( caninNum + "\t\t" + cabin[caninNum]+"\n");
                }
            }

            oFile.close();
            System.out.println("Successfully stored the data in to the file 'Udara Cabin.txt'.");
        } catch (IOException e) {
            System.out.println("Storing fail");
        }
    }

    //A method to load the program data from a file.
    public static void loadDetails() {
        System.out.println("_______________________________________________");
        System.out.println("LOAD THE PROGRAM DATA FROM FILE\n");

        try {
            File iFile = new File("Udara Cabin.txt");
            Scanner Reader = new Scanner(iFile);

            while (Reader.hasNextLine()) {
                System.out.println(Reader.nextLine());
            }
            Reader.close();
            System.out.println("\nSuccessfully loaded data from file 'Udara Cabin.txt'.");
        } catch (IOException e) {
            System.out.println("Failed to load the data");
        }
    }

    //A method to organize passengers names in alphabetical order.
    public static void passengerOrdering(String[] cabin) {
        System.out.println("_______________________________________________");
        System.out.println("VIEW PASSENGER'S NAME IN ALPHABETICAL \n");

        String[] sortedArray = new String[12];
        //Initializing a variable to count the number of empty cabins.
        int eCabins = 0;

        //Making a duplicate of the array.
        for (int i = 0; i < cabin.length; i++) {
            if (cabin[i].equals("-")) {
                eCabins += 1;
            }
            sortedArray[i] = cabin[i];
        }

        //Checking if all the cabins are empty or not.
        if (eCabins == 12) {
            System.out.println("All cabins are empty");
        } else {


            for (int i = 0; i < sortedArray.length - 1; i++){
                for(int j = 0; j <= sortedArray.length - 2; j++){
                    if (sortedArray[j].compareTo(sortedArray[j + 1]) > 0) {
                        String temp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = temp;
                    }
                }
            }

            for (String name : sortedArray) {
                //Checking if the cabins is not empty.
                if (!(name.equals("-"))) {
                    System.out.print(name);
                    for (int k = 0; k < cabin.length; k++) {
                        if (cabin[k].equals(name)) {
                            System.out.println(" (is in cabin " + k + ")");
                        }
                    }
                }
            }
        }
    }
}
