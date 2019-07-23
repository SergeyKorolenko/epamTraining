package by.epam.task3.util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Сергей
 * 
 */
public class Matrices {
	
	private final static Logger LOG = LogManager.getLogger(Arrays.class.getName());
	private final static Random RANDOM = new Random();
	private final static double START = 1.0;
	private final static double END = 100.0;
	
	/**
	 * This method checks a matrix on null or zero length. Use this method  before using other methods 
	 * if you do not want to get wrong results or exceptions.
	 * 
	 * @param matrix the matrix to be checked
	 * @return {@code true} if the matrix is null or has zero length; {@code false} otherwise.
	 */
	public static boolean isMatrix(double[][] matrix) {
		if(matrix != null && matrix.length != 0) {
			return true;
		}
		LOG.info("The matrix does not exist or has zero length");
		return false;
	}
	
	/**
	 * This method searches a maximum element of a matrix.
	 * 
	 * @param matrix the matrix to be searched
	 * @return the array which contains two coordinates of the minimum element; [-1,-1] otherwise.
	 */
	public static int[] findMax(double[][] matrix) {
		int[] result = {-1, -1};
		
		if(isIdenticalElements(matrix)){
			return result;
		}
		int maxI = 0;
		int maxJ = 0;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] > matrix[maxI][maxJ]) {
					maxI = i;
					maxJ = j;
				}
			}
		}
		
		result[0] = maxI;
		result[1] = maxJ;
		LOG.info("The coordinates of the max element are [" + maxI + ", " + maxJ + "]");
		return result;
	}
	
	/**
	 * This method searches a minimum element of a matrix.
	 * 
	 * @param matrix the matrix to be searched
	 * @return the array which contains two coordinates of the minimum element; [-1,-1] otherwise.
	 */
	public static int[] findMin(double[][] matrix) {
		int[] result = {-1, -1};
		
		if(isIdenticalElements(matrix)){
			return result;
		}
		
		int minI = 0;
		int minJ = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] < matrix[minI][minJ]) {
					minI = i;
					minJ = j;
				}
			}
		}
		
		result[0] = minI;
		result[1] = minJ;
		LOG.info("The coordinates of the min element are [" + minI + ", " + minJ + "]");
		return result;
	}
	
	/**
	 * This method checks a matrix on identical elements.
	 * 
	 * @param matrix the matrix to be checked
	 * @return {@code true} if all elements of the matrix are identical;
	 * {@code false} otherwise.
	 */
	private static boolean isIdenticalElements(double[][] matrix) {
		int i = 0;
		boolean isGo = true;
		int length = matrix[0].length - 1;
		
		while(isGo && i < matrix.length) {
			int j = 0;
			while(isGo && j < length) {
				if(matrix[i][j] != matrix[i][j+1]) {
					isGo = false;
				}
				j++;
			}
			i++;
		}
		LOG.info("Are all elements of the matrix identical: " + isGo);
		return isGo;
	}
	
	/**
	 * This method checks a matrix on all positive elements. Use this method before using of the method which
	 * calculates the geometric mean of all elements.
	 * 
	 * @param matrix the matrix to be checked
	 * @return {@code true} if all elements of the matrix are positive; {@code false} otherwise.
	 */
	public static boolean isPositiveElements(double[][] matrix) {
		boolean flag = true;
		int i = 0;
		
		while(flag && i < matrix.length) {
			int j = 0;
			
			while(flag && j < matrix[i].length) {
				if(matrix[i][j] <= 0) {
					flag = false;
				}
			}
		}
		LOG.info("Are all elements of the matrix positive: " + flag);
		return flag;
	}
	
	/**
	 * This method calculates a geometric mean of all elements of a matrix. If you want to get a right result
	 * you will need to use the method "isPositiveElements(double[][] matrix)".
	 * 
	 * @param matrix the matrix to be calculated
	 * @return the geometric mean of the matrix
	 */
	public static double findGeometricMean(double[][] matrix) {
		double composition = 1.0;
		int amount = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				composition *= matrix[i][j];
				amount++;
			}
		}
		double result = Math.pow(composition, 1.0 /amount);
		LOG.info("The geometric mean of the matrix is " + result);
		return result;
	}
	
	/**
	 * This method calculates an arithmetic mean of all elements of a matrix.
	 * 
	 * @param matrix the matrix to be calculated
	 * @return the geometric mean of the matrix
	 */
	public static double findArithmeticMean(double[][] matrix) {
		double sum= 0.0;
		int amount = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
				amount++;
			}
		}
		double result = sum / amount;
		LOG.info("The arithmetic mean of the matrix is " + result);
		return result;
	}
	
	/**
	 * This method checks the matrix for symmetry about the main diagonal. Use the 
	 * method "isQuadrantMatrix(int row, int column)" before using this method.
	 * 
	 * @param matrix the matrix to be checked
	 * @return {@code true} if the matrix is symmetry about the the main diagonal; {@code false} otherwise
	 */
	public static boolean isMainSymmetrical(double[][] matrix) {
		int i = 0; 
		boolean flag = true;
		int length = matrix.length - 1;
		
		while(flag && i < length) {
			int j = i + 1;
			while(flag && j < matrix.length) {
				if(matrix[i][j] != matrix[j][i]) {
					flag = false;
				}
				j++;
			}
			i++;
		}
		LOG.info("Is the matrix symmetry about the the main diagonal: " + flag);
		return flag;
	}
	
	/**
	 * This method checks a matrix for symmetry about the secondary diagonal. Use the 
	 * method "isQuadrantMatrix(int row, int column)" before using this method.
	 * 
	 * @param matrix the matrix to be checked
	 * @return {@code true} if the matrix is symmetry about the secondary diagonal; {@code false} otherwise.
	 */
	public static boolean isIncidentalSymmetrical(double[][] matrix) {
		boolean flag = true;
		int length = matrix.length - 1;
		int end = length;
		int i = 0;
		
		while(flag && i < length) {
			int j = 0;
			while(flag && j < end) {
				if(matrix[i][j] != matrix[length-j][length-i]) {
					flag = false;
				}
				j++;
			}
			end--;
			i++;
		}
		LOG.info("Is the matrix symmetry about the secondary diagonal: " + flag);
		return flag;
	}
	
	/**
	 * This method swaps two elements of a matrix.
	 * 
	 * @param matrix the matrix to be swapped two elements
	 * @param i index of the first element
	 * @param j index of the second element
	 */
	private static void swap(double[][] matrix, int i, int j) {
		double temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}
	
	/**
	 * The method transposes a matrix. Use the method "isQuadrantMatrix(int row, int column)" 
	 * before using this method.
	 * 
	 * @param matrix the matrix to be transposed.
	 */
	public static void transpose(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix.length; j++) {
				swap(matrix, i, j);
			}
		}
		LOG.info("The matrix has been transposed");
	}
	
	/**
	 * This method checks that a matrix is quadrant or not. Use this method before 
	 * using "transpose(double[][] matrix)", "isMainSymmetrical(double[][] matrix)",
	 * "isIncidentalSymmetrical(double[][] matrix)".
	 * 
	 * @param row amount of rows in the matrix.
	 * @param column amount of columns in the matrix.
	 * @return {@code true} if this matrix is quadrant; {@code false} otherwise.
	 */
	public static boolean isQuadrantMatrix(int row, int column) {
		return row == column;
	}
	
	/**
	 * This method searches the first local maximum of a matrix. 
	 * 
	 * @param matrix the matrix to be searched
	 * @return the array which contains two coordinates of the first local maximum; [-1,-1] otherwise.
	 */
	public static int[] findLocalMax(double[][] matrix) {
		int[] result = {-1, -1};
		boolean flag = true;
		int i = 1;
		int lengthI = matrix.length - 1;
		
		while(flag && i < lengthI){
			int j = 1;
			int lengthJ = matrix[i].length - 1;
			
			while(flag && j < lengthJ) {
				if(isMax(matrix, i, j)) {
					result[0] = i;
					result[1] = j;
					flag = false;
				}
				j++;
			}
			i++;
		}
		LOG.info("The coordinates of the local max of the matrix are [" + result[0] + ", " + result[1] + "]");
		return result;
	}
	
	/**
	 * This method checks all elements of a matrix around central element.
	 * 
	 * @param m the matrix to be checked
	 * @param i the first coordinate of central element
	 * @param j the second coordinate of central element
	 * @return {@code true} if all elements around the central element are less than central element;
	 * {@code false} otherwise;
	 */
	private static boolean isMax(double[][] m, int i, int j) {
		if(m[i][j] > m[i-1][j-1] && m[i][j] > m[i-1][j] && m[i][j] > m[i-1][j+1] 
				&& m[i][j] > m[i][j-1] && m[i][j] > m[i][j+1] 
				&& m[i][j] > m[i+1][j-1] && m[i][j] > m[i+1][j] && m[i][j] > m[i+1][j+1]){
			return true;
		}
		return false;
	}
	
	/**
	 * This method searches the first local minimum of a matrix. 
	 * 
	 * @param matrix the matrix to be searched
	 * @return the array which contains two coordinates of the first local minimum; [-1,-1] otherwise.
	 */
	public static int[] findLocalMin(double[][] matrix) {
		int[] result = {-1, -1};
		boolean flag = true;
		int i = 1;
		int lengthI = matrix.length - 1;
		
		while(flag && i < lengthI){
			int j = 1;
			int lengthJ = matrix[i].length - 1;
			
			while(flag && j < lengthJ) {
				if(isMin(matrix, i, j)) {
					result[0] = i;
					result[1] = j;
					flag = false;
				}
				j++;
			}
			i++;
		}
		LOG.info("The coordinates of the local min of the matrix are [" + result[0] + ", " + result[1] + "]");
		return result;
	}
	
	/**
	 * This method checks all elements of a matrix around central element.
	 * 
	 * @param m the matrix to be checked
	 * @param i the first coordinate of central element
	 * @param j the second coordinate of central element
	 * @return {@code true} if all elements around the central element are bigger than central element;
	 * {@code false} otherwise; 
	 */
	private static boolean isMin(double[][] m, int i, int j) {
		if(m[i][j] < m[i-1][j-1] && m[i][j] < m[i-1][j] && m[i][j] < m[i-1][j+1] 
				&& m[i][j] < m[i][j-1] && m[i][j] < m[i][j+1] 
				&& m[i][j] < m[i+1][j-1] && m[i][j] < m[i+1][j] && m[i][j] < m[i+1][j+1]){
			return true;
		}
		return false;
	}
	
	/**
	 * This method represents a matrix as a string
	 * 
	 * @param matrix the matrix to be represented
	 * @return formed matrix as the string
	 */
	public static String toString(double[][] matrix) {
		if(matrix == null) {
			return "null";
		}
		if(matrix.length == 0) {
			return "[][]";
		}
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(j == matrix[i].length - 1) {
					result.append(matrix[i][j] + "\n");
				}else {
					result.append(matrix[i][j] + " ");
				}
			}
		}
		return result.toString();
	}
	
	public static void fill(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = RANDOM.nextDouble() * END + START;
			}
		}
		LOG.info("The matrix has bee filled");
	}
	
}
