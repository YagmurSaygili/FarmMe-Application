
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class where the application runs from
 * The list of animals and employees are kept here
 * In this implementation vets and farmworkers can ahave the same ID
 * The reason for above is that empIDs are unique in their corresponding classes; Vets or Farm-worker
 * !! Exception handling for all methods in FarmMe class is implemented in single do while loop inside menu method. See menu method's comments for further explanation
 * @author Yağmur saygılı
 * @version 4.0
 */
public class FarmMe {
    public ArrayList<Animal> animals;
    public ArrayList<Employee> employees;

    public ArrayList<Animal> getAnimals() {
        return animals;
    }


    public ArrayList<Employee> getEmployees() {
        return employees;
    }


    /**
     * Default constructor with no parameter is given
     * Allocating memory for animals and employees list
     */
    public FarmMe() {
        animals = new ArrayList<>();
        employees = new ArrayList<>();
    }

    /**
     * Constructor with the list of animals and employees are given
     * In my program this won't be needed
     *
     * @param animals   the animals arraylist created beforehand, if any
     * @param employees the employee arraylist created beforehand, if any
     */
    public FarmMe(ArrayList<Animal> animals, ArrayList<Employee> employees) {
        this.animals = animals;
        this.employees = employees;
    }

    /**
     * This method asks user for necessary information to create a cow object
     * Then adds the cow to the animals list which belongs to FarmMe class
     */
    public void addCow() {
        Scanner in = new Scanner(System.in);
        System.out.println("Entering a new cow to the list of animals...");
        String gender;
        int tagNo;
        LocalDate dateOfBirth ;
        boolean purchased;
        double weight; // Creating and initializing variables

        System.out.print("Please enter the gender of the cow: ");
        gender = in.nextLine();

        do {// Do while loop to avoid a cow entered with an existing animal's tagno
            System.out.print("Please enter the tagNo of the cow: ");
            tagNo = Integer.parseInt(in.nextLine()); // Using next line operator instead of next int to avoid skipping line, and parsing to integer
            if (searchCow(tagNo) != -1) {
                System.out.println("A cow with this tag no exists please enter another tagno..");
            }
        } while (searchCow(tagNo) != -1);

        do {// Getting date from user with parsing to LocalDate format
            try {
                System.out.print("Enter date of birth of the cow in the following format yyyy-mm-dd: ");
                dateOfBirth = LocalDate.parse(in.nextLine());
                break; //Break if above line executes successfully
            } catch (Exception ex) {
                System.out.print("Date could not be parsed try again\n");
            }
        } while (true); // Checking if dateofbirth changed from default value if not asks again in loop


        System.out.print("Purchased(1) or farm-raising(0): ");
        int purchasedCheck = Integer.parseInt(in.nextLine());// Using next line operator to avoid skipping line
        purchased = purchasedCheck == 1; // assignes purchased variable true if user enters 1 otherwise assigns 0

        System.out.print("Enter the weight of the cow: ");
        weight = Double.parseDouble(in.nextLine()); // Using next line operator to avoid skipping line

        Cow newCow = new Cow(tagNo, gender, dateOfBirth, purchased, weight);
        animals.add(newCow);
        System.out.println("\nCow succesfuly added...\n");

    }// TODO: DONE

    /**
     * This method asks user for necessary information to create a sheep object
     * Then adds the sheep to the animals list which belongs to FarmMe class
     */
    public void addSheep() {
        Scanner in = new Scanner(System.in);
        System.out.println("Entering a new sheep to the list of animals...");
        String gender;
        int tagNo;
        LocalDate dateOfBirth ;
        boolean purchased;
        // Creating and initializing variables

        System.out.print("Please enter the gender of the sheep: ");
        gender = in.nextLine();

        do {// Do while loop to avoid a cow entered with an existing animal's tagno
            System.out.print("Please enter the tagNo of the sheep: ");
            tagNo = Integer.parseInt(in.nextLine());
            if (searchSheep(tagNo) != -1) {
                System.out.println("A sheep with this tag no exists please enter another tagno..");
            }
        } while (searchSheep(tagNo) != -1);

        do {// Getting date from user with parsing to LocalDate format
            try {
                System.out.print("Enter date of birth of the sheep in the following format yyyy-mm-dd: ");
                dateOfBirth = LocalDate.parse(in.nextLine());
                break;//Breaking the loop if the above line executes correctly
            } catch (Exception ex) {
                System.out.print("Date could not be parsed try again\n");
            }
        } while (true); // Checking if dateofbirth changed from default value if not asks again in loop


        System.out.print("Purchased(1) or farm-raising(0): ");
        int purchasedCheck = Integer.parseInt(in.nextLine());
        purchased = purchasedCheck == 1; // assignes purchased variable true if user enters 1 otherwise assigns 0

        Sheep newSheep = new Sheep(tagNo, gender, dateOfBirth, purchased);
        animals.add(newSheep);
        System.out.println("\nSheep succesfuly added...\n");

    }// TODO: DONE


