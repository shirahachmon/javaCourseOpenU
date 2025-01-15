
public class Date {
	private int _day;
	private int  _month;
	private int _year;

	//constructors:
	/**
	* creates a new Date object
	* @param day the day in the month(1-31)
	* @param month the month in the year(1-12)
	* @param year the year ( 4 digits)
	*/

	public Date(int day, int month, int year) {
		this._day = day;
		this._month = month;
		this._year = year;
	}
	
	/**
	* Copy Constructor
	* @param date to be copied
	*/
	public Date(Date other){
	  
		this._day = other._day;
		this._month = other._month;
		this._year = other._year;
	  
}
	
    /** gets the year
     * @return the year
     */ 
	  public int getYear(){
		return this._year;
	}
	
	/** gets the month 
	 * @return the month
	 */
	  public int getMonth(){
		return this._month;
	}
	
	/** gets the Day
	 * @return the day
	 */ 
	  public int getDay(){
		return this._day;
	}
	
	/** sets the year
	 * @param yearToSet the value to be set
	 */
	  public void setYear(int yearToSet){
		this._year = yearToSet;
	}
	
	/** set the month
	 * @param monthToSet the value to be set
	 */
	  public void setMonth(int monthToSet){
		this._month = monthToSet;
	}
	
	/** sets the day 
	 *  @param dayToSet the value to be set
	 */
	  public void  setDay(int dayToSet){
		this._day = dayToSet;
	}

	/** check if 2 dates are the same
	 * @param other the date to compare this date to
	 *  @return true if the dates are the same
	 */
        public boolean equals(Date other){
               if(this._day==other._day&&this._month==other._month&&this._year==other._year)
                      return true;
               return false;
            }
            /** check if the date is from the previous century
	 * 
	 *  @return true if the date is from the previous century
	 */
        public boolean lastCentury(){
               if (this._year<2000)
                    return true;
               return false;
            }
	
           /** check which date comes first
	 * @param other the date to compare this date to
	 *  @return 0 if the dates are the same, a value less than 0 if this date
	 *  comes before the date argument and a value greater than 0 if this date comes after the date  argument.
            */
       public int  compareTo(Date other){
               if(this.equals(other))
                    return 0;
               if(this._year<other._year)
                          return -1;
               if(this._year>other._year)
                           return 1;
                   //years same        
               if(this._month <other._month)
                           return -1;
               if(this._month>other._month)
                           return 1;        
                            //months  same        
               if(this._day <other._day)
                           return -1;
               else
                           return 1;        
                           
                      
            }

	/**
	 * returns a  String that represents this date
	 *
	* @return String that represents this date
	* in the following format:
	* day/month/year (30/9/1917)
	*/
	public String toString() {
		return this._day +"/" + this._month + "/" +this. _year;
	}
}