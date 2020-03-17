import java.util.Scanner;

public class Mar17Q3 {
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Number of rows : ");
            int rows = sc.nextInt();
            System.out.println("Enter the Number of columns : ");
            int cols = sc.nextInt();
            int matrix[][] = new int[rows][cols];
            System.out.println("Enter the elements :");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("The matrix : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
            //Checking the input matrix for symmetric
            if (rows != cols) {
                System.out.println("the matrix is not square, so it cant be symmetric");
            } else {
                boolean symmetric = true;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] != matrix[j][i]) {
                            symmetric = false;
                            break;
                        }
                    }
                }
                if (symmetric) {
                    System.out.println("The matrix is symmetric");
                } else {
                    System.out.println("The matrix is not symmetric");
                }
            }
            sc.close();
        }
    }
}
