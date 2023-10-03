package apnacollege.twodArray;

// Read more: https://www.java67.com/2014/10/how-to-create-and-initialize-two-dimensional-array-java-example.html#ixzz7UUVQyqQB
public class Transpose2DArray {
    public static void main(String[] args) {

//        int[][] matrix = new int[][]{
//                {1, 1, 1},
//                {2, 2, 2},
//                {3, 3, 3}
//        };

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        printMatrix(matrix);
        System.out.println("---------------------");
        int[][] transposedMatrix = transposeMatrix(matrix);
        printMatrix(transposedMatrix);
        System.out.println("---------------------");
//        int[][] transposedMatrixOpp = transposeMatrixOpposite(matrix);
//        printMatrix(transposedMatrixOpp);

    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    private static int[][] transposeMatrixOpposite(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        //for(int j = matrix[0].length - 1; j >= 0; j--)
        for(int j = 0; j < matrix[0].length; j++) {
            for(int i = matrix[0].length - 1; i >= 0; i--) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    //flip vertically
    private static int[][] flipVertically(int[][] matrix) {
        int[][] flippedMatrix = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++) {

        }

        return  flippedMatrix;
    }
}
