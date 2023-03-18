import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        cShip cabinList = new cShip(12);
        //printing menu
        System.out.println("---Welcome to Cruise Ship Boarding Cabin--- ");

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
                    "T: View expenses  data from file\n" +
                    "O: View guests in alphabetical order by name\n" +
                    "Q: Quit the program\n";

            System.out.println(menu);

            System.out.print("Enter your option out of 'A,V,E,D,F,S,L,O,Q' : ");
            String option = input.nextLine().toUpperCase();

            if (option.equals("V")) {
                cabinList.viewCabins();
            } else if (option.equals("A")) {
                cabinList.addPassengers();
            } else if (option.equals("E")) {
                cabinList.displayEmptyCabins();
            } else if (option.equals("D")) {
                cabinList.deletePassengers();
            } else if (option.equals("F")) {
                cabinList.findCabin();
            } else if (option.equals("S")) {
                cabinList.storeData();
            } else if (option.equals("L")) {
                cabinList.loadData();
            } else if (option.equals("O")) {
                cabinList.passengersByAlphabetically();
            } else if (option.equals("T")) {
                cabinList.expense();
            } else if (option.equals("Q")) {
                break;
            } else {
                System.out.print("\nPlease enter a valid option.\n");
            }
        }
    }
}
