import java.util.Arrays;
import java.util.Scanner;

public class Mar17Q2 {
    public static void main(String[] args){
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
}
