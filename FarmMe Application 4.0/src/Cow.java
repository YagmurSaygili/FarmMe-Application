import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 * Cow class to where all details about cow is kept and have basic operations
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.9
 */
public class Cow extends Animal {// Extend Farm me ?
   private double weight;

   /**
    * Constructor with only cow information is given
    * @param weight weight of the cow
    */
   public Cow(double weight) {
      this.weight = weight;
   }

   /**
    * Constructor with all necessary animal and specific cow information is given
    * @param tagNo tag number of the cow
    * @param gender gender of the cow
    * @param dateOfBirth date of birth of the cow
    * @param purchased cow is purchased or not ?
    * @param weight weight of the cow
    */
   public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, double weight) {
      super(tagNo, gender, dateOfBirth, purchased);
      this.weight = weight;
   }

   public double getWeight() {
      return weight;
   }

   public void setWeight(double weight) {
      this.weight = weight;
   }

   /**
    * Feeding method for feeding a cow according to its age and weight
    * This is overriding method from Animal abstract feeding method
    * Polymorphism is used
    */
   @Override
   public void feeding() {
      int age = this.getAge(); // Gets the cow's age from animal class
      double weight = this.getWeight();

      System.out.print("Feeding cow with");

      if (age < 3){
         System.out.println(" grass...");
      }
      else if (age < 5 && weight < 500) {
         System.out.println("TMR diet: hay, fermented grass, maize silage and high energy grains");
      } else if (age < 10) {
         System.out.println(" grains and oilseed meals");
      }
      else{
         System.out.println(" grass and grains...");
      }
      System.out.println("Cow feeding operation is complete!");
   }

   /**
    * A method to display all the information about the cow selected from the list to user
    * Milk measurements included
    */
   @Override
   public void printDetails(){
      System.out.print("\nThe cow's \n" +
              "Tag No: " + this.getTagNo() +
              "\nGender : " + this.getGender() +
              "\nWeight : " + this.getWeight() +
              "\nDate Of Birth: " + this.getDateOfBirth() +
              "\nPurchased: " );
      if(this.isPurchased()){System.out.print("Yes\n");}
      else{ System.out.print("Farm-raising\n");}
      System.out.print("The milking record:\n");
      for (LocalDate date: this.getMilking().keySet()) {
         String key = date.toString();
         String value = this.getMilking().get(date).toString();
         System.out.println(key + "= " + value);
      }
      System.out.print("\n\n");
   }

}
