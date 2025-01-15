

/**
 * @author Shira Hachmon 
 */

 public class Weight {

    private int _kilos;  /** >=1  */
    private int _grams; /** 0-999 */

    private static final int DEFAULT_KILOS_WEIGHT= 1;
    private static final int DEFAULT_GRAMS_WEIGHT= 0;

    /** Max grams. */
    private static final int MAX_GRAMS= 999;

    /** Grams in one kilo. */
    private static final int GRAMS_IN_KILO= 1000;

    /** Helps us to extract last/first digit from a number. */
    private static final int DIGIT_HOLDER= 10;
        
    /** Constructor that accepts Weight in 2 parameters- kilos, and grams. */
    public Weight(int kilos, int grams){
        checkWeight(kilos, grams);
    }
    
    /** Constructor that accepts the Weight as an object. */
    public Weight(Weight other){
        _kilos = other._kilos;
        _grams= other._grams;
    }

    /** Constructor that gets a totalGram value & creates a weight object with kilo and grams separately. */
    public Weight(int totalGrams){
        /** totalGrams property validation is if greater than or equal to zero. */ 
        if(totalGrams<0) createDefaultWeight();
        else{   
            _kilos = totalGrams / GRAMS_IN_KILO;  
            _grams = totalGrams % GRAMS_IN_KILO;  
        }
    } 

    /** Gets weight then check it and if some value is not valid- update to the default. */
    private void checkWeight(int kilos, int grams){

        if(kilos<DEFAULT_KILOS_WEIGHT && (grams<DEFAULT_GRAMS_WEIGHT || grams>MAX_GRAMS)){
            createDefaultWeight();
        }else if(kilos<DEFAULT_KILOS_WEIGHT) _kilos= DEFAULT_KILOS_WEIGHT;
        else if(grams<DEFAULT_GRAMS_WEIGHT|| grams>MAX_GRAMS) _grams= DEFAULT_GRAMS_WEIGHT;
        else{
            this._kilos= kilos;
            this._grams= grams;
        }
    }

    /** Updating the instance with his default values. */
    private void createDefaultWeight(){
        this._kilos= DEFAULT_KILOS_WEIGHT;
        this._grams= DEFAULT_GRAMS_WEIGHT;
    }
    
    /** Gets Kilos */
    public int getKilos(){
        return _kilos;
    }
    
    /** Gets Grams */
    public int getGrams(){
        return _grams;
    }

    /** Check if both weights are equal. */
    public boolean equals(Weight other){
        return _kilos == other._kilos && _grams == other._grams;
    }

    /** Compare the total weight in grams for both objects, and check if our weight is lighter then the other. */ 
    public boolean lighter (Weight other){
        int thisTotalGrams = _kilos * GRAMS_IN_KILO +_grams;
        int otherTotalGrams = other._kilos * GRAMS_IN_KILO + other._grams;

        return thisTotalGrams < otherTotalGrams;
    }

    /** Check if the given weight is lighter then our weight. */
    public boolean heavier (Weight other){return !lighter(other);} 

    public Weight add(int grams){
        /** At first i`ll convert it all to totalGrams prop. */
        int totalGrams = (_kilos * GRAMS_IN_KILO  + _grams)+ grams;
        
        /** Check if the number is negative after the addition grams. */
        if (totalGrams < GRAMS_IN_KILO) return new Weight(_kilos, _grams);

        int updatedKilos = totalGrams / GRAMS_IN_KILO;
        int updatedGrams = totalGrams % GRAMS_IN_KILO;

        /** Return new instance of Weight with the updated values. */
        return new Weight(updatedKilos, updatedGrams);
    }

    public String toString() {
        double totalWeight = _kilos + (_grams / 1000.0f);
        /** I wanted to remove all unneccesery 0 in the end of the decimal number, so i used regex for replacements */
        String result = String.format("%.3f", totalWeight).replaceAll("\\.0+$", "");
        return result;
    }
}
