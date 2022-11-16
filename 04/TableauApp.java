package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(rowLengthsDecrease(valid));
        System.out.println(rowValuesIncrease(valid));
        System.out.println(columnValuesIncrease(valid));
        System.out.println(isSetOf1toN(valid));
        System.out.println(isTableau(valid));
                           
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t)&&rowValuesIncrease(t)&&
            columnValuesIncrease(t)& isSetOf1toN(t)){
            return true;
        }
        return false;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    
    /**
     * A method that checks if no row is longer than a preceding row.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a boolean value true or false.
     */
    public static boolean rowLengthsDecrease(int[][] t){
        if(t.length == 0){
            return false;
        }
        
        for(int i = 1; i < t.length; i++){
            if(t[i].length > t[i-1].length){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method that checks that values of tableau are increasing L to R.
     *
     * @param t a two dimensional array that represents a tableau.
     *
     * @return boolean value true or false.
     */
    public static boolean rowValuesIncrease(int [][] t){
        if(t.length == 0){
            return false;
        }
        
        for (int i = 0; i<t.length; i++){
            for(int x = 1; x<t[i].length; x++){
                if(t[i][x] < t[i][x-1]){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Method that checks that each value of a column is increasing.
     *
     * @param t a 2-d  array that represents a tableau.
     *
     * @return boolean value true or false.
     */
    public static boolean columnValuesIncrease(int [][] t){
        if (t.length == 0){
            return false;
        }
        for (int i = 1; i < t.length; i++){
            for (int x = 0; x<t[i].length; x++){
                if(t[i][x] <  t[i-1][x]){
                    return false;
                }
            }
       
        }
        return true;
    }

    /**
     * Method that checks if tableau is set of numbers from 1 to n.
     *
     * @param t a 2-D array  representing a tableau.
     *
     * @return boolean value true or false.
     */
    public static boolean isSetOf1toN(int[][] t){
        int cells = 0;
        boolean[] x;
        for (int i=0;i<t.length;i++){
            cells += t[i].length;
        }
        x = new boolean[cells];
        for(int i=0; i<t.length;i++){
            for(int y =0; y<t[i].length;y++){
                if(t[i][y] > cells){
                    return false;
                } else {
                    x[(t[i][y])-1]= true;
                }
            }
        }
        for(int i=0; i<x.length; i++){
            if(!x[i]){
                return false;
            }
        }
        return true;
    }
}


