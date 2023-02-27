

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Represents a farm which have cows and vets
 * A farm can have many cows raising and many vets working for
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.5
 */
public class FarmMe {

    public ArrayList<Cow> cows;
    public ArrayList<Veterinary> vets;

    /**
     * Class constructor for no parameters given
     * Creates an instance of the object with empty arraylist of cows and vets
     */
    public FarmMe() {
        cows = new ArrayList<>();
        vets = new ArrayList<>();
    }

    /**
     * Method to add a cow object into the arraylist;cows
     * Requesting required information to create cow object
     * Creating a cows object with given information
     * Adding to cows variable with cows.add
     */
    public void addCow() {
        Scanner in = new Scanner(System.in);
        System.out.println("Entering a new cow to the list of cows...");
        String gender;
        int tagNo;
        Date dateOfBirth = new Date();
        boolean purchased;

        System.out.print("Please enter the gender of the cow: ");
        gender = in.next();
        do {
            System.out.print("Please enter the tagNo of the cow: ");
            tagNo = in.nextInt();
            if (searchCow(tagNo) != -1) {
                System.out.println("A cow with this tag no exists please enter another tagno..");
            }

        } while (searchCow(tagNo) != -1);

        //For parsing string to date
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the birthdate of cow: ");
        String input = in.next();// Be careful about next
        try {
            dateOfBirth = ft.parse(input);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }

        System.out.print("Purchased(1) or farm-raising(0): ");//Errorler yapılabilir
        int purchasedCheck = in.nextInt();
        if (purchasedCheck == 1) {
            purchased = true;
        } else {
            purchased = false;
        }

        Cow newCow = new Cow(tagNo, gender, dateOfBirth, purchased);
        cows.add(newCow);
        System.out.println("\nCow succesfuly added...\n");
        menu();

    }

    /**
     * Searching for cow with the given tagNo in the list of cows
     * If found save the index number of the cow and delete from the cows list
     * If not found print relevant error message
     * @param tagNo tag number of the cow
     */
    public void deleteCow(int tagNo) {
        int indexToDelete = searchCow(tagNo);

        if (indexToDelete != -1) {
            cows.remove(indexToDelete);
            System.out.println("The cow with tagNo :" + tagNo + " is succesfully deleted");
        } else {
            System.out.println("There is no cow with this tagNo!");
        }

        menu();
    }
    /**
     * List all the cows in the list
     */
    public void listCow() {// Done
        System.out.println("Listing all the cows in the farm...");

        for (int i = 0; i < cows.size(); i++) {
            cows.get(i).printDetails();
        }
        System.out.println("\nEnd of the list.");

        menu();
    }
    /**
     * With the given tagNo searchs all the cows in the list
     * If found return its index
     * If not found return -1 to tell there is no cow with fiven tagNo
     */
    public int searchCow(int tagNo) {// Returns the index of the cow in arraylist if the cow found else zero
        for (int i = 0; i < cows.size(); i++) {
            if (cows.get(i).getTagNo() == tagNo) {
                return i;//returning its index in the list
            }
        }
        return -1; // In case which cow did not getfound
    }
    /**
     * Searchs all the vets according to given vetID
     * If found returns the index of the vet in the list
     * If not found return -1 to tell there is no veterinary with given Vet ID
     * @return index of the vet or -1
     * @param vetID unique vet identification number of the vet
     */
    public int searchVet(int vetID) {// Does the same operation as above for vets
        for (int i = 0; i < vets.size(); i++) {
            if (vets.get(i).getVetID() == vetID) {
                return i;//returning its index in the list
            }
        }
        return -1;
    }
    /**
     * Search for the cow in the list with the given tagNo
     * If found display its details with using printDetails method in Cow class
     * If not found display an error message
     * @param tagNo tag number of the cow
     */
    public void getCowDetails(int tagNo) {// DONE

        int foundIndex = searchCow(tagNo);

        if (foundIndex != -1) {
            System.out.println("The details of the cow with given tagNo is: ");
            cows.get(foundIndex).printDetails();
        } else {
            System.out.println("There is no cow found with tagNo !" + tagNo);
        }
        menu();
    }
    /**
     * Asking user for required information to create a vet object
     * Creates a vet object with given information
     * Adds the created vet object into the vet list
     */
    public void addVet() {
        int vetID;
        String gender;
        Date dateOfBirth = new Date();
        double salary;
        Scanner in = new Scanner(System.in);

        System.out.print("\nNew vet is being added...\n");
        do {
            System.out.print("Enter the vetID: ");
            vetID = in.nextInt();
            if (searchVet(vetID) != -1) {
                System.out.println("A vet with this ID exists. Please enter a unique ID");
            }
        } while (searchVet(vetID) != -1);
        System.out.print("Enter the gender: ");
        gender = in.next();

        //For parsing string to date
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the birthdate of the vet: ");
        String input = in.next();
        try {
            dateOfBirth = ft.parse(input);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }

        System.out.print("Enter the salary: ");
        salary = in.nextDouble();

        Veterinary newVet = new Veterinary(vetID, gender, dateOfBirth, salary);
        vets.add(newVet);
        System.out.println("\nNew vet successfully added...");
        menu();

    }
    /**
     *  Searching for vet object in the vets list with the given vetID
     *  If found delete the veterinary from the list of vets
     *  If not found display appropriate error message
     * @param vetID unique vet identification number of the vet
     */
    public void deleteVet(int vetID) {
        int indexToDelete = searchVet(vetID);

        if (indexToDelete != -1) {
            vets.remove(indexToDelete);
            System.out.println("The vet with vetID :" + vetID + " is succesfully deleted");
        } else {
            System.out.println("There is no vet with this vetID!");
        }
        menu();
    }
    /**
     * Displaying all the vets in the vets list
     */
    public void listVet() {
        System.out.println("Listing all the vets...");
        for (int i = 0; i < vets.size(); i++) {
            vets.get(i).printDetails();
        }
        menu();
    }
    /**
     * Search for the vet with the given vetID in the vets list
     * If found display vet's details
     * If not found display relevant error message
     * @param vetID unique vet identification number of the vet
     */
    public void getVetDetails(int vetID) {//Done
        int indexFound = searchVet(vetID);
        if (indexFound != -1) {
            System.out.println("Vet found!");
            vets.get(indexFound).printDetails();
        } else {
            System.out.println("A vet with vetID: " + vetID + " could not found!");
        }
        menu();
    }


