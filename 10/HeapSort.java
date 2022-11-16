package week10;
import java.util.Arrays;

/**
 *  A heap sort implementation.
 *
 * @author Jayden Prakash.
 */
public class HeapSort extends Sorter {

    /** Allows Methods to work with int[].
     */
    public int[] num;
    /**
     *  Create a new HeapSort sorter.
     * 
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums); 
    }

    /**
     * Sort the integers. 
     */
    public void sortNums() {
        
        comparisons = 0;
        num= Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
        build(num);
        int[] result = new int[nums.length];
        int end = num.length-1;

        for (j = 0; j < num.length; j++) {
            result[j] = num[0];  
            num[0] = num[end];
            num[end] = 0;
            end--;   
            build(num);
            update();
        }

        
        end = result.length-1;   
        for (i = 0; i < nums.length; i++) {
            nums[i] = result[end];
            end--;
        }
    }

    /**
     * make a heap structure.
     * @param input int[] to make heap from.
     */
    public void build(int[] input) {
        for (i = (input.length-2)/2; i >= 0; i--) {
            maxHeap(input,i);
        }
    }

    /**
     * make a heap a maxheap.
     * @param heap max heap to be checked.
     * @param i current parent node.
     */
    public void maxHeap(int[] heap, int i) {
        int biggestChild;
        int max = i;
        int temp = 0;
        if (hasKids(heap, i)) {
            if (has2Kids(heap, i)) {
                if (heap[2*i+1] > heap[2*i+2]) {
                    biggestChild = 2*i+1;
                } else {
                    biggestChild = 2*i+2;
                }
            } else {
                biggestChild = 2*i+1;
            }
            if (heap[biggestChild] > heap[i]) {
                comparisons++;
                max = biggestChild; 
                temp = heap[i];
                heap[i] = heap[biggestChild];
                heap[biggestChild] = temp;
            }

            if (max != i) {
                maxHeap(heap, biggestChild);
            }
            update();
        }
    }



    /**
     * exception handle to check if one or two kids.
     * @param heap max heap to be checked
     * @param i  current parent node
     * @return true if two kids, false if just one.
     */
    public boolean has2Kids(int[] heap, int i) {
        try {
            int test = heap[2*i+2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    /**
     * exception handle to check if has any kids at all.
     * @param heap max heap to be checked
     * @param i  parent node
     * @return true if not a leaf false if opposite.
     */
    public boolean hasKids(int[] heap, int i) {
        try {
            int test = heap[2*i+1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

}
