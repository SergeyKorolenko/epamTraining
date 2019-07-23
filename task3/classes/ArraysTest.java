package by.epam.task3.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import by.epam.task3.util.Arrays;

/**
 * 
 * @author Сергей
 *
 */
public class ArraysTest {
	
	private double[] array1;
	private double[] array2;
	private double[] array3;
	private double[] array4;
	private double[] array5;
	private double[] array6;
	private double[] array7;
	private double[] array8;
	private double[] array9;
	private double[] unsortedArray;
	private double[] sortedArray;
	private double[] nullArray;
	private double[] zeroArray;
	
	@Before
	public void init() {
		array1 = new double[]{11.9, 2.3, 1.6, 0.8, 5.7};
		
		array2 = new double[]{11.0};
		array3 = new double[]{11.9, 2.3};
		array4 = new double[]{11.9, 2.3, 1.6};
		
		array5 = new double[]{5.0, 5.0, 5.0, 5.0, 5.0};
		array6 = new double[]{1.0, 5.0, 5.0, 5.0, 5.0};
		array7 = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
		array8 = new double[]{5.0, 4.0, 3.0, 2.0, 1.0};
		array9 = new double[]{5.0, 5.0, 3.0, 2.0, 1.0};
		
		unsortedArray = new double[]{23.0, 42.0, 4.0, 16.0, 8.0, 15.0};
		sortedArray = new double[]{4.0, 8.0, 15.0, 16.0, 23.0, 42.0};
		
		nullArray = null;
		zeroArray = new double[0];
	}
	
	public void remove() {
		unsortedArray = null;
		sortedArray = null;
		zeroArray = null;
		array1 = null;
		array2 = null;
		array3 = null;
		array4 = null;
		array5 = null;
		array6 = null;
		array7 = null;
		array8 = null;
		array9 = null;
	}
	
	@Test
	public void isArrayTest() {
		assertEquals(false, Arrays.isArray(nullArray));
		assertEquals(false, Arrays.isArray(zeroArray));
		assertEquals(true, Arrays.isArray(array2));
		assertEquals(true, Arrays.isArray(array4));
	}
	
	@Test
	public void arithmeticMeanTest() {
		Double value = 4.459999999999999;
		Double result = Arrays.findArithmeticMean(array1);
		assertEquals(value, result);
		
		value = 5.0;
		result = Arrays.findArithmeticMean(array5);
		assertEquals(value, result);
	}
	
	@Test
	public void geometricMeanTest() {	
		Double value = 5.000000000000001;
		Double result = Arrays.findGeometricMean(array5);
		assertEquals(value, result);
	}
	
	@Test
	public void strictIncreaseTest() {
		assertEquals(true, Arrays.isStrictIncrease(array7));
		assertEquals(false, Arrays.isStrictIncrease(array1));
		assertEquals(false, Arrays.isStrictIncrease(array6));
	}
	
	@Test
	public void increaseTest() {
		assertEquals(true, Arrays.isIncrease(array7));
		assertEquals(false, Arrays.isIncrease(array1));
		assertEquals(true, Arrays.isIncrease(array6));
	}
	
	@Test
	public void strictDecreaseTest() {
		assertEquals(false, Arrays.isStrictDecrease(array7));
		assertEquals(true, Arrays.isStrictDecrease(array8));
		assertEquals(false, Arrays.isStrictDecrease(array9));
	}
	
	@Test
	public void decreaseTest() {
		assertEquals(false, Arrays.isDecrease(array7));
		assertEquals(true, Arrays.isDecrease(array8));
		assertEquals(true, Arrays.isDecrease(array9));
	}
	
	@Test
	public void minTest() {
		assertEquals(-1, Arrays.findMin(array5));
		assertEquals(3, Arrays.findMin(array1));
		assertEquals(0, Arrays.findMin(array7));
	}
	
	@Test
	public void maxTest() {
		assertEquals(-1, Arrays.findMax(array5));
		assertEquals(0, Arrays.findMax(array1));
		assertEquals(4, Arrays.findMax(array7));
	}
	
	@Test
	public void localMinTest() {
		assertEquals(3, Arrays.findLocalMin(array1));
		assertEquals(-1, Arrays.findLocalMin(array2));
		assertEquals(-1, Arrays.findLocalMin(array3));
		assertEquals(2, Arrays.findLocalMin(unsortedArray));
	}
	
	@Test
	public void localMaxTest() {
		assertEquals(-1, Arrays.findLocalMax(array1));
		assertEquals(-1, Arrays.findLocalMax(array2));
		assertEquals(-1, Arrays.findLocalMax(array3));
		assertEquals(1, Arrays.findLocalMax(unsortedArray));
	}
	
	@Test
	public void bubbleSortTest() {
		Arrays.bubbleSort(unsortedArray);
		assertArrayEquals(sortedArray, unsortedArray, 0.0);
	}
	
	@Test
	public void insertionSortTest() {
		Arrays.insertionSort(unsortedArray);
		assertArrayEquals(sortedArray, unsortedArray, 0.0);
	}
	
	@Test
	public void selectionSortTest() {
		Arrays.selectionSort(unsortedArray);
		assertArrayEquals(sortedArray, unsortedArray, 0.0);
	}
	
	@Test
	public void mergeSortTest() {
		Arrays.mergeSort(unsortedArray, 0, unsortedArray.length - 1);
		assertArrayEquals(sortedArray, unsortedArray, 0.0);
	}
	
	@Test
	public void quickSortTest() {
		Arrays.quickSort(unsortedArray, 0, unsortedArray.length - 1);
		assertArrayEquals(sortedArray, unsortedArray, 0.0);
	}

}