    /**
     * First searching if there is a vet with given ID and there is a cow with given tagNo
     * Then asking for required information to create treatment
     * Creating treatment object
     * Asking how many medications there will be for this treatment
     * Asking for necessary information to create medication object in a loop for the number of medications
     * Iteratively assigning medications to the created treatment
     * @param vetID unique vet identification number of the vet
     * @param tagNo tag number of the cow
     */
    public void addTreatment(int vetID, int tagNo) {

        // Finding the index places in the array list using search method
        int cowIndex = searchCow(tagNo);
        int vetIndex = searchVet(vetID);
        if (cowIndex == -1 || vetIndex == -1) {
            System.out.println("There is no matching vet and cow!");
        } else {
            Scanner in = new Scanner(System.in);
            String details;
            Date dateOfTreatment = new Date();

            System.out.print("Enter the details of treatment: ");
            details = in.nextLine();

            //For parsing string to date
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Enter the date of Treatment: ");
            String input = in.next();// Be careful about nexts
            try {
                dateOfTreatment = ft.parse(input);
            } catch (ParseException e) {
                System.out.println("Unparseable using " + ft);
            }
            int noOfMedication = 0;
            System.out.print("Enter the number of medications needed for this treatment: ");
            noOfMedication = in.nextInt();

            Treatment newTreatment = new Treatment(dateOfTreatment, details);

            //Assigning treatments to vet and cow
            vets.get(vetIndex).setTreatment(newTreatment);
            cows.get(cowIndex).getTreatments().add(newTreatment);

            for (int i = 0; i < noOfMedication; i++) {
                System.out.print("For No." + i + " Medication enter the following\n");
                System.out.print("Details: ");//Here I could manage to get details with two scans
                details = in.next();
                details = in.nextLine(); //Instead of creating another variable for details of medication I will overwrite the value of the first one
                System.out.print("Duration: ");
                int duration = in.nextInt();
                System.out.print("Start date: ");
                Date startDate = new Date();
                input = in.next();
                try {
                    startDate = ft.parse(input);
                } catch (ParseException e) {
                    System.out.println("Unparseable using " + ft);
                }
                System.out.print("Dosage of medication: ");
                double dosage = in.nextDouble();
                System.out.print("The notes on medication: ");
                String notes = in.nextLine();
                notes = in.nextLine();//Here I could manage to get details with two scans

                Medication newMedication = new Medication(details, duration, startDate, dosage, notes);
                newTreatment.getMedications().add(newMedication); // Adding into medications array list in treatment
            }
        }
        System.out.println("Treatment is added succesfully");
        menu();
    }
    /**
     * Search for the cow with the given tagNo
     * If found get number of treatments that it has
     * After getting the size of treatments display them in a loop
     * @param tagNo tag number of the cow
     */
    public void getCowTreatment(int tagNo) {
        int foundIndex = searchCow(tagNo);
        if (foundIndex == -1) {
            System.out.println("There is no cow with given tagno");
        } else {
            int sizeOfTreatments = cows.get(foundIndex).getTreatments().size();
            if (sizeOfTreatments == 0) {// No treatment implemented yet
                System.out.println("There is no treatment given to this cow!");
            } else {
                for (int i = 0; i < sizeOfTreatments; i++) {
                    cows.get(foundIndex).getTreatments().get(i).printTreatment();
                }
            }
        }
        menu();
    }
    /**
     * Searching for the cow with the given tag No
     * If found search with the given Date in treatments list
     * If there is a treatment with given Date display it
     * If could not found with spesific information display relevant error message
     * @param tagNo tag number of the cow
     * @param dateOfTreatment the date which treatment has assigned to
     */
    public void getCowTreatment(int tagNo, Date dateOfTreatment) {
        int foundIndex = searchCow(tagNo);//TODO: Yaparsak program çok güzelleşir
        if (foundIndex == -1) {
            System.out.println("There is no cow with given tag no");
        } else {
            int sizeOfTreatments = cows.get(foundIndex).getTreatments().size();
            if (sizeOfTreatments == 0) {// No treatment implemented yet
                System.out.println("There is no treatment given to this cow!");
            } else {
                for (int i = 0; i < sizeOfTreatments; i++) {
                    if (cows.get(foundIndex).getTreatments().get(i).getDateOfTreatment().compareTo(dateOfTreatment) == 0) {//Checking if dates are equal
                        cows.get(foundIndex).getTreatments().get(i).printTreatment();
                    }
                }
            }
        }
        menu();
    }
    /**
     * Terminating the program with succesful completion
     */
    public void exit() {
        System.out.println("Good bye...");
        System.exit(0);//Successful termination
    }
    /**
     * Display the options that can be done in this applicaitons
     * And forwarding to the operation with the given option number from the user
     */
    public void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to FarmMe app!");

