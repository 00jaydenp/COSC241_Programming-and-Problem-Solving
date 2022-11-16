package week10;

/**
 *  A quick sort  implementation.
 *
 * @author Jayden Prakash.
 */
public class QuickSort extends Sorter {

    /**
     *  Create a new sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums); 
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        quickSort(0, nums.length-1);
    }

    /**
     * method that divides nums and calls itself.
     * @param left  lower bound
     * @param right upper bound
     */
    public void quickSort(int left, int right) {
        if (left<right) {
            int i = partition(left, right);
            quickSort(left, i-1);
            quickSort(i+1,right);
        }
    }

    /**
     * method that finds the partition index.
     *
     * @param left  lower bound
     * @param right  upper bound
     * @return i the partition
     */
    public int partition(int left, int right) {
        int x = nums[right];
        j = left;
        i = j-1;
        int temp = 0;

        for (j = left; j < right; j++) {
            comparisons++;
            if (nums[j] < x) {
                i++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                update();
            }
        }
        i++;
        temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        comparisons++;
        update();
        return i;
    }
}
