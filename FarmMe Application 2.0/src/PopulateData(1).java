import java.time.LocalDate;

/**
 * PopulateData class is the class where some initial data is being populated in the following format
 * Since this project doest not have GUI, there is some default data to run the program with
 * @author Yağmur saygılı
 * @version 1.0
 */
public class PopulateData{
    /**
     * Creating 2 vet 2 cow 2 sheep and 2 farmworker is created
     * One treatment of each type for each animal with one medication per health treatment
     * Assigning them into the list of animals and employees in the FarmMe class list
     * @param myFarm the instance of the FarmMe class, where all the operations is running from
     */
    public void populateData(FarmMe myFarm){
        LocalDate tempDate = LocalDate.now();

        //Creating initial cow objects
        Cow cow1 = new Cow(1,"Male",tempDate,true,150);
        Cow cow2 = new Cow(2,"Female",tempDate,true,250);
        // Adding objects into the animals arraylist with followint operation
        myFarm.getAnimals().add(cow1); myFarm.getAnimals().add(cow2);
        //Creating temp-date2 and temp-date1 for degree and date of birth
        LocalDate tempDate1 = tempDate.minusYears(25);
        LocalDate tempDate2 = tempDate.minusYears(5);
        //Creating initial vet objects
        Veterinary vet1 = new Veterinary(1,"Male",tempDate,true,tempDate2,5);
        Veterinary vet2 = new Veterinary(2,"Female",tempDate,true,tempDate2,5);
        // Adding vet objects into the employees arraylist with following operation
        myFarm.getEmployees().add(vet1); myFarm.getEmployees().add(vet2);
        //Creating initial sheep objects
        Sheep sheep1 = new Sheep(1,"Male",tempDate1,true);
        Sheep sheep2 = new Sheep(2,"Female",tempDate1,true);
        //Adding them to the animals list with following operation
        myFarm.getAnimals().add(sheep1);myFarm.getAnimals().add(sheep2);

        // Creating initial farm worker objects
        FarmWorker farmWorker1 = new FarmWorker(1,"Male",tempDate,"Uncle Duck's Farm",6);
        FarmWorker farmWorker2 = new FarmWorker(2,"FeMale",tempDate,"Uncle Joe's Farm",5);

        //Adding them into the employees list with the following operation
        myFarm.employees.add(farmWorker1); myFarm.employees.add(farmWorker2);

        LocalDate dateOfTreatment = LocalDate.now().minusYears(2);
        //Creating treatments of each type TWO DIFFERENT
        CleaningTreatment cleaningTreatment1 = new CleaningTreatment(dateOfTreatment,"Metal and plastic");
        CleaningTreatment cleaningTreatment2 = new CleaningTreatment(dateOfTreatment,"Soap and cereal");
        HealthTreatment healthTreatment1 = new HealthTreatment(dateOfTreatment,true);
        HealthTreatment healthTreatment2 = new HealthTreatment(dateOfTreatment,false);
        // Assigning treatments to workers
        farmWorker1.setCleaningTreatment(cleaningTreatment1);
        farmWorker2.setCleaningTreatment(cleaningTreatment2);
        vet1.setHealthTreatment(healthTreatment1);
        vet2.setHealthTreatment(healthTreatment2);
        //Creating and assignind medication to healthTreatment TWO DIFFERENT
        Medication med1 = new Medication("This is first default medication", 1,dateOfTreatment.plusDays(10),1,"Make sure the take this pill on time");
        Medication med2 = new Medication("This is second default medication2", 1,dateOfTreatment.plusDays(20),2,"Make sure the take this pill on time");

        healthTreatment1.getMedications().add(med1);
        healthTreatment1.getMedications().add(med2);
        //Distributing/populating data to both sheep and cow for both health and cleaning treatment
        myFarm.animals.get(0).getTreatments().add(cleaningTreatment1); myFarm.animals.get(0).getTreatments().add(healthTreatment1);//cow1
        myFarm.animals.get(1).getTreatments().add(cleaningTreatment2); myFarm.animals.get(1).getTreatments().add(healthTreatment2);//cow2
        myFarm.animals.get(2).getTreatments().add(cleaningTreatment1); myFarm.animals.get(2).getTreatments().add(healthTreatment1);//sheep1
        myFarm.animals.get(3).getTreatments().add(cleaningTreatment2); myFarm.animals.get(3).getTreatments().add(healthTreatment2);//sheep2

    }
}