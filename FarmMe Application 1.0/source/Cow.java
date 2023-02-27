import java.util.ArrayList;
import java.util.Date;

/**
 * Cow class to where all details about cow is kept and have basic operations
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.9
 */
public class Cow  {// Extend Farm me ?
    private int tagNo;
    private String gender;
    private Date dateOfBirth;
    private boolean purchased;
    //private int age; ???
    private ArrayList<Treatment> treatments;
    /**
     * Creating cow object with no information given
     */
    public Cow(){
        tagNo = 0;
        gender = "Not Given";
        dateOfBirth = new Date();
        purchased = false;
        treatments = new ArrayList<Treatment>();
    }
    /**
      * Creating cow object with provided information with lack of treatments
     * @param tagNo tag number of the cow
     * @param gender gender of the cow
     * @param purchased represents purchased or not
     * @param dateOfBirth dateofbirth of the cow

     */
    public Cow(int tagNo,String gender, Date dateOfBirth, boolean purchased){
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.treatments = new ArrayList<Treatment>();
    }
    /**
     * Creating veterinary object with provided information
     * @param tagNo tag number of the cow
     * @param gender gender of the cow
     * @param dateOfBirth dateofbirth of the cow
     * @param purchased represents purchased or not
     * @param treatments treatments that the cow has
     */

    public Cow(int tagNo, String gender, Date dateOfBirth, boolean purchased, ArrayList<Treatment> treatments) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.treatments = treatments;
    }

    public int getTagNo() { return this.tagNo; }
    public String getGender() { return this.gender; }
    public Date getDateOfBirth() { return this.dateOfBirth; }
    public  boolean getPurchased() { return this.purchased; }

    public void setTagno(int tagNo) { this.tagNo = tagNo; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth;}
    public  void setPurchased(boolean purchased) {this.purchased = purchased; }
    /**
     * Print method where all the details of the cow is displayed
     * This will be used in FarmMe class as main method
     */
    public  void printDetails(){//Can use polymorphism ??
        System.out.print("The cow's \n" +
                "Tag No: " + this.getTagNo() +
                "\nGender : " + this.gender +
                "\nDate Of Birth: " + this.dateOfBirth +
                "\nPurchased: " );
        if(this.purchased == true){System.out.println("Yes");}
        else{ System.out.println("\nFarm-raising\n");}
    }

    public  void getAge(){//Done
        int age = (2022) - (dateOfBirth.getYear()+1900);
        System.out.println("This Cow's age is " + age );
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }
}
