import java.util.Scanner;

public class num8 {
    public static void main(String[] args) {
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

}
