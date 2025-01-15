

/**
 * @author Shira Hachmon 
 */

public class Baby {

    private String _firstName;
    private String _lastName;
    private String _id;
    private Date _dateOfBirth;
    private Weight _birthWeight;
    private Weight _currentWeight;

    private static final int EXPECTED_GRAMS_AFTER_TWO_MONTHS= 53 * 30;
    private static final int EXPECTED_GRAMS_AFTER_THREE_MONTHS= 53 * 30 + 60 * 25;
    private static final int EXPECTED_GRAMS_AFTER_SEVEN_MONTHS= 53 * 30 + 60 * 25 + 120 * 16;
    private static final int DAYS_IN_MONTH= 30;
    private static final int DAYS_IN_WEEK= 7;
    private static final int GRAMS_IN_KILO= 1000;
    private static final int DAYS_IN_YEAR= 365;

    /** First constructor  */
    public Baby(String firstName, String lastName, String id, int day, int month, int year, int birthWeightInGrams) {
        _firstName = firstName;
        _lastName = lastName;
        _id = id.length()==9 ? id : "000000000";
        _dateOfBirth =  new Date(day, month, year);
        _birthWeight = new Weight(birthWeightInGrams);
        _currentWeight= new Weight(birthWeightInGrams);
    }

    /** Constructor that accepts Baby as an object. */
    public Baby(Baby other){
        _firstName = other._firstName;
        _lastName = other._lastName;
        _id = other._id;
        _dateOfBirth = other._dateOfBirth;
        _birthWeight = other._birthWeight;
        _currentWeight = other._currentWeight;
    }
    
    /** Get first name. */
    public String getFirstName(){ return _firstName;}

    /** Get last name.  */
    public String getLastName(){return _lastName;}
    
    /** Get the id. */
    public String getId(){return _id;}
    
    /** Get the date of birth. */
    public Date getDateOfBirth(){
        return new Date(_dateOfBirth);
    }
    
    /** Get the birth weight.  */
    public Weight getBirthWeight(){
        return new Weight(_birthWeight);
    }
    
    /** Get current weight */
    public Weight getCurrentWeight(){
        return new Weight(_currentWeight);
    } 

    /** Set current weight */
    public void setCurrentWeight(Weight weightToSet){
        int weightToSetInGrams=weightToSet.getKilos() * GRAMS_IN_KILO + weightToSet.getGrams();
        if(weightToSetInGrams>GRAMS_IN_KILO) _currentWeight= weightToSet;
    } 

    /** Check if babies are equal. */
    public boolean equals(Baby other) {
        if((_firstName != other._firstName) 
            || (_lastName != other._lastName) 
            || (_id != other._id) 
            || (_dateOfBirth.equals(other._dateOfBirth))) 
            return false;
        return true;  
    }

    /** Check if this baby and other baby are twins. */
    public boolean areTwins (Baby other){
         if(_firstName != other._firstName 
            && _lastName == other._lastName 
            && _id!= other._id 
            && (_dateOfBirth.equals(other._dateOfBirth) || _dateOfBirth.difference(other._dateOfBirth) <=1))
            return true;

        return false;
    } 

    /** Check if this baby is heavier then the other baby. */
    public boolean heavier (Baby other){
        if(_currentWeight.heavier(other._currentWeight)) return true;
        return false;
    }

    /** Add grams to the current weight baby. if any not valid value- keep the weight as it was. */
    public void updateCurrentWeight(int grams){
        _currentWeight= _currentWeight.add(grams); 
    } 

    /** Check if this baby is older then the other baby. */
    public boolean older (Baby other){
        return _dateOfBirth.before(other._dateOfBirth);
    }

    /** Check validtion of a baby in his proccess. */
    public int isWeightInValidRange(int numOfDays) {
        if (numOfDays<1 || numOfDays>DAYS_IN_YEAR) return 1;  
        else if (!isWeightProgressValid(numOfDays)) return 2;
        return 3;
    }
    
    /** Check progress validation by the website of one of the health funds of Israel. */
    private boolean isWeightProgressValid(int daysSinceBirth) {
        int birthWeightInGrams =  _birthWeight.getKilos() * GRAMS_IN_KILO + _birthWeight.getGrams();
        int currentWeightInGrams = _currentWeight.getKilos() * GRAMS_IN_KILO + _currentWeight.getGrams();
    
        if (daysSinceBirth < DAYS_IN_WEEK) {

            /** First week is allowed to lose up to 10% of the baby's body weight when he was born.  */
            int minWeightInGrams = (int)(birthWeightInGrams * 0.9); 
            return currentWeightInGrams >= minWeightInGrams;
        } else if (daysSinceBirth <= 2*DAYS_IN_MONTH) {

            /** During the first 60 days: an increase in the amount allowed of 30 grams per day (after the first week).  */
            int expectedWeightInGrams = birthWeightInGrams + (daysSinceBirth - DAYS_IN_WEEK) * DAYS_IN_MONTH;
            return currentWeightInGrams >= expectedWeightInGrams;
        } else if (daysSinceBirth <= 4*DAYS_IN_MONTH) {

            /** Up to the age of 4 months, a weight gain of at least 750 grams per month (25 grams per day) is allowed. */
            int expectedWeightInGrams = birthWeightInGrams + EXPECTED_GRAMS_AFTER_TWO_MONTHS + (daysSinceBirth - 2*DAYS_IN_MONTH) * 25;
            return currentWeightInGrams >= expectedWeightInGrams;
        } else if (daysSinceBirth <= 8*DAYS_IN_MONTH) {

            /** From the age of 4 months to 8 months: a permitted increase of 500 grams per month, meaning 16.6 grams per day.  */
            int expectedWeightInGrams = birthWeightInGrams + EXPECTED_GRAMS_AFTER_THREE_MONTHS + (int)((daysSinceBirth - 4*DAYS_IN_MONTH) * 16.6);
            return currentWeightInGrams >= expectedWeightInGrams;
        } else {

            /** From the age of 8 months to a year: a permitted increase of 250 grams per month, meaning 8.3 grams per day. */
            int expectedWeightInGrams = birthWeightInGrams + EXPECTED_GRAMS_AFTER_SEVEN_MONTHS + (int)((daysSinceBirth - 8*DAYS_IN_MONTH) * 8.3);
            return currentWeightInGrams >= expectedWeightInGrams;
        }
    }

    public String toString() {
        return "Name: " + _firstName + " " + _lastName + "\n" +
            "Id: " + _id + "\n" +
            "Date of Birth: " + _dateOfBirth.toString() + "\n" +
            "Birth Weight: " + _birthWeight.toString() + "\n" +
            "Current Weight: " + _currentWeight.toString() + "\n";
    }
}