    /**
     * Searchs for the cow with the given tagNo in the animals list
     * If found delete the cow from the list
     * If not found display relevant error message
     *
     * @param tagNo the tag number of the cow that wants to be deleted
     */
    public void deleteCow(int tagNo) {
        int indexToDelete = searchCow(tagNo);

        if (indexToDelete != -1) {
            animals.remove(indexToDelete);
            System.out.println("The cow with tagNo :" + tagNo + " is succesfully deleted");
        } else {
            System.out.println("There is no cow with this tagNo!");
        }

    }// TODO:Done

    /**
     * Searchs for the sheep with the given tagNo in the animals list
     * If found delete the sheep from the list
     * If not found display relevant error message
     *
     * @param tagNo the tag number of the cow that wants to be deleted
     */
    public void deleteSheep(int tagNo) {
        int indexToDelete = searchSheep(tagNo);

        if (indexToDelete != -1) {
            animals.remove(indexToDelete);
            System.out.println("The sheep with tagNo :" + tagNo + " is succesfully deleted");
        } else {
            System.out.println("There is no sheep with this tagNo!");
        }

    } // TODO: Done

    /**
     * Search for the cow with the given tagno in the animals list
     * If found display the corresponding cow details
     * If not found display relevant error message
     *
     * @param tagNo the tag number of the cow who details want to be displayed
     */
    public void getCowDetails(int tagNo) {

        int foundIndex = searchCow(tagNo);

        if (foundIndex != -1) {
            System.out.println("Cow found!");
            animals.get(foundIndex).printDetails();
        } else {
            System.out.println("There is no cow found with tagNo " + tagNo + " !!!");
        }

    }// TODO: Done

    /**
     * Search for the sheep with the given tagno in the animals list
     * If found display the corresponding sheep details
     * If not found display relevant error message
     *
     * @param tagNo the tag number of the cow who details want to be displayed
     */
    public void getSheepDetails(int tagNo) {

        int foundIndex = searchSheep(tagNo);

        if (foundIndex != -1) {
            System.out.println("Sheep found!");
            animals.get(foundIndex).printDetails();
        } else {
            System.out.println("There is no sheep found with tagNo: " + tagNo + "!");
        }

    }// TODO: Done

    /**
     * Asking user for the necessary information to create veterinary  object
     * Then creating a new employee object
     * Adding the created object to the relevant employee list
     */
    public void addVet() {
        int empID;
        String gender;
        LocalDate dateOfBirth ;
        boolean degree;
        int expertiselevel;
        LocalDate dateOfGraduation = LocalDate.now().plusYears(1);  // To check if the value is getting correctly in the following implementations
        Scanner in = new Scanner(System.in);
        System.out.print("\nNew vet is being added...\n");

        do {//To avoid getting a vetID that already exists
            System.out.print("Enter the vetID: ");
            empID = Integer.parseInt(in.nextLine());
            if (searchVet(empID) != -1) {
                System.out.println("A vet with this ID exists. Please enter a unique ID");
            }
        } while (searchVet(empID) != -1);

        System.out.print("Enter the gender: ");
        gender = in.nextLine();

        do {//To get the date info from the user correctly
            try {
                System.out.print("Enter date of birth of the vet in the following format yyyy-mm-dd: ");
                dateOfBirth = LocalDate.parse(in.nextLine());
                break;
            } catch (Exception ex) {
                System.out.print("Date could not be parsed try again\n");
            }
        } while (true); // Checking if dateofbirth changed from default value if not asks again in loop

        do {
            try {
                System.out.print("Enter date that this veterinary graduated in the following format yyyy-mm-dd: ");
                dateOfBirth = LocalDate.parse(in.nextLine());
            } catch (Exception ex) {
                System.out.print("Date could not be parsed try again\n");
            }
            if (dateOfBirth.getYear() >= 2023) {
                System.out.println("Invalid date entered. Please enter again...");
            }
        } while (dateOfBirth.getYear() >= 2023); // Checking if dateofbirth changed from default value if not asks again in loop
        // Since the veterinary cannot be graduated from future, I implement this method to handle exception handling and re ask user for data

        System.out.print("Does the employee have a BScDegree ?(true/false) : ");
        degree = Boolean.parseBoolean(in.nextLine());
        System.out.print("Enter the expertise level of this employee: ");
        expertiselevel = Integer.parseInt(in.nextLine());

        Veterinary newVet = new Veterinary(empID, gender, dateOfBirth, degree, dateOfGraduation, expertiselevel);
        employees.add(newVet);
        System.out.println("\nNew vet successfully added...");

    } //TODO: DONE

    /**
     * Asking user for the necessary information to create farm-worker  object
     * Then creating a new farm-worker object
     * Adding the created object to the relevant employee list
     */
    public void addFarmWorker() {
        // Necessary fields to create employee
        int empID;
        String gender;
        LocalDate dateOfBirth ;
        //Necessary fields to create FarmWorker
        String previousFarmName;
        int workexperience;
        Scanner in = new Scanner(System.in);
        System.out.print("\nNew Farm-worker is being added...\n");

        do {//To avoid getting a vetID that already exists
            System.out.print("Enter the empID: ");
            empID = Integer.parseInt(in.nextLine());
            if (searchFarmWorker(empID) != -1) {
                System.out.println("A farm worker this ID exists. Please enter a unique ID");
            }
        } while (searchFarmWorker(empID) != -1);

        System.out.print("Enter the gender: ");
        gender = in.nextLine();

        do {//To get the date info from the user correctly
            try {
                System.out.print("Enter date of birth of the farm worker in the following format yyyy-mm-dd: ");
                dateOfBirth = LocalDate.parse(in.nextLine());
                break; // Breaks the loop if the above line executes correctly
            } catch (Exception ex) {
                System.out.print("Date could not be parsed try again\n");
            }
        } while (true); // Checking if dateofbirth changed from default value if not asks again in loop


        System.out.print("Enter the previous farm name of farm worker(if there is): ");
        previousFarmName = in.nextLine();
        System.out.print("Enter the work experience of this Farmworker: ");
        workexperience = Integer.parseInt(in.nextLine());

        FarmWorker newFarmWorker = new FarmWorker(empID, gender, dateOfBirth, previousFarmName, workexperience);
        employees.add(newFarmWorker);
        System.out.println("\nNew farm-worker successfully added...");

    } //TODO: DONE


    /**
     * Searchs the employees list for the vet with given vetID
     * If found delete the vet from the list
     * If not found display relevant error message
     *
     * @param vetID the vet ID of the vet that want to be deleted
     */
    public void deleteVet(int vetID) {
        int indexToDelete = searchVet(vetID);
        if (indexToDelete != -1) {
            employees.remove(indexToDelete);
            System.out.println("The vet with vetID :" + vetID + " is succesfully deleted");
        } else {
            System.out.println("There is no vet with this vetID!");
        }

    } //TODO: Done

    /**
     * Searchs the employees list for the farmworker with given empID
     * If found delete the farmworker from the list
     * If not found display relevant error message
     *
     * @param empID the emp ID of the farmworker that want to be deleted
     */
    public void deleteFarmWorker(int empID) {
        int indexToDelete = searchFarmWorker(empID);
        if (indexToDelete != -1) {
            employees.remove(indexToDelete);
            System.out.println("The farmworker with empID :" + empID + " is succesfully deleted");
        } else {
            System.out.println("There is no vet with this vetID!");
        }

    }// TODO: Done

    public void getVetDetails(int vetID) {
        int indexFound = searchVet(vetID);
        if (indexFound != -1) {
            System.out.println("Vet found!");
            employees.get(indexFound).printDetails();
        } else {
            System.out.println("A vet with vetID: " + vetID + " could not found!");
        }

    }//TODO : Done

    public void getFarmWorkerDetails(int empID) {
        int indexFound = searchFarmWorker(empID);
        if (indexFound != -1) {
            System.out.println("Farm-worker found!");
            employees.get(indexFound).printDetails();
        } else {
            System.out.println("A farm-worker with empID: " + empID + " could not be found!");
        }

    }//TODO: Done

