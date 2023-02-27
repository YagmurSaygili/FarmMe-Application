import java.util.Date;

/**
 *
 * Represents the class where inital objects created in order to run the program
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.5
 */
public class PopulateData {// Whiich inheritance is correct ?

    public PopulateData() {
    }
    /**
     * Creating 3 vet 3 cow and one treatment with one medication per cow and vet
     * Assigning them into the list of cows and vets in the FarmMe class list
     * @param myFarmobject the instance of the FarmMe class, where all the operations is running from
     */
    public void populateVetsandCows(FarmMe myFarmobject){//Creating base
        Date d1 = new Date(11, 10, 2000);
        Cow initialCow1 = new Cow(1, "Male", d1, true);
        Cow initialCow2 = new Cow(2, "Female", d1, true);
        Cow initialCow3 = new Cow(3, "Male", d1, true);

        Veterinary vet1 = new Veterinary(1, "male", d1, 20000);
        Veterinary vet2 = new Veterinary(2, "female", d1, 100000);
        Veterinary vet3 = new Veterinary(3, "male", d1, 300000000);

        //Creatng treatment
        Treatment initialTreatment = new Treatment(d1, "This is an inital treatment");
        Medication initialMedication = new Medication("İntial medication", 2, d1, 2, "This is an initial medication for the program to start");
        initialTreatment.getMedications().add(initialMedication);//Get medications returns the medications arrayList in initialTreatment instance

        //Assigning treatments to the cows
        initialCow1.getTreatments().add(initialTreatment);//Get treatments returns the treatments arrayList in initialCow1 instance
        initialCow2.getTreatments().add(initialTreatment);
        initialCow3.getTreatments().add(initialTreatment);
        //Adding inital cows  to arraylist one by one
        myFarmobject.cows.add(initialCow1);
        myFarmobject.cows.add(initialCow2);
        myFarmobject.cows.add(initialCow3);
        //Adding initial vets to the Arraylist one by one
        myFarmobject.vets.add(vet1);
        myFarmobject.vets.add(vet2);
        myFarmobject.vets.add(vet3);
    }
}
