import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Abstract class for all animals in the farm where similar attributes are saved.
 * @author Yağmur Saygılı
 * @version 1.0
 */
public abstract class  Animal {
    private int tagNo;
    private String gender;
    private LocalDate dateOfBirth;
    private boolean purchased;
    private HashMap<LocalDate,String> milking;// I assigned String here because it cannot be primitive type

    private ArrayList<Treatment> treatments;

    /**
     * Default constructor for animal abstract class with no parameters
     */
    public Animal() {
    }

    /**
     * Additional constructor for animal with only tagno given
     * @param tagNo unique tag number of the animal (sheep/cow)
     */
    public Animal(int tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * Main constructor for animal where all fields are atken from user except treatments and milking
     * Treatments and milking stays as empty for now
     * @param tagNo unique tag Number for animal
     * @param gender gender of the animal
     * @param dateOfBirth date of birth of the animal
     * @param purchased specifies if animal purchased or not
     */
    public Animal(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.milking = new HashMap<LocalDate,String>();
        this.treatments = new ArrayList<Treatment>();

    }

    public HashMap<LocalDate, String> getMilking() {
        return milking;
    }

    public void setMilking(HashMap<LocalDate, String> milking) {
        this.milking = milking;
    }

    public abstract void feeding();
    /**
     * This method is created to print each animal details individually
     */
    public abstract void printDetails();

    /**
     * Takes the difference between today's date and the animal's date of birth.
     * @return (int) the age of the animal
     */
    public int getAge(){
        int animalAge = 0;
        LocalDate todayDate = LocalDate.now();
        animalAge = todayDate.getYear() - this.dateOfBirth.getYear();
        return animalAge;
    }

    public int getTagNo() {
        return tagNo;
    }

    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }
}