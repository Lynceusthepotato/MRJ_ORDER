package Mar17A;

import java.util.Arrays;
import java.util.Scanner;

public class UTILITY {
    public static void number_1(){
        int narray;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the array[for the exercise enter 5] : ");
        narray = sc.nextInt();

        int x[]= new int[narray+1];
        for (int i = 0; i<narray; i++) {
            System.out.print("Enter a number[for the exercise enter 4 8 6 3 2]: ");
            x[i] = sc.nextInt();
        }
        int highest= x[0];
        int lowest = x[0];

        for (int i = 0; i < narray; i ++){
            if (x[i]>highest){
                highest = x[i];
            }
            if (x[i]<lowest){
                lowest = x[i];
            }
        }
        int nextHigh = 0;
        for (int j =0; j<narray; j++) {
            if(x[j] < highest){
                nextHigh=x[j];
                break;
            }
        }
        for (int k = 0; k < narray; k++){
            if(x[k]>nextHigh && x[k] < highest) {
                nextHigh = x[k];
            }
        }
        int a = highest;
        int b = highest -nextHigh;
        int c = nextHigh;

        for (int i = 0; i < narray+1; i++) {
            int a1= narray;
            if(x[i] != highest){
                System.out.print(x[i]+ " ");
            }
            else {
                x[i] = c;
                System.out.print(x[i]+ " ");
                while(a1>i){
                    x[a1] = x[a1-1];
                    a1--; }
                x[i+1] = b;
                System.out.print(x[i+1]+ " ");
                i++;
            }
        }
    }
    public static void number_2(){
        int[] x = {1,2,3,4,5};
        System.out.println("Enter ROT : ");
        Scanner sc = new Scanner(System.in);
        int nu1 = sc.nextInt();

        RR(x,nu1);
        System.out.println((Arrays.toString(x)));
    }
    public static void RRO(int[] x)
    {
        int L = x[x.length - 1];
        for(int i = x.length - 2; i >= 0; i--){
            x[i + 1] = x[i];
        }
        x[0] = L;
    }
    public static void RR(int[] x, int nu1){
        for (int i = 0; i < nu1; i ++){
            RRO(x);
        }
    }
    public static void number_3(){
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
    }
    public static void generateSquare(int n) {
        int[][] magicSquare = new int[n][n];
        // Initialize position for 1
        int i = n / 2;
        int j = n - 1;
        // One by one put all values in magic square
        for (int num = 1; num <= n * n; ) {
            if (i == -1 && j == n) //3rd condition
            {
                j = n - 2;
                i = 0;
            } else {
                //1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                //1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i = n - 1;
            }
            //2nd condition
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else
                //set number
                magicSquare[i][j] = num++;

            //1st condition
            j++;
            i--;
        }
        // print magic square
        System.out.println("The Magic Square for " + n + ":");
        System.out.println("Sum of each row or column " + n * (n * n + 1) / 2 + ":");
        display(magicSquare,n);
    }
    public static void display( int[][] magicSquare, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(magicSquare[i][j] + " ");
            System.out.println();
        }
    }

    // driver program
    public static void number_4 ()
    {
        // Works only when n is odd
        int n;
        System.out.println("Enter the size");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        generateSquare(n);
    }
}
