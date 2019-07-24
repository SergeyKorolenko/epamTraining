package by.epam.task3.util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Сергей
 * 
 */
public class Arrays {
	
	private final static Logger LOG = LogManager.getLogger(Arrays.class.getName());
	private final static Random RANDOM = new Random();
	private final static double START = 1.0;
	private final static double END = 100.0;
	
	/**
	 * This method checks an array on null or zero length. Use this method before using other 
	 * methods if you want to get right results.
	 * 
	 * @param array the array to be checked
	 * @return {@code true} if the array is not null or does not have zero length; 
	 * {@code false} otherwise.
	 */
	public static boolean isArray(double[] array) {
		if(array != null && array.length !=0) {
			return true;
		}
		LOG.info("The array does not exist or has zero length" );
		return false;
	}
	
	/**
	 * This method searches a maximum value of an array.
	 * 
	 * @param array the array to be searched
	 * @return index of the maximum element; -1 otherwise.
	 */
	public static int findMax(double[] array){
		if(isIdenticalElements(array)) {
			return -1;
		}
		int max = 0;
		
		for(int i = 1; i < array.length; i++) {
			if(array[i] > array[max]) {
				max = i;
			}
		}
		LOG.info("The index of the max element of the array " + Arrays.toString(array) + " is " + max);
		return max;
	}
	
