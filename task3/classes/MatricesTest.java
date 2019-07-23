package by.epam.task3.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.epam.task3.util.Matrices;

/**
 * 
 * @author Сергей
 *
 */
public class MatricesTest {
	
	private double[][] matrix1;
	private double[][] matrix2;
	private double[][] matrix3;
	private double[][] matrix4;
	private double[][] matrix5;
	private double[][] matrix6; 
	private double[][] nullMatrix;
	private double[][] zeroLength;
	
	@Before
	public void init() {
		matrix1 = new double[][]{
								{1.0, 2.0, 3.0, 4.0}, 
								{2.0, 1.0, 5.0, 6.0}, 
								{3.0, 5.0, 1.0, 7.0}, 
								{4.0, 6.0, 7.0, 1.0}
								};
		matrix2 = new double[][]{
								{1.0, 2.0, 10.0, 4.0}, 
								{2.0, 1.0, 5.0, 6.0}, 
								{3.0, 5.0, 1.0, 7.0}, 
								{4.0, 6.0, 7.0, 1.0}
								};
		matrix3 = new double[][]{
								{4.0, 3.0, 2.0, 1.0}, 
								{6.0, 5.0, 0.0, 2.0}, 
								{7.0, 10.0, 5.0, 3.0}, 
								{2.0, 7.0, 6.0, 4.0}
								};
		
		matrix4 = new double[][]{
								{7.0, 2.0, 3.0}, 
								{3.0, 1.0, 5.0}
								};
		matrix5 = new double[][]{
								{7.0, 2.0, 3.0}, 
								{3.0, 1.0, 5.0}, 
								{2.0, 8.0, 7.0}};
		matrix6 = new double[][]{
								{7.0, 2.0, 3.0}, 
								{3.0, 10.0, 5.0}, 
								{2.0, 8.0, 7.0}
								};
		
		nullMatrix = null;
		zeroLength = new double[0][];
	}
	
	@After
	public void remove() {
		matrix1 = null;
		matrix2 = null;
		matrix3 = null;
		matrix4 = null;
		matrix5 = null;
		matrix6 = null;
		
		zeroLength = null;
	}
	
	@Test
	public void isMatrixTest() {
		assertEquals(false, Matrices.isMatrix(nullMatrix));
		assertEquals(false, Matrices.isMatrix(zeroLength));
		assertEquals(true, Matrices.isMatrix(matrix1));
	}
	
	@Test
	public void mainSymmetricalTest() {
		assertEquals(true, Matrices.isMainSymmetrical(matrix1));
		assertEquals(false, Matrices.isMainSymmetrical(matrix2));
	}
	
	@Test
	public void incidentalSymmetricalTest() {
		assertEquals(true, Matrices.isIncidentalSymmetrical(matrix3));
		assertEquals(false, Matrices.isIncidentalSymmetrical(matrix2));
	}

	@Test
	public void transposeTest() {
		double[][] matrix = {
							{1.0, 2.0}, 
							{3.0, 4.0}
							};
		double[][] endMatrix = {
								{1.0, 3.0}, 
								{2.0, 4.0}
								};
		Matrices.transpose(matrix);
		for(int i = 0; i < endMatrix.length; i++) {
			for(int j = 0; j < endMatrix[i].length; j++) {
				assertEquals(endMatrix[i][j],  matrix[i][j], 0.0);
			}
		}
	}
	
	@Test
	public void localMinTest() {
		int[] result = Matrices.findLocalMin(matrix4);
		int[] array = new int[]{-1, -1};
		assertArrayEquals(array, result);
		result = Matrices.findLocalMin(matrix5);
		array = new int[]{1, 1};
		assertArrayEquals(array, result);
		result = Matrices.findLocalMin(matrix3);
		array = new int[]{1, 2};
		assertArrayEquals(array, result);
	}
	
	@Test
	public void localMaxTest() {
		int[] result = Matrices.findLocalMax(matrix6);
		int[] array = {1, 1};
		assertArrayEquals(array, result);
		result = Matrices.findLocalMax(matrix5);
		array = new int[]{-1, -1};
		assertArrayEquals(array, result);
		result = Matrices.findLocalMax(matrix3);
		array = new int[]{2, 1};
		assertArrayEquals(array, result);
	}
	
	@Test
	public void findMaxTest() {
		int[] result = Matrices.findMax(matrix6);
		int[] array = {1, 1};
		assertArrayEquals(array, result);
		result = Matrices.findMax(matrix5);
		array = new int[]{2, 1};
		assertArrayEquals(array, result);
		result = Matrices.findMax(matrix1);
		array = new int[]{2, 3};
		assertArrayEquals(array, result);
	}
	
	@Test
	public void findMinTest() {
		int[] result = Matrices.findMin(matrix6);
		int[] array = {0, 1};
		assertArrayEquals(array, result);
		result = Matrices.findMin(matrix5);
		array = new int[]{1, 1};
		assertArrayEquals(array, result);
		result = Matrices.findMin(matrix2);
		array = new int[]{0, 0};
		assertArrayEquals(array, result);
	}
	
}
