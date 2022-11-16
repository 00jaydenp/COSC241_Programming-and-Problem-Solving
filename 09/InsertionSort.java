package week09;
/**
 * Insertion Sort implementation.
 *
 * @author Jayden Prakash
 */
public class InsertionSort extends Sorter {

    /**
     *  Insertion Sort constructor that Insertion Sorts integers.
     * 
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Sort the integers. 
     */
    public void sortNums() {
        comparisons = 0;
        for (i = 1; i < nums.length; i++) {
            int key = nums[i];
            int temp = 0;
            j = i-1;

            while (j >= 0 && key < nums[j]) {
                comparisons++;
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j--;
                update();
            }
        }
    }
}