    /**
     * First search for given empId and tagNo , make sure they exist in the corresponding list
     * Then get dateOfTreatment and the type of animal the treatment will be given to
     * Call addCleaningTreatment and addHealthTreatment accordingly
     * For ease of use while calling above functions animal index and the employee index in the corresponding arraylists will be sent
     * Further explanation is avaliable in addCleaningTreatment and addHealthTreatment methods
     *
     * @param empID the unique employee ID which may be belonging to veterinary or farm-worker
     * @param tagNo the unique tag number of animal which may be belonging to cow or sheep
     */
    public void addTreatment(int empID, int tagNo) {
        System.out.println("New treatment is being added...");
        int animalIndex ;// This refers to the animal which will take the treatment, used for making it easy to pass sheep or cow based on their index in animals list
        //Checking if any sheep or cow with given tag no exists
        if (searchCow(tagNo) == -1 && searchSheep(tagNo) == -1) {
            System.out.println("There is no matching cow or sheep!");
        }
        //Checking if any veterinary or farm-worker with given tempID exists
        else if (searchVet(empID) == -1 && searchFarmWorker(empID) == -1) {
            System.out.println("There is no vet with given ID !");
        } else {
            Scanner in = new Scanner(System.in);
            String typeTreatment;
            LocalDate dateOfTreatment;
            do {
                try {
                    System.out.print("Enter the date of treatment  as  yyyy-mm-dd: ");
                    dateOfTreatment = LocalDate.parse(in.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Date could not be parsed try again\n");
                }
            } while (true);
            System.out.print("Is this treatment for Cow(1) or Sheep(2): ");
            int typeOfAnimal = Integer.parseInt(in.nextLine());
            if (typeOfAnimal == 1) {
                animalIndex = searchCow(tagNo);
            } // To specifiy the animal index in animal list to operate
            else {
                animalIndex = searchSheep(tagNo);
            }

            do {
                System.out.print("\nEnter the type of treatment(cleaning/health): ");
                typeTreatment = in.nextLine().toUpperCase();

                if (typeTreatment.compareTo("CLEANING") == 0) {// That means a farm-worker will operate
                    addCleaningTreatment(searchFarmWorker(empID), animalIndex, dateOfTreatment);
                } else if (typeTreatment.compareTo("HEALTH") == 0) {// Here means a veterinary is doing the operation
                    addHealthTreatment(searchVet(empID), animalIndex, dateOfTreatment);
                } else {
                    System.out.print("Please enter type of treatment correctly!");
                }
            } while (typeTreatment.compareTo("HEALTH") != 0 && typeTreatment.compareTo("CLEANING") != 0); // Here I basically check if the type entered correct or not
        }
    }//TODO:Done

    /**
     * In this method HealthTreatment will be assigned to given animal and veterinary
     * Firstly, passing vetIndex and animalIndex for ease of use. The indexes will be used to get objects directly from employees and animals array lists
     * After getting necessary information for HealthTreatment which is emergency. Program asks how many medication is needed for this treatment
     * Then in a for loop again asks user for necessary information to create a medication and assign each one of them to the treatment
     * Finally assigns treatment to both given animal and veterinary using their indexes and finding them in the list
     *
     * @param vetIndex        the Veterinary with the given empID in addTreatment method. This index is to get exact veterinary from emloyees list. Avoid confusion between types
     * @param animalIndex     the Animal(Sheep/Cow) with the given tagNo in addTreatment method. This index is to get exact animal from animals list. Avoid confusion between types
     * @param dateOfTreatment basic date of treatment
     */
    public void addHealthTreatment(int vetIndex, int animalIndex, LocalDate dateOfTreatment) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter if it is emergency or not (true/false): ");
        boolean emergency = Boolean.parseBoolean(in.nextLine());
        System.out.print("Enter the number of medications needed for this treatment: ");
        int noOfMedication = Integer.parseInt(in.nextLine());

        HealthTreatment newHTreatment = new HealthTreatment(dateOfTreatment, emergency);// New treatment is created then we wil assign the medications to it

        for (int i = 0; i < noOfMedication; i++) {
            System.out.print("For No." + (i + 1) + " Medication enter the following\n");
            System.out.print("Details: ");//Here I could manage to get details with two scans
            String details = in.nextLine();
            System.out.print("Duration: ");
            int duration = Integer.parseInt(in.nextLine());
            LocalDate startDate ;
            do {
                try {
                    System.out.print("Enter the start date of treatment of animal in the following format yyyy-mm-dd: ");
                    startDate = LocalDate.parse(in.nextLine());
                    break;
                } catch (Exception ex) {
                    System.out.print("Date could not be parsed try again\n");
                }

            } while (true);
            System.out.print("Enter the dosage: ");
            double dosage = Double.parseDouble(in.nextLine());
            System.out.print("Enter notes if any: ");
            String notes = in.nextLine();

            Medication newMed = new Medication(details, duration, startDate, dosage, notes);
            newHTreatment.getMedications().add(newMed);


        }
        // Assigning the vet with Health treatment created
        employees.get(vetIndex).setAssignedTreatment(newHTreatment);
        //Assigning treatment to animal
        animals.get(animalIndex).getTreatments().add(newHTreatment);
        System.out.println("Health treatment is successfully added");
    } //TODO: Done

    /**
     * In this method CleaningTreatment will be assigned to given animal and Farm-Worker
     * Firstly, passing farmWorketIndex and animalIndex for ease of use. The indexes will be used to get objects directly from employees and animals array lists
     * After getting necessary information for HealthTreatment which is materialUsed, creating a new cleaning treatment
     * Then assigning newly created CleaningTreatment to the specified animal and farm-worker
     *
     * @param farmWorkerIndex the Farm-Worker index with the given empID in addTreatment method. This index is to get exact farm-worker from employees list. Avoid confusion between types
     * @param animalIndex     the Animal(Sheep/Cow) with the given tagNo in addTreatment method. This index is to get exact animal from animals list. Avoid confusion between types
     * @param dateOfTreatment basic date of treatment
     */
    public void addCleaningTreatment(int farmWorkerIndex, int animalIndex, LocalDate dateOfTreatment) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the material used in this treatment: ");
        String materialUsed = in.nextLine();


        CleaningTreatment newCTreatment = new CleaningTreatment(dateOfTreatment, materialUsed);// New treatment is created then we wil assign the medications to it

        // Give the treatment to the specified animal
        animals.get(animalIndex).getTreatments().add(newCTreatment);
        // Assign the treatment to the specified farm-worker
        employees.get(farmWorkerIndex).setAssignedTreatment(newCTreatment);

