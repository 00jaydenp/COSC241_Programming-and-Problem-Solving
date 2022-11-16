package week02;
import java.util.Random;
/**
   Lab02 COSC243 University of Otago.
   @author Jayden Prakash
   March 2020
**/
public class Coins{
    /** Boolean variable that makes HEADS = true. **/
    public static final boolean HEADS = true;
    /**Boolean variable that makes TAILS = false. **/
    public static final boolean TAILS = false;
    /** Boolean array Coins that will contain values of HEADS or TAILS. **/
    private boolean[] coins;

    /** Tests for instances of coins.
        @param args (unused)
    **/
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        System.out.println(c.toString()); //test out toString() method
        Coins s = new Coins("HHTTHHTTHH");
        System.out.println(s.toString()); // test out String constructor
        Coins i = new Coins(5);
        System.out.println(i.toString()); // test out Length constructor
        System.out.println(s.countRuns()); // test out countRuns() method
    }
    /** Creates a coins object from an input boolean.
        @param coins (boolean array to assign values to initial boolean array)
    **/
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    /** Returns an int with the amount of heads in the array.
        @return number of heads in coin flip
    **/
    public int countHeads(){
        int headsCount =0;
        for(int i=0; i<coins.length;i++){
            if(coins[i]){
                headsCount++;
            }
        }
        return headsCount;
    }
    /** toString method that returns a string representation of the coin tosses.
        @return the result of the coin flips. H for head T for tails
    **/
    public String toString(){
        String flipResult="";
        for(int i=0; i<coins.length; i++){
            
            if(coins[i]){
                flipResult += "H";
            } else{
                flipResult +="T";
            }  
        }
        return flipResult;
    }
    /** Creates a Coins object from a string.
        @param c (string consisting entirely of H and T char's)
    **/
    public Coins(String c){
        boolean [] x = new boolean[c.length()];
        for(int i = 0; i < x.length; i++){
            if(c.charAt(i) == 'H'){
                x[i]= true;
            } else{
                x[i]= false;
            }
        }
        this.coins = x;
    }
                
                    
    /** Constructs a Coins object consisting of a series of length coins.
        Value of each coin is determined by a random coin toss.
        @param length (int determining length of array)
    **/
    public Coins(int length){
        boolean[] a = new boolean[length];
        Random ranInt = new Random();
        for(int i = 0; i<a.length;i++){
            int x = ranInt.nextInt(2);
            if(x == 0){
                a[i]=true;
            } else{
                a[i]=false;
            }
        }
        this.coins=a;
    }
    /** Counts the amount of 'runs' in a coins array.
        @return number of runs in an array
    **/
    public int countRuns(){
        int runCount = 1;
        for(int i= 1; i <coins.length; i++){
            if(coins[i] != coins[i-1]){
                runCount++;
            }
        }
        return runCount;
    }
        
}