	/**
	 * This method searches a minimum element of an array.
	 * 
	 * @param array the  array to be searched
	 * @return index of the minimum element; -1 otherwise.
	 */
	public static int findMin(double[] array) {
		if(isIdenticalElements(array)) {
			return -1;
		}
		int min = 0;
		
		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[min]) {
				min = i;
			}
		}
		LOG.info("The index of the min element of this array " + Arrays.toString(array) + " is " + min);
		return min;
	}
	
	/**
	 * This method checks an array on identical elements.
	 * 
	 * @param array the array to be checked
	 * @return {@code true} if all elements of the array are identical; {@code false} otherwise.
	 */
	private static boolean isIdenticalElements(double[] array) {
		boolean isResult = true;
		int i = 0;
		int length = array.length - 1;
		
		while(isResult && i < length) {
			if(array[i] != array[i+1]) {
				isResult = false;
			}
			i++;
		}
		LOG.info("This array " + Arrays.toString(array) + " has identical elements or not: " + isResult);
		return isResult;
	}
	
	/**
	 * This method checks an array on all positive elements. It can be used before using the method which
	 * calculates a geometric mean.
	 * 
	 * @param array the array to be checked
	 * @return {@code true} if all elements of the array are positive; {@code false} otherwise.
	 */
	public static boolean isPositiveElements(double[] array) {
		boolean flag = true;
		int i = 0;
		
		while(flag && i < array.length) {
			if(array[i] <= 0) {
				flag = false;
			}
			i++;
		}
		LOG.info("Are all elements of the array " + Arrays.toString(array) + " positive: " + flag);
		return flag;
	}
	
	/**
	 * This method calculates a geometric mean of all elements of an array. 
	 * Use method "isPositiveElements" before using this method if you want to get right result.
	 * 
	 * @param array the array to be calculated 
	 * @return the geometric mean of all elements of the array
	 */
	public static double findGeometricMean(double[] array) {
		double composition = 1.0;
		int amount = 0;
		
		for(int i = 0; i < array.length; i++) {
			composition *= array[i];
			amount++;
		}
		double result = Math.pow(composition, 1.0 / amount);
		LOG.info("The geometric mean of the array " + Arrays.toString(array) + " is " + result);
		return result;
	}
	
	/**
	 * This method calculates an arithmetic mean of all elements of an array.
	 * 
	 * @param array the array to be calculated
	 * @return the arithmetic mean
	 */
	public static double findArithmeticMean(double[] array) {
		double sum = 0.0;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		double result = sum / array.length;
		LOG.info("The arithmetic mean of the array " + Arrays.toString(array) + " is " + result);
		return result;
	}
	
	/**
	 * This method checks an array on strict increase of all elements.
	 * 
	 * @param array the array to be checked
	 * @return {@code true} if the array forms the strict increasing sequence; {@code false} otherwise.
	 */
	public static boolean isStrictIncrease(double[] array) {
		int end = array.length - 1;
		boolean result = true;
		int i = 0;
		
		while(result && i < end) {
			if(array[i] >= array[i+1]) {
				result = false;
			}
			i++;
		}
		LOG.info("Does the array " + Arrays.toString(array) + " form the strict increasing sequence: " + result);
		return result;
	}
	
	/**
	 * This method checks an array on increase of all elements.
	 * 
	 * @param array the array to be checked
	 * @return {@code true} if the array forms the increasing sequence; {@code false} otherwise.
	 */
	public static boolean isIncrease(double[] array) {
		int end = array.length - 1;
		boolean result = true;
		int i = 0;

		while(result && i < end) {
			if(array[i] > array[i+1]) {
				result = false;
			}
			i++;
		}
		LOG.info("Does the array " + Arrays.toString(array) + " form the increasing sequence: " + result);
		return result;
	}
	
	/**
	 * This method checks an array on strict decrease of all elements.
	 * 
	 * @param array
	 * @return {@code true} if the array forms the strict decreasing sequence; {@code false} otherwise.
	 */
	public static boolean isStrictDecrease(double[] array) {
		int end = array.length - 1;
		boolean result = true;
		int i = 0;
		
		while(result && i < end) {
			if(array[i] <= array[i+1]) {
				result = false;
			}
			i++;
		}
		LOG.info("Does the array " + Arrays.toString(array) + " form the strict decreasing sequence: " + result);
		return result;
	}
	
	/**
	 * This method checks an array on decrease of all elements.
	 * 
	 * @param array the array to be checked
	 * @return {@code true} if the array forms a decreasing sequence; {@code false} otherwise.
	 */
	public static boolean isDecrease(double[] array) {
		int end = array.length - 1;
		boolean result = true;
		int i = 0;
		
		while(result && i < end) {
			if(array[i] < array[i+1]) {
				result = false;
			}
			i++;
		}
		LOG.info("Does the array " + Arrays.toString(array) + " form the decreasing sequence: " + result);
		return result;
	}
	
	/**
	 * This method searches the first local minimum of an array.
	 * 
	 * @param array the array to be searched
	 * @return index of the first local minimum of the array; -1 otherwise.
	 */
	public static int findLocalMin(double[] array) {
		int result = -1;
		boolean flag = true;
		int i = 1;
		int length = array.length - 1;
		
		while(flag && i < length) {
			if(array[i-1] > array[i] && array[i] < array[i+1]) {
				result = i;
				flag = false;
			}
			i++;
		}
		LOG.info("The index of the local min elemennt of this array " + Arrays.toString(array) + " is " + result);
		return result;
	}
	
	/**
	 * This method searches the first local maximum of an array.
	 * 
	 * @param array the array to be searched
	 * @return index of the first local maximum of the array; -1 otherwise.
	 */
	public static int findLocalMax(double[] array) {
		int result = -1;
		boolean flag = true;
		int i = 1;
		int end = array.length - 1;
		
		while(flag && i < end) {
			if(array[i-1] < array[i] && array[i] > array[i+1]) {
				result = i;
				flag = false;
			}
			i++;
		}
		LOG.info("The index of the local max elemennt of this array " + Arrays.toString(array) + " is " + result);
		return result;
	}
	
	/**
	 * This method searches element in an array using linear search method.
	 * 
	 * @param array the array to be searched
	 * @param key element to be searched
	 * @return index of the searched element of the array; -1 otherwise.
	 */
	public static int linearSearch(double[] array, double key) {
		int result = -1;
		boolean flag = true;
		int i = 0;
		
		while(flag && i < array.length) {
			if(array[i] == key) {
				result = i;
				flag = false;
			}
			i++;
		}
		LOG.info("The index of the searched elemennt of this array " + Arrays.toString(array) + " is " + result);
		return result;
	}
	
	/**
	 * This method searches element in an array using binary search method.
	 * 
	 * @param array the array to be searched
	 * @param key element to be searched
	 * @return index of the searched element of the array; -1 otherwise.
	 */
	public static int binarySearch(double[] array, double key) {
		int result = -1;
		int start = 0;
		int end = array.length - 1;
		boolean flag = true;
		int mid = 0;
		
		while(flag && start <= end) {
			mid = (start + end) / 2;
			double midVal = array[mid];
			
			if(midVal < key) {
				start = mid + 1;
			} else if(midVal > key) {
				end = mid - 1;
			} else {
				result = mid;
				flag = false;	
			}
		}
		LOG.info("The index of the searched elemennt of this array " + Arrays.toString(array) + " is " + result);
		return result;
	}
	
	/**
	 * This method swaps two elements of an array. 
	 * 
	 * @param array the array to be swapped
	 * @param first index of the first element
	 * @param second index of the second element
	 */
	private static void swap(double[] array, int first, int second) {;
		double temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	/**
	 * This method reverses all elements of an array.
	 * 
	 * @param array the array to be reversed
	 */
	public static void reversArray(double[] array) {
		int middle = array.length / 2;	
		for(int i = 0, j = array.length - 1; i < middle; i++, j--) {
			swap(array, i, j);
		}
	}
	
	/**
	 * This method sorts an array using bubble sort method.
	 * 
	 * @param array the array to be sorted
	 */
	public static void bubbleSort(double[] array) {
		for(int i = array.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j+1]) {
					swap(array, j, j+1);
				}
			}
		}
	}
	
	/**
	 * This method sorts an array using insertion sort method.
	 * 
	 * @param array the array to be sorted
	 */
	public static void insertionSort(double[] array) {
		int length = array.length - 1;
		
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j > 0; j--){
				if(array[j] < array[j-1] ) {
					swap(array, j, j-1);
				}
			}
		}
	}
	
	/**
	 * This method sorts an array using selection sort method.
	 * 
	 * @param array the array to be sorted
	 */
	public static void selectionSort(double[] array) {
		int length = array.length - 1;
		
		for(int i = 0; i < length; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			if(min != i) {
				swap(array, i, min);
			}
		}
	}
	
	/**
	 * This method sorts an array using merge sort method.
	 * 
	 * @param array the array to be sorted
	 * @param start index of the first element
	 * @param end index of the last element
	 */
	public static void mergeSort(double[] array, int start, int end)  
	{  
		if (start < end) { 
			int middle = (start + end) / 2;  
			mergeSort(array, start, middle);  
			mergeSort(array , middle + 1, end);  
			merge(array, start, middle, end);  
	    }
 
	} 
	
	/**
	 * This method merges two arrays into one.
	 * 
	 * @param array the array to be merged
	 * @param start index of the first element
	 * @param middle index of the middle element
	 * @param end index of the last element
	 */
	private static void merge(double[] array, int start, int middle, int end)  
	{  
		int left = middle - start + 1;  
		int right = end - middle;  
		double[] leftArray = new double[left];  
		double[] rightArray = new double[right]; 
		
		for (int i = 0; i < left; i++) { 
			leftArray[i] = array[start + i];  
		}
		for (int i = 0; i < right; i++) {
			rightArray[i] = array[middle + 1+ i];
		}
		int i = 0;
		int j = 0;  
		int k = start;  
		
		while(i < left && j < right) {  
			if (leftArray[i] <= rightArray[j]) {  
				array[k] = leftArray[i];  
				i++;  
			}else {  
				array[k] = rightArray[j];  
				j++;  
			}  
			k++;  
		}  
		while(i < left) {  
			array[k] = leftArray[i];  
			i++;  
			k++;  
		}  
		while(j < right) {  
			array[k] = rightArray[j];  
			j++;  
			k++;  
		}  
	}   
	
	/**
	 * This method sorts an array using quick sort method.
	 * 
	 * @param array the array to be sorted
	 */
	public static void quickSort(double[] array, int low, int high) {	
		int middle = low + (high - low) / 2;
		double pivot = array[middle];
		int i = low; 
		int j = high;
		
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		if (low < j) {
			quickSort(array, low, j);
		}
		if (high > i) {
			quickSort(array, i, high);
		}
	}
	
	/**
	 * This method represents an array as a string
	 * 
	 * @param array the array to be represented
	 * @return formed array as the string
	 */
	public static String toString(double[] array) {
		if(array == null) {
			return "null";
		}
		if(array.length == 0) {
			return "[]";
		}
		StringBuffer result = new StringBuffer("[");
		
		for(int i = 0; i < array.length; i++) {
			if(i != array.length - 1) {
				result.append(array[i] + ", ");
			} else {
				result.append(array[i] + "]");
			} 
		}
		return result.toString();
	}
	
	
	/**
	 * This method fills an array with random values.
	 * 
	 * @param array the array to be filled
	 */
	public static void fill(double[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = RANDOM.nextDouble() * END + START;
		}
		LOG.info("The array has bee filled");
	}
}
