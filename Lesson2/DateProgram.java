package Lesson2;

// second lesson

public class DateProgram {

 
    public static void main (String[] args) {
        
        /** new- המילה
         * מקצה שטח בזיכרון
         * ערכי ברירת מחדל
         * מחזירה כתובת של העצם אותו היא הקצתה
         * היא מחזירה כתובת כי עושים לה פקודת השמה לדוגמא לd1
         * כל מה שמוגדר מטיפוס מחלקה הוא בעצם מצביע- הפעולה הבונה עושה זאת
         */

        Date d1= new Date(11, 11,2000);
        Date d2= new Date(1, 2,2019);
        Date d3= new Date(d1);
        System.out.println("d3 day:" + d3.getDay());
        Date d4= new Date();

        /** כעת יש ארבעה עצמים ארבעה הפניות בעלות כתובת אחרת בזיכרון
         * כי עשינו 4 פעמים new
         */

         d1.setMonth(12);
         System.out.println("d1 month:" + d1.getMonth()); /** d1 month will be 12 */

         d1.setMonth(15);
         System.out.println("d1 month:" + d1.getMonth()); /** d1 month will still be 12 because 15 is out of range. */


         /** השוואת ערכי עצמים */

         Date d5= new Date(15, 10,2021);
         Date d6= new Date(d5);
         /** ללא המילה new
          * ולכן כאן יש כפל הצבעות
          d7 וd5 מצביעים על אותו השטח
          אל ישים- להמנע מזה
          */
         Date d7= d5;

         System.out.println("d5 equals to d6:" + d5.equals(d6)); /** true  */
         d5.setMonth(12);
         System.out.println("d5 equals to d6:" + d5.equals(d6)); /** false  */

         /** הערכים בשניהם זהים אבל 
          * d5 d6
          הם עצמים שונים ולא מצביעים לאותו מקום בזיכרון 
          */
         System.out.println("d7 equals to d5:" + d7.equals(d5));  
         System.out.println("d7 equals to d6:" + d7.equals(d6)); 
         
         System.out.println("d7==d5:" + (d7==d5)); // true  
         System.out.println("d7==d6:" + (d7==d6));  // false 

    } 
}