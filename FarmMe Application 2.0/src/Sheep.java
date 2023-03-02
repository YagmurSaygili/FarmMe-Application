import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

/**
 * Sheep class where all the specific information about sheep is kept
 * @author Yağmur Saygılı
 * @version 1.0
 */
public class Sheep extends Animal {

    /**
     * Constructor with only tagno of the sheep is given
     * @param tagNo unique tag number of the sheep
     */
    public Sheep(int tagNo) {
        super(tagNo);
    }

    /**
     * Constructor with all necessary information about animal is given and declaring a sheep
     * @param tagNo unique tag number of the sheep
     * @param gender gender of the sheep
     * @param dateOfBirth date of birth of the sheep
     * @param purchased purchased or not ?
     */
    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased) {
        super(tagNo, gender, dateOfBirth, purchased);
    }

    /**
     * Feeding method for feeding a sheep according to its age and weight
     * This is overriding method from Animal abstract feeding method
     * Polymorphism is used
     */
    @Override
    public void feeding() {
        int age = this.getAge();
        String gender = this.getGender();
        System.out.print("Sheep is being fed with...");

        if ( age < 5 && "MALE".compareTo(gender.toUpperCase()) == 0){ // Here I avoid the lower case upper case situation for the same string
            System.out.println(" grass");
        } else if (age < 8 && "FEMALE".compareTo(gender.toUpperCase()) == 0 ) {// Female and younger than 8 years old
            System.out.println(" grass");
        } else if ("MALE".compareTo(gender.toUpperCase()) == 0) {// Male and older than 5 years old
            System.out.println(" TMR diet which is hay, fermented grass, maize silage and high energy grains");
        } else if ("FEMALE".compareTo(gender.toUpperCase()) == 0) {// Female and older than 8 years old
            System.out.println(" TMR diet which is hay, fermented grass, maize silage and high energy grains");
        }
        System.out.println("Feeding sheep operation is complete!");
    }

    /**
     * Display method for displaying all the details of sheep to the user
     * Milk measurements included
     */
    @Override
    public void printDetails(){
        System.out.print("\nThe sheep's \n" +
                "Tag No: " + this.getTagNo() +
                "\nGender : " + this.getGender() +
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