        // Declaring variables here to avoid declaring them inside of else if chain multiple times;
        int tagno = -1;
        int vetID = -1;
        int option = 0;
        Date dateOfTreatment = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");

        do {
            System.out.print("Menu:" +
                    "\n1. Add cow" +
                    "\n2. Delete cow " +
                    "\n3. Get Cow details " +
                    "\n4. Add vet " +
                    "\n5. Delete vet" +
                    "\n6. Get vet details " +
                    "\n7. Add treatment " +
                    "\n8. Get cow treatment with only tagno " +
                    "\n9. Get cow treatment with tagno and dateOfTreatment" +
                    "\n10. List cows" +
                    "\n11. List vets" +
                    "\n12. Exit ");
            System.out.print("\nChoose an option: ");
            option = in.nextInt();
            if (option < 1 || option > 12) {
                System.out.print("Please enter a valid number");
            }
        } while (option < 1 || option > 12);

        if (option == 1) {// Add cow
            addCow();
        } else if (option == 2) {//Delete cow
            System.out.println("Enter the tagno of the cow to be deleted: ");
            tagno = in.nextInt();
            deleteCow(tagno);
        } else if (option == 3) {// Get specific cow details
            System.out.println("Enter the tagno of the cow you want to display the details of: ");
            tagno = in.nextInt();
            getCowDetails(tagno);
        } else if (option == 4) { // Add vet
            addVet();
        } else if (option == 5) {// Delete vet
            System.out.println("Enter the vetID of the vet to be deleted: ");
            vetID = in.nextInt();
            deleteVet(vetID);
        } else if (option == 6) {//Get vet details
            System.out.println("Enter the vetID of the vet to get details of: ");
            vetID = in.nextInt();
            getVetDetails(vetID);
        } else if (option == 7) {// Adding treatment
            System.out.print("Enter the tagno of the cow that you want to add treatment to: ");
            tagno = in.nextInt();
            System.out.print("Enter the vetId of assgned veterinary: ");
            vetID = in.nextInt();
            addTreatment(vetID,tagno);
        } else if (option == 8) {// Displaying cow treatment based on only tagNo
            System.out.print("Enter the tagno of the cow that you wnat to display treatments of: ");
            tagno = in.nextInt();
            getCowTreatment(tagno);
        } else if (option == 9) { // Displaying cow treatment based on tagNo and dateoftreatment
            System.out.print("Enter the tagno of the cow that you wnat to display treatments of: ");
            tagno = in.nextInt();
            System.out.print("Enter the date of treatment: ");
            String input = in.next();// Be careful about next
            try {
                dateOfTreatment = ft.parse(input);
            } catch (ParseException e) {
                System.out.println("Unparseable using " + ft);
            }
            getCowTreatment(tagno, dateOfTreatment);
        } else if (option == 10) {// Listing all the cows in the list
            listCow();
        } else if (option == 11) {// Listing all the vets in the list
            listVet();
        } else {
            exit();
        }


    }

    /**
     * Main method of the program
     * Populate the cows and the vets list at the beginning o f the program to have some inital objects
     * @param args user input when system runs from command line
     */
    public static void main(String args[]) {

        FarmMe myfarm = new FarmMe();

        PopulateData popData = new PopulateData();
        popData.populateVetsandCows(myfarm);
        //TODO: Command Line olarak yapmamız lazım

        myfarm.menu();

    }
}