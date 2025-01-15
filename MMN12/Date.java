



/**
 * @author Shira Hachmon 
 */

public class Date {

    private int _day;
    private int _month;
    private int _year;

    private static final int DAY_DEFAULT= 1;
    private static final int MONTH_DEFAULT= 1;
    private static final int YEAR_DEFAULT= 2024;

    private static final int MIN_DAY= 1;
    private static final int MAX_DAY= 31;

    private static final int MIN_MONTH= 1;
    private static final int MAX_MONTH= 12;

    private static final int MIN_YEAR= 1000;
    private static final int MAX_YEAR= 9999;
    private static final int DAYS_IN_YEAR= 365;

    /** Constructor that accepts the date as 3 parameters- day, month, and year. */
    public Date(int day, int month, int year) {
        if(!isValidDate(day, month, year)) createDefaultDate();
        else{
            this._day= day;
            this._month= month;
            this._year= year;   
        }
    }
    
    /** Constructor that accepts the date as an object. */
    public Date(Date other){
        this._day= other._day;
        this._month= other._month;
        this._year= other._year;   
    }

    // private checkif
    /** empty constructor that inital a date with his default date value. */
    public Date(){
        createDefaultDate();
    }

    private void createDefaultDate(){
        this._day= DAY_DEFAULT;
        this._month= MONTH_DEFAULT;
        this._year= YEAR_DEFAULT;
    }
    
    /** Gets the year */
    public int getYear(){
        return _year;
    }
    
    /** Gets the month */
    public int getMonth(){
        return _month;
    }
    
    /** Gets the Day */
    public int getDay(){
        return _day;
    }
    
    /** Sets the year */
    public void setYear(int yearToSet){
        if(isValidDate(getDay(), getMonth(),yearToSet)) 
         _year = yearToSet; 
    }
    
    /** Sets the month */
    public void setMonth(int monthToSet){
        if(isValidDate(getDay(), monthToSet ,getYear())) 
            _month=monthToSet;
    }
    
    /** Sets the day */
    public void setDay(int dayToSet){
        if(isValidDate(dayToSet, getMonth() ,getYear())) 
            _day = dayToSet;
    }

    public boolean equals(Date other){
        if(this._day==other._day && this._month==other._month &&  this._year == other._year) return true;
        return false; 
    }
    
    /** Checks if this date comes before a given date */
    public boolean before(Date other){
        if(this._year<other._year) return true;
        if(this._year>other._year) return false;
        
        if(this._month<other._month) return true;
        if(this._month>other._month) return false;

        
        return this._day<other._day;
    }

    /** Checks if this date comes after a given date */
    public boolean after(Date other){
        return !before(other);
    }

    /** Calculates the absolute difference between two dates*/
    public int difference(Date other){
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year)); 
    } 

    /** Returns the day after the current. */
    public Date tomorrow(){
        int newDay = _day;
        int newMonth = _month;
        int newYear = _year;

        /** Adding 1 for the day value. */   
        newDay++;

        /** Next, i`ll check if the new day is greater than the max value in this month. */ 
        if (newDay > daysInMonth(_month, _year)) {
            newDay = 1; 
            newMonth++;

            /** If we pass the max value of the months(12)- then pass to the next year, and update the month to be Jan. */
            if (newMonth > 12) {
                newMonth = 1; 
                newYear++;
            }
        }

        return new Date(newDay, newMonth, newYear);
    }

     // Returns the days in month including leap year cases. 
     private int daysInMonth(int month, int year) {
        if(month == 2) return isLeapYear(year) ? 29 : 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        else return 31;
    }

    /** Checks validation of a given date. */
    private boolean isValidDate(int day, int month, int year){

         /** If dates are in the correct range.  */
         if(!((day>=MIN_DAY && day<=MAX_DAY) && (month>=MIN_MONTH && day<=MAX_MONTH) && (year>=MIN_YEAR && day<=MAX_YEAR)))
            return false;

        /** Check if the day is greater then it`s minimum day depending on the month and year it is in. */
        if(day> daysInMonth(month,year)) return false;

        return true;
    }


    // Computes the day number since the beginning of the Christian counting of years
    private int calculateDate(int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }

        return DAYS_IN_YEAR * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
    
    /** Checks if the year is a leap year by the Gregorian calendar. */
    private boolean isLeapYear(int year) { return (year%4==0 && year%100!=0) || (year%400==0) ? true : false; } 

    /** String that represents the date and take care of formatting as: dd/mm/yyyy */
    public String toString() {
        String formattedDay = (_day < 10 ? "0" : "") + _day;
        String formattedMonth = (_month < 10 ? "0" : "") + _month;

        return formattedDay +"/" + formattedMonth + "/" + _year;
    }
}
