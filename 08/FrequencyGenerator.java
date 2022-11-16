package week08;

import java.util.*;
import java.io.*;

/** Generates a random word based on frequencies.
    @author Jayden Prakash
*/

public class FrequencyGenerator implements WordGenerator {

    /** Random variable to ensure samex randomness.
     */
    private Random random;

    /** Array implementing letter-frequencies.txt initialised.
     */
    private double[] freq = new double[countLines("letter-frequencies.txt")];

    /** Constructor provided with code.
        @param r is fed into method to keep random consistent.
    */
    public FrequencyGenerator(Random r) {
        random = r;
    }

    /** Scans in a file with letter frequencies that is converted to an array.
        @return array with letter frequencies
    */
    public double[] scanFrequencies(){
        try{
            Scanner sc = new Scanner(new File("letter-frequencies.txt"));
            while (sc.hasNextDouble()){
                for (int i = 0; i < freq.length; i++){
                    freq[i] = sc.nextDouble();
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return freq;
    }

    /** Counts amount of lines in a file.
        @param s name of file
        @return count of lines in the file, used to set size of array
    */
    public int countLines(String s){
        int count = 0;
        try{
            Scanner sc = new Scanner(new File(s));
            while (sc.hasNextLine()){
                count++;
                sc.nextLine();
            }
            return count;
        } catch (FileNotFoundException e){
            System.out.println("File Not Foud");
        }
        return count;
    }

    /** Returns random index number.
        @param freq is the array produced by scanFrequencies.
        @return int which is the random index.
    */
    public int getIndex(double[] freq){
        int i = 0;
        double d = random.nextDouble();
        while (d > freq[i]){
            d = d-freq[i];
            i++;
        }
        return i;
    }

    /** Builds a random word using getIndex and scanFrequencies.
        @param l length of the word.
        @return randomly generated word.
    */
    public String nextWord(int l){
        StringBuilder word  = new StringBuilder();
        for(int i = 0; i < l; i++){
            char c = (char) ('a' + getIndex(scanFrequencies()));
            word.append(c);
        }
        return word.toString();
    }

}
