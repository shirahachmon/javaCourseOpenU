/** Lesson 5 */

public class stringFunctions {
    
    /** We have learnt:
     * substring()
     * length()
     * chatAt()
     * equals()
     * indexOf()
     * toUpperCase()
     * contains()
     */

     /** Recursive string functions */
     
    /** בגלל שבמערכים אין לנו את הדרך להקטין את הבעיה
     * אז הדרך בה נוכל להקטין את הבעיה יש להוסיף משתנה מזהה מקום 
     * index
     * וכדי לעשות זאת יש לבנות שתי פונקצוית אחת פרטית אחת חיצונית 
     */
    
    public static boolean isPalindrom(String str){
        if(str.length()<2) return true;
        return str.charAt(0)==str.charAt(str.length()-1) && isPalindrom(str.substring(1, str.length()-1));
    }

    /** if abc is the input
     * the output will be abccba
     */
    public static String mirror(String str){
        if(str.equals("")) return str;
        return str.charAt(0) + mirror(str.substring(1)) + str.charAt(0);
    }

    /** We get two strings and we need to return true if those strings are alike 
     * and its ok if maximum one charcter is different
     * but have to be with the same length
     */
    public static boolean isAlmostEquals(String s1, String s2){
        if(s1.length()!=s2.length())return false;
        if(s1.length()==0)return true;
        if(s1.charAt(0)==s2.charAt(0)) 
            return isAlmostEquals(s1.substring(1), s2.substring(1));
        else return s1.substring(1).equals(s2.substring(1));
    }
     
}
