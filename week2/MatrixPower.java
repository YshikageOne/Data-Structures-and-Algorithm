package week2;

public class MatrixPower {
	
	//Methods
	//made by me Mr.Clyde Allen Yu :D hehe
	
	//Multiply two matrices
	public static int[][] multiplyMatrix(int[][] a, int[][] b, int n){
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return result;
	}
	
	//Matrix Exponential
	public static int[][] matrixExponent(int[][] a, int k, int n){
		if(k == 1) {
			return a;
		}
		
		if((k % 2) == 0) {
			int[][] halfPower = matrixExponent(a, k/2 ,n);
			return multiplyMatrix(halfPower, halfPower, n);
		}
		else {
			int[][] halfPower = matrixExponent(a, (k-1) / 2, n);
			return multiplyMatrix(multiplyMatrix(halfPower, halfPower, n), a , n);
		}
	}
	
	//display matrix
	public static void displayMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        int exponent = 5;

        int[][] resultMatrix = matrixExponent(matrix, exponent, matrix.length);

        System.out.println("Input Matrix:");
        displayMatrix(matrix);

        System.out.println("\nMatrix raised to the power of " + exponent + ":");
        displayMatrix(resultMatrix);
        
        System.out.println("made by me Mr.Clyde Allen Yu :DDDDDD");
    }

}
