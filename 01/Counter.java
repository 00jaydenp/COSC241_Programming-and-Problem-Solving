package week01;

import java.util.Scanner;
/** Counter program which reads in input and returns the amount of words and
    lines in the input.
    @author Jayden Prakash
    Lab01
    COMP 241
**/
    
public class Counter{
    /**Takes input from system.in and returns the amount of words and lines.
       @param args **/
    public static void main(String args []){
        
        /** Scanner to take in user input.
            int variables to count words and lines.
        **/
        Scanner sc = new Scanner(System.in);
        int lines = 0;
        int words = 0;
     
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            lines++;
             
            Scanner word = new Scanner(s);
            while(word.hasNext()){
                words++;
                word.next();
            }
        }
        System.out.println("lines: " + lines + "\n" + "words: " + words);
      
    }
        
}

