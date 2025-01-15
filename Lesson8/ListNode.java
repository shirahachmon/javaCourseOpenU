package Lesson8;

public class ListNode {

    // שרשרת חוליות- ListNode

    /** מבנה נתונים שאינו סטטי משמע שניתן להוסיף ולהוריד כמויות ואורכים של מבנה הנתונים
    נקרא מבנה נתונים דינמי- אין צורך להגדיר כמות של איברים 
     ניתן לדלל בתוך מבנה הנתונים, והתהליכים ללו נותנים עוצמה גדולה לגישה אליהם
     בקורס בלבד חוליה יכולה להכיל רק מספרים  */

    /** to each node we have the value and the next function, has recursive function
    first node contain the number 7 and points to next node that has the value of 10 and points 
    the next value that the last node will point of null.  */  

    public int sum(IntNode lst){
        int sum=0;
        while(lst!=null){
            sum+=lst.getData();
            lst=lst.getNext();
        }
        return sum; 
    }
    /** The same function but using recursive: */
    public int sumR(IntNode lst){
        if(lst==null) return 0;
        return lst.getData()+ sumR(lst.getNext()); 
    }


    /** Checks if any negative numbers in the node list.  */
    public static boolean negExists(IntNode lst){
        while(lst!=null){
            if(lst.getData()<0) return true;
            lst=lst.getNext();
        } 
        return false;
    }
    /** The same function but using recursive: */
    public static boolean negExistsR(IntNode lst){
        if(lst!=null) return false;
        return lst.getData()<0 || negExistsR(lst.getNext());
    }

    /** Checks if all nodes in node list are even values. */
    public static boolean allEven(IntNode lst){
        while(lst!=null){
            if(lst.getData()%2==1) return false;
            lst=lst.getNext();
        }
        return true;
    }
    /** The same function but using recursive: */
    public static boolean allEvenR(IntNode lst){
        if(lst==null) return true;
        return lst.getData()%2==0 && allEvenR(lst.getNext());
    }

    /** Checks for the maximum value in the nodes list */
    public static int findMax(IntNode p){
        int max=-1;
        while(p!=null){
            if(p.getData()> max)
             max= p.getData();
            p=p.getNext();
        }
        return max;
    }
    /** The same function but using recursive: */
    public static int findMaxR(IntNode p){
        if(p==null) return -1; 
        return Math.max(p.getData(), findMaxR(p.getNext()));
    }

    public static void createListNode(int[] arr){

        IntNode p= new IntNode(arr[0]);
        IntNode last=p;
        for(int i=1; i<arr.length; i++){
            last.setNext(new IntNode(arr[i]));
            last= last.getNext();
        }
    }

    /** How to create new node that is between two other nodes? 
     * we need to first set the new node to be before the next node of the first node exists. 
     * 
     * code will look like this:
     * IntNode temp= new IntNode(10, p.getNext());
     * p.setNext(temp)
     * 
     * Now there is another way to do this without the *temp* IntNode, code will be:
     * p.setNext(ne IntNode(10, p.getNext()));
     */

     /** How to cancel node from inside listNode? 
      * theres an option to cancel the first node, the middle one, the last,.....

      */

    
}