        System.out.println("Cleaning treatment is successfully added");
    } //TODO: Done

    /**
     * Searching for the cow with given tag no
     * If found look for treatments if not found display relevant message
     * If any treatment found print with their details(including Medications if any). Print treatment method calls printMedication method. See printTreatment in HealthTreatment class
     * If cow not found display relevant error message
     *
     * @param tagNo the unique tag number of a cow
     */
    public void getCowTreatment(int tagNo) {
        int cowIndex = searchCow(tagNo);
        if (cowIndex == -1) {
            System.out.println("There is no cow with given tagno");
        } else {
            int sizeOfTreatments = animals.get(cowIndex).getTreatments().size();
            if (sizeOfTreatments == 0) {// No treatment implemented yet
                System.out.println("There is no treatment given to this cow!");
            } else {
                System.out.println("Printing the cow's treatments with tagno of: " + tagNo + "...");
                for (int i = 0; i < sizeOfTreatments; i++) {
                    System.out.print("\nPrinting details of treatment no: " + (i + 1));
                    animals.get(cowIndex).getTreatments().get(i).printTreatment();
                }
                System.out.println("End of the treatments--------------------------\n");
            }
        }

    }// TODO: Done

    /**
     * Searching for the sheep with given tag no
     * If found look for treatments if not found display relevant message
     * If any treatment found print with their details(including Medications if any). Print treatment method calls printMedication method. See printTreatment in HealthTreatment class
     * If cow not found display relevant error message
     *
     * @param tagNo the unique tag number of a sheep
     */
    public void getSheepTreatment(int tagNo) {
        int sheepIndex = searchSheep(tagNo);
        if (sheepIndex == -1) {
            System.out.println("There is no sheep with given tagno");
        } else {

            int sizeOfTreatments = animals.get(sheepIndex).getTreatments().size();
            if (sizeOfTreatments == 0) {// No treatment implemented yet
                System.out.println("There is no treatment given to this sheep!");
            } else {
                System.out.println("Printing the sheep's treatments with tagno of: " + tagNo + "...");
                for (int i = 0; i < sizeOfTreatments; i++) {
                    System.out.print("\nPrinting details of treatment no: " + (i + 1));
                    animals.get(sheepIndex).getTreatments().get(i).printTreatment();
                }
                System.out.println("End of the treatments--------------------------\n");
            }
        }

    } //TODO: Done

    /**
     * Searching for the cow with the given tag No
     * If found search with the given Date in treatments list
     * If there is a treatment with given Date display it
     * If cow could not be found with specific information display relevant error message
     *
     * @param tagNo           tag number of the cow
     * @param dateOfTreatment the date which treatment has assigned to
     */
    public void getCowTreatment(int tagNo, LocalDate dateOfTreatment) {
        int foundCowIndex = searchCow(tagNo);
        if (foundCowIndex == -1) {
            System.out.println("There is no cow with given tag no");
        } else {
            int sizeOfTreatments = animals.get(foundCowIndex).getTreatments().size();
            if (sizeOfTreatments == 0) {// No treatment implemented yet
                System.out.println("There is no treatment given to this cow!");
            } else {
                for (int i = 0; i < sizeOfTreatments; i++) {
                    if (animals.get(foundCowIndex).getTreatments().get(i).getDateOfTreatment().compareTo(dateOfTreatment) == 0) {//Checking if dates are equal
                        animals.get(foundCowIndex).getTreatments().get(i).printTreatment();
                    }
                }
            }
        }

    } //TODO: Done

    /**
     * Searching for the sheep with the given tag No
     * If found search with the given Date in treatments list
     * If there is a treatment with given Date display it
     * If could not found with specific information display relevant error message
     *
     * @param tagNo           tag number of the sheep
     * @param dateOfTreatment the date which treatment has assigned to
     */
    public void getSheepTreatment(int tagNo, LocalDate dateOfTreatment) {
        int foundSheepIndex = searchCow(tagNo);
        if (foundSheepIndex == -1) {
            System.out.println("There is no cow with given tag no");
        } else {
            int sizeOfTreatments = animals.get(foundSheepIndex).getTreatments().size();
            if (sizeOfTreatments == 0) {// No treatment implemented yet
                System.out.println("There is no treatment given to this cow!");
            } else {
                for (int i = 0; i < sizeOfTreatments; i++) {
                    if (animals.get(foundSheepIndex).getTreatments().get(i).getDateOfTreatment().compareTo(dateOfTreatment) == 0) {//Checking if dates are equal
                        System.out.println("Printing treatment details based on date search...");
                        animals.get(foundSheepIndex).getTreatments().get(i).printTreatment();
                    }
                }
            }
        }

    }//TODO: Done


    /**
     * Search method to search the cows in the animals list
     * Checks the instance to make sure it is a cow object in the given index
     *
     * @param tagNo the unique tag number of the cow that wants to be found
     * @return the index of Veterinary in the employee list, if they don't exist return -1
     */
    public int searchCow(int tagNo) {// Returns the index of the cow in arraylist if the cow found else zero
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Cow) {
                return i;//returning its index in the list
            }
        }
        return -1; // In case which cow did not getfound
    } //TODO: Done

    /**
     * Search method to search the sheep in the animals list
     * Checks the instance to make sure it is sheep object in the given index
     *
     * @param tagNo the unique tag number of the sheep that wants to be found
     * @return the index of Veterinary in the employee list, if they don't exist return -1
     */
    public int searchSheep(int tagNo) {// Returns the index of the cow in arraylist if the cow found else zero
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Sheep) {
                return i;//returning its index in the list
            }
        }
        return -1; // In case which cow did not getfound
    }//TODO: Done

    /**
     * Search method to search the vets in the employee list
     *
     * @param vetID the unique ID of the vet that wants to be found
     * @return the index of Veterinary in the employee list,if they don't exist return -1
     */
    public int searchVet(int vetID) {// Does the same operation as above for vets
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpID() == vetID && employees.get(i) instanceof Veterinary) {
                return i;//returning its index in the list
            }
        }
        return -1;
    } //TODO: Done

    /**
     * Search method to search the farm-worker in the employee list
     *
     * @param farmWorkerID the unique ID of the farm-worker that wants to be found
     * @return the index of Veterinary in the employee list,if they don't exist return -1
     */
    public int searchFarmWorker(int farmWorkerID) {// Does the same operation as above for farmworkers
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpID() == farmWorkerID && employees.get(i) instanceof FarmWorker) {
                return i;//returning its index in the list
            }
        }
        return -1;
    }//TODO: Done

    /**
     * Searchs the animals list for cows
     * Displays their details one by one
     */
    public void listCows() {
        System.out.println("Listing all the cows in the farm...");

        for (Animal animal : animals) {// Checks if the corresponding animal is Cow or not
            {
                if (animal instanceof Cow)
                    animal.printDetails();
            }
        }

        System.out.println("\nEnd of the list.");


    }//TODO: Done

    /**
     * Searchs the animals list for sheeps
     * Displays their details one by one
     */
    public void listSheeps() {
        System.out.println("Listing all the sheeps in the farm...");

        for (Animal animal : animals) { // Checks if the corresponding animal is Cow or not
            if (animal instanceof Sheep)
                animal.printDetails();
        }
        System.out.println("\nEnd of the list.");


    }//TODO: Done

    /**
     * Searchs the employees list for Veterinaries
     * Displays their details one by one
     */
    public void listVet() {
        System.out.println("Listing all the vets...");
        for (Employee employee : employees) { // Checks if the corresponding animal is Cow or not
            if (employee instanceof Veterinary) {
                employee.printDetails();
            }
        }
        System.out.println("\nEnd of the list.");

    }//TODO: Done

    /**
     * Searchs the employees list for FarmWorkers
     * Displays their details one by one
     */
    public void listFarmWorker() {
        System.out.println("Listing all the farm-workers...");
        for (Employee employee : employees) { // Checks if the corresponding animal is Cow or not
            if (employee instanceof FarmWorker) {
                employee.printDetails();
            }
        }
        System.out.println("\nEnd of the list.");

    } //TODO: Done

    /**
     * Asking user which type of animal they want to feed
     * Then search for sheep or cow in the animals list with the given tagNo
     * IF found operate feeding accordingly/display the appropraite message to the user about feeding
     * If not found display relevant error message and end the operation
     *
     * @param tagNo the unique tag number of the cow/sheep that wants to be feed
     */
    public void feedingAnimal(int tagNo) {
        Scanner in = new Scanner(System.in);
        int type ;
        do {// Asking user which type of animal they want to feed
            System.out.print("\nDo you want to feed Cow(1) or Sheep(2): ");
            type = Integer.parseInt(in.nextLine());
        } while (type != 1 && type != 2);// Checking if the user gives input correctly

        if (type == 1) {// That means we feed a cow
            int indexOfCow = searchCow(tagNo);
            if (indexOfCow == -1) {//That means cow could not be found
                System.out.println("There is no cow with given tag number");
            } else {
                System.out.println("Cow is found and feeding process begins.");
                animals.get(indexOfCow).feeding();// Getting the cow object from the list based on index and feed
            }
        } else {// Here type = 2 and we feed sheep
            int indexofSheep = searchSheep(tagNo);
            if (indexofSheep == -1) {//That means sheep could not be found
                System.out.println("There is no sheep with given tag number");
            } else {
                System.out.println("Sheep is found and feeding process begins.");
                animals.get(indexofSheep).feeding();// Getting the sheep object from the list based on index and feed
            }
        }
        System.out.println("Exiting from feeding operation...");
    }//TODO: Done

    /**
     * Asks user to choose which type of employee they want to search for salary
     * Based on selection salary is calculated with overriden method getsalary from classes FarmWorker and Veterinary
     * For double-check the salary is displayed on the screen for the ease of operator
     * Finally salary is returned in double format
     * If an employee in chosen type could not be found it displays the relevant error message
     *
     * @param empID the unique employee ID of the veterinary or farm-worker based on user selection
     * @return the salary(Double) of the specified employee
     */
    public double getEmpSalary(int empID) {
        Scanner in = new Scanner(System.in);
        int type ;
        double salary = 0;
        do {// Asking user which type of employee they want to get slary from
            System.out.print("\nDo you want to get salary for Vet(1) or Farm-worker(2): ");
            type = Integer.parseInt(in.nextLine());
        } while (type != 1 && type != 2);// Checking if the user gives input correctly

        if (type == 1) {// That means we get the salary of a vet
            int indexOfVet = searchVet(empID);
            if (indexOfVet == -1) {//That means vet could not be found
                System.out.println("There is no vet with given empID");
            } else {
                salary = employees.get(indexOfVet).getSalary();
                System.out.println("Vet is found and the salary is: " + salary);
            }
        } else {// Here type = 2 and we get salary from farm-worker
            int indexofFarmWorker = searchFarmWorker(empID);
            if (indexofFarmWorker == -1) {//That means farm-worker could not be found
                System.out.println("There is no farm-worker with given emp ID");
            } else {
                salary = employees.get(indexofFarmWorker).getSalary();
                System.out.println("Farm-worker is found and her/his salary is: " + salary);
            }
        }

        return salary;
    } //TODO: Done

    /**
     * First asks user which type of the animal they want to record of their milking measurements
     * Then based on selection search the list for cow/sheep with given tag number
     * Converts double amount to string version, so it can be stored in hashmap milking variable
     * If cow or sheep found stores the given amount with date of entry to the hash map
     * If not found displays the relevant error message
     *
     * @param tagNo  the unique tag number for cow/sheep
     * @param amount the milking amount of animal which is recorded in the date of entry
     */
    public void addMilkingMeasurement(int tagNo, double amount) {
        LocalDate dateOfEntry = LocalDate.now();
        String amountString = String.valueOf(amount);//COnverting amount to string version to be able to store
        Scanner in = new Scanner(System.in);
        int type ;
        do {// Asking user which type of animal they want to feed
            System.out.print("\nDo you want to enter measurement for Cow(1) or Sheep(2): ");
            type = Integer.parseInt(in.nextLine());
        } while (type != 1 && type != 2);// Checking if the user gives input correctly

        if (type == 1) {// That means we take the measurement of a cow
            int indexOfCow = searchCow(tagNo);
            if (indexOfCow == -1) {//That means cow could not be found
                System.out.println("There is no cow with given tagNo");
            } else {
                System.out.println("Cow is found");
                animals.get(indexOfCow).getMilking().put(dateOfEntry, amountString);
                System.out.println("Recording process is complete!");
            }
            // Here type = 2 ,and we take the sheep's record of milking
        } else {
            int indexofSheep = searchSheep(tagNo);
            if (indexofSheep == -1) {//That means cow could not be found
                System.out.println("There is no sheep with given tag no");
            } else {
                System.out.println("Sheep is found");
                animals.get(indexofSheep).getMilking().put(dateOfEntry, amountString);
                System.out.println("Recording process is complete!");
            }

        }
    } //TODO: Done

    /**
     * Display the options that can be done in this applicaitons
     * And forwarding to the operation with the given option number from the user
     * Exception handling for all methods in current class is implemented here by single do while loop see line 946 for further explanation
     */
    public void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to FarmMe app!");

        // Declaring variables here to avoid declaring them inside of else if chain multiple times;
        int tagno ;
        int empID ;
        int option = 0;
        double salary;
        LocalDate dateOfTreatment ;

        do {
            try {
                System.out.print("""
                        Menu:
                        1. Add cow
                        2. Add sheep\s
                        3. Delete cow\s
                        4. Delete sheep\s
                        5. Get cow details
                        6. Get sheep details\s
                        7. Add vet\s
                        8. Add farm-worker\s
                        9. Delete vet
                        10.Delete farm-worker
                        11.Get vet details
                        12.Get farm-worker details
                        13.Add treatment
                        14.Get cow treatment with only tagno
                        15.Get sheep treatment with only tagno
                        16.Get cow treatment with tagno and date of treatment
                        17.Get sheep treatment with tagno and date of treatment
                        18.List cows
                        19.List sheeps
                        20.List vets
                        21.List farm-workers
                        22.Feed an animal
                        23.Get an employeer's salary
                        24.Add milking measurement
                        25.Exit\s""");
                System.out.print("\nChoose an option: ");
                option = Integer.parseInt(in.nextLine());
                if (option < 1 || option > 25) {
                    System.out.print("Please enter a valid number");
                }

            } catch (Exception exception) {
                System.out.println("Exception: " + exception + "  occured");
                System.out.println("Try again!");
            }
        } while (option < 1 || option > 25);
        // I implemented try catch block in do while loop ,so it can return to where it stayed before exception occurs
        // Menu is implemented in try block so if any exception occurs during taking input for menu parameters OR inside the methods it will throw exception
        // Thrown exception will be caught by catch block here and display the user which exception occurred
        // Then program ask user to do the operation from start
        // I find this implementation of exception handling useful rather than  writing try catch block in all methods one by one
        do {
            try {
                if (option == 1) {// Add cow
                    addCow();
                    menu();
                } else if (option == 2) {//Add sheep
                    addSheep();
                    menu();
                } else if (option == 3) {// Delete cow
                    System.out.print("Enter the tagno of the cow to be deleted: ");
                    tagno = Integer.parseInt(in.nextLine());
                    deleteCow(tagno);
                    menu();
                } else if (option == 4) {// Delete sheep
                    System.out.print("Enter the tagno of the sheep to be deleted: ");
                    tagno = Integer.parseInt(in.nextLine());
                    deleteSheep(tagno);
                    menu();
                } else if (option == 5) {// Get cow details
                    System.out.print("Enter the tagno of the cow you want to display the details of: ");
                    tagno = Integer.parseInt(in.nextLine());
                    getCowDetails(tagno);
                    menu();
                } else if (option == 6) {// Get sheep details
                    System.out.print("Enter the tagno of the sheep you want to display the details of: ");
                    tagno = Integer.parseInt(in.nextLine());
                    getSheepDetails(tagno);
                    menu();
                } else if (option == 7) {//Add vet
                    addVet();
                    menu();
                } else if (option == 8) {// Add farm-worker
                    addFarmWorker();
                    menu();
                } else if (option == 9) {// Delete vet
                    System.out.print("Enter the vetID of the vet to be deleted: ");
                    empID = Integer.parseInt(in.nextLine());
                    deleteVet(empID);
                    menu();
                } else if (option == 10) { // Delete farm worker
                    System.out.print("Enter the vetID of the farm worker to be deleted: ");
                    empID = Integer.parseInt(in.nextLine());
                    deleteFarmWorker(empID);
                    menu();
                } else if (option == 11) {// Get vet details
                    System.out.print("Enter the emp ID of the vet to get details of: ");
                    empID = Integer.parseInt(in.nextLine());
                    getVetDetails(empID);
                    menu();
                } else if (option == 12) {// Get farm-worker details
                    System.out.print("Enter the emp ID of the farm-worker to get details of: ");
                    empID = Integer.parseInt(in.nextLine());
                    getFarmWorkerDetails(empID);
                    menu();
                } else if (option == 13) {// Add treatment
                    System.out.print("Enter the emp ID to assign the treatment to: ");
                    empID = Integer.parseInt(in.nextLine());
                    System.out.print("Enter the tag no of the animal for the treatment: ");
                    tagno = Integer.parseInt(in.nextLine());
                    addTreatment(empID, tagno);
                    menu();
                } else if (option == 14) { // Get cow treatment with only tagno
                    System.out.print("Enter the tag no of the cow to get treatment from: ");
                    tagno = Integer.parseInt(in.nextLine());
                    getCowTreatment(tagno);
                    menu();
                } else if (option == 15) { // Get sheep treatment with only tagno
                    System.out.print("Enter the tag no of the sheep to get treatment from: ");
                    tagno = Integer.parseInt(in.nextLine());
                    getSheepTreatment(tagno);
                    menu();
                } else if (option == 16) { // Get cow treatment with tagno and date of treatment
                    System.out.print("Enter the tag no of the cow to get treatment from: ");
                    tagno = Integer.parseInt(in.nextLine());
                    do {
                        try {
                            System.out.print("Enter the date of treatment as yyyy-mm-dd: ");
                            dateOfTreatment = LocalDate.parse(in.nextLine());
                            break;
                        } catch (Exception ex) {
                            System.out.println("Date could not be parsed!! Try again");
                        }
                    } while (true);
                    getCowTreatment(tagno, dateOfTreatment);
                    menu();
                } else if (option == 17) {// Get sheep treatment with tagno and date of treatment
                    System.out.print("Enter the tag no of the sheep to get treatment from: ");
                    tagno = Integer.parseInt(in.nextLine());
                    do {
                        try {
                            System.out.print("Enter the date of treatment as yyyy-mm-dd: ");
                            dateOfTreatment = LocalDate.parse(in.nextLine());
                            break;
                        } catch (Exception ex) {
                            System.out.println("Date could not be parsed!! Try again");
                        }
                    } while (true);
                    getSheepTreatment(tagno, dateOfTreatment);
                    menu();
                } else if (option == 18) {// List cows
                    listCows();
                    menu();
                } else if (option == 19) {// List sheeps
                    listSheeps();
                    menu();
                } else if (option == 20) {// List vets
                    listVet();
                    menu();
                } else if (option == 21) {// List Farm-Workers
                    listFarmWorker();
                    menu();
                } else if (option == 22) { // Feed animal
                    System.out.print("Enter the tagno of ANIMAL that you want to feed(type decision will be asked later): ");
                    tagno = Integer.parseInt(in.nextLine());
                    feedingAnimal(tagno);
                    menu();
                } else if (option == 23) { // Get emp salary
                    System.out.print("Enter the empID of employee whose salary you want to get: ");
                    empID = Integer.parseInt(in.nextLine());
                    salary = getEmpSalary(empID); // Since it s not mentioned in the design I just store the salary lke this
                    menu();
                } else if (option == 24) { // Add milking measurement
                    System.out.print("Enter the tagno of ANIMAL that you want to add milking measurement(type decision will be asked later): ");
                    tagno = Integer.parseInt(in.nextLine());
                    System.out.print("Enter the amount of milk: ");
                    double amount = Double.parseDouble(in.nextLine());
                    addMilkingMeasurement(tagno, amount);
                    menu();
                } else { // Exiting
                    exit();
                }
                break; //Break the do while loop that is created for exception handling
            } catch (Exception exception) {
                System.out.println("Exception: " + exception + "  occured");
                System.out.println("Try again!");
            }

        }

        while (true);
    } //TODO: Done


    /**
     * Basic exit operation from the program
     * Terminates the program with success code
     */
    public void exit() {
        System.out.println("Good bye...");
        System.exit(0);//Successful termination
    }

    public static void main(String[] args) {


        FarmMe myFarm = new FarmMe();
        PopulateData populateData = new PopulateData();
        populateData.populateData(myFarm);


        myFarm.menu();

    }
}