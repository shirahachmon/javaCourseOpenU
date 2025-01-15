package Lesson2;
// second lesson

/** In our course, variable starts with an underscore if this is property of an object */
   
   public class Date{ // הגדרת כותרת המחלקה

      /** 
      * משתני המחלקה מוגדרים כפרטיים דבר האומר 
      * שניתן לגשת למשתנים במחלקה רק דרך המחלקה עצמה
      * נאפשר עדכון ערכים וקריאתם על ידי פעולות המוגדרות 
      * public
      */
      private int _day; // between 1-31 
      private int _month; // between 1-12
      private int _year; // positive 4 digit number


      /** final property is only with capital letters in our course. */
      private static final int DAY_DEFAULT= 1;
      private static final int MONTH_DEFAULT= 1;
      private static final int YEAR_DEFAULT= 2000;

      private static final int MIN_MONTH= 1;
      private static final int MAX_MONTH= 12;


      /** The constructor- 
       * פעולה המתאחלת את משתני המחלקה לערכים הנתונים. 
         בהגדרת פעולת הבנאי רושמים רק - public ____(name class)
         ללא הגדרת ערך חוזר כמו בכל פעולה אחרת
         הבדלה משאר הפעולות 
         */ 
      public Date(int day, int month, int year){
         // _day= day;
         // _month= month;
         // _year= year;

         /** ניתן להשתמש בבנאי אחר במחלקה על ידי שימוש בthis
          * call constructor
          */
         this(); 

         /** במקום לבדוק את התקינות של הנתונים בבנאי 
          * ניתן להשתמש בפעולות הקובעות את ערכו בsetters
          ומשנים את הערכים לחדשים רק אם הם תקינים ובטווח
          את הבדיקה אם תקינים מבצעים בפעולות עצמן של הsetters
          */
         setDay(day);
         setMonth(month);
         setYear(year);
      }

      public Date(){
         this._day= DAY_DEFAULT;
         this._month= MONTH_DEFAULT;
         this._year= YEAR_DEFAULT;
      }

      /** מימוש בנאי מעתיק
       * בנאי מסוג העתקה המקבל תאריך אחר ומעתיק את ערכיו
         */
      public Date(Date other){
         this._day= other._day;
         this._month= other._month;
         this._year= other._year;
      }

      /** GETTERS
       * פעולות אחזור פעולות המחזירות ערך
      המשתנים עצמם הינם פרטיים ולכן לא ניתן לגשת אליהם מחוץ למחלקה
      בכדי לאפשר לקרוא את ערכי המשתנים מממשים פעולות אחזור להחזרת ערכיהם 
      */

      public int getDay(){
         return _day;
      }
      
      public int getMonth(){
         return _month;
      }

      public int getYear(){
         return _year;
      }
   
      /** SETTERS */
      public void setDay(int newday){
         _day= newday;
      }

      public void setMonth(int newMonth){
         if (newMonth >= MIN_MONTH && newMonth >= MAX_MONTH)
            this._month= newMonth;
      }
      
      public void setYear(int newYear){
         _year= newYear;
      }

      /** בדיקת קדימות
       * השיטה before 
       * המקבלת כפרמטר תאריך מסוים ומחזירה האם התאריך שמיוצג על ידי האובייקט עליו מופעלת השיטה
       * קודמת לתאריך שהתקבל כפרמטר
       */
      public boolean before(Date other){
         if(this._year<other._year) return true;
         if(this._year>other._year) return false;
         
         if(this._month<other._month) return true;
         if(this._month>other._month) return false;

         return this._day<other._day;
      }

      public boolean equals(Date other){
         if(this._day==other._day && this._month==other._month &&  this._year == other._year) return true;
         return false; 
      }

      /** Another way to check foor equals dates.  */
      // public boolean equals(Date other){
      //    return this.toString().equals(other.toString())
      // }

      /** מחזירה מחרוזת תווים המייצג את התאריך או את האובייקט הכללי */
      public String toString(){
         return _day+"/"+_month+ "/"+_year;
      }
}