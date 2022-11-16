	package week10;
	/** 
	 * Quicksort implementation using Sorter Class
	 *
	 * @author Jayden Prakash
	 */
	 public class Quicksort extends Sorter {
		 /**
		  * Create a QuickSort Sorter with integers to sort
		  *
		  * @param nums array of integers to sort
		  */
		public Quicksort(Integer[] nums){
			super(nums);
		}
		
		/**
		 * Sort the integers
		 */
		 public void sortNums(){
			 comparisons = 0;
			 quickSort(0, nums.length-1);
		 }
		 
		 
		 /** 
		  * Quicksort method that takes a pivot and sorts either side of the pivot and repeats until done.
		  *
		  * @param low lower bound
		  * @param high higher bound
		  */
		  public void quickSort(int low, int high) {
			  if{low < high){
				  p = partition(low,high);
				  quickSort(low, p);
				  quickSort(p+1, high);
			  }
		 /**
		  * Method that partitions the array.
		  *
		  * @param low lower bound
		  * @param high higher bound
		  * @return hole partition
		  */
		  public int partition(int low, int high){
			  int pivot = nums[low];
			  hole = low;
			  i = low+1;
			  j = high;
			  int x = 0;
			  while( x < 1){
				  while( j>hole && nums[j] >= pivot){
					  j--;
				  }
				  if( j == hole){
					  x++;
				  }
				  nums[hole] = nums[j];
				  hole = j;
				  while( i < hole && nums[i] < pivot){
					  i++;
				  }
				  if( i == hole){
					  x++;
				  }
				  nums[hole] = nums[i];
				  hole = i;
			  }
			  nums[hole] = pivot;
			  return hole;
		  }
			  
				  
				  
		 
		 
	 }