package week06;
import java.util.*;
/**
 * A program that reads up to 100 words and calculates the average word length.
 * 
 * @author Jayden Prakash
 */
public class LongWords{

    private static final int MAX_LIMIT = 100;

    /**
     * Main Method
     * @param args not used
     */
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int letterCount = 0;
        int wordCount = 0;
        double average = 0;
        String words = "";
        for (int i= 0; i < MAX_LIMIT; i++){
            if(sc.hasNext()){
                words = scan.next();
                wordCount++;
                letterCount+= words.length();
                scan.next();
            }
                

        }
    }
    
}
