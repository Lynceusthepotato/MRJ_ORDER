import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
public class ArrayExercise {
    // Number 1 and 2
    private static void check(int[] arr, int toCheckValue){
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue){
                test = true;
                break;
            }
        }
        if(!test){
            System.out.println("The number you are searching are in another castle");
        }else{
            System.out.println("Yes the number you are searching are in the array");
        }
    }
    public static boolean areSame(Integer[] asd){
        Set <Integer> lol = new HashSet<>(Arrays.asList(asd));
        return (lol.size() == 1);
    }
    public static void main(String[] args){
        System.out.println("Number 1 and 2");
        int[] a = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 Number");
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        } for (int i = 0; i < 10;i++){
            System.out.println(a[i]);
        }
        Scanner ck = new Scanner(System.in);
        System.out.println("Enter a number to check if there is on the array");
        int[] arr = a;
        int toCheckValue = ck.nextInt();

        check(arr,toCheckValue);

        // Number 3
        System.out.println("Number 3");
        int[] Bruh = new int[20];
        int pos = 0;
        int neg = 0;
        int odd = 0;
        int even = 0;
        int zero = 0;

        Scanner f20 = new Scanner(System.in);
        System.out.println("Enter a 20 Number");
        for(int br = 0; br < 20; br++){
            Bruh[br] = f20.nextInt();

            if (Bruh[br]>0){
                pos++;
            } else if (Bruh[br]< 0 ){
                neg++;
            } else {
                zero++;
            }
            if(Bruh[br]%2 == 0){
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Positive : " + pos + "\nNegative : " + neg + "\nOdd : "+ odd + "\nEven : " + even + "\nZero : " + zero);

        // Number 4
        System.out.println("Number 4");
        int[] n = new int [5];
        int sum = 0;
        int big = n[0];
        int small = n[0];
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 5 Number to sum");
        for(int z = 0; z < 5 ; z++){
            n[z] = s.nextInt();
            sum = sum + n[z];
        }
        System.out.println("The sum is : " + sum);

        // Number 5
        System.out.println("Number 5");
        for(int b = 1; b < n.length; b++){
            if (n[b] > big){
                big = n[b];
            } else if (n[b] < small){
                small = n[b];
            }
        }
        System.out.println("Largest number is : " + big);
        System.out.println("Smallest number is : " + small);

        // Number 6
        System.out.println("Number 6");
        Integer[] ads = {1,2,3,4,5};
        if (areSame(ads)){
            System.out.println("All Elements are same");
        } else {
            System.out.println("Not all Elements are same");
        }

        // Number 7
        System.out.println("Number 7");
        int[] sp = new int[10];
        int[] fir = new int[5];
        int[] last = new int [5];
        Scanner pop = new Scanner(System.in);
        System.out.println("Enter 10 Number");
        for (int i = 0; i < 10; i++){
            sp[i] = pop.nextInt();
        }
        System.arraycopy(sp,0,fir,0,fir.length);
        System.arraycopy(sp,fir.length,last,0,last.length);
        System.out.println("Here are the first five");
        for (int i = 0; i < 5;i++){
            System.out.println(fir[i]);
        }
        System.out.println("Here are the last five");
        for (int i = 0; i < 5;i++){
            System.out.println(last[i]);
        }
        // Number 8

        // Number 9
        System.out.println("Number 9");
        int[] x = {1,2,3,4,5};
        int tmp;
        for(int i = 0; i <x.length/2;i++){
            tmp = x[i];
            x[i] = x[x.length - (i + 1 )];
            x[x.length - (i + 1)] = tmp;
        }
        for(int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
        // Number 10
        int temp;
        int[] n10 = new int[10];
        System.out.println("Enter all the elements:");
        for (int i = 0; i < 10; i++)
        {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < 10; i++)
        {
            for (int j = i + 1; j < 10; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.print("Ascending Order:");
        for (int i = 0; i < 10 - 1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[10 - 1]);
    }
}

