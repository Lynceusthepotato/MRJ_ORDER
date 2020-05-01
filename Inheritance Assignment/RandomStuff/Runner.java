package RandomStuff;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Makelist zoo = new Makelist();
        boolean flag = true;
        int cho;
        String species;

        while (flag) {
            System.out.println("\n================ \n1. insert species name \n2. show species name \n3. count how many species \n4. Find species (by name) \n5. Exit");
            System.out.println("Choose menu : ");
            Scanner ch = new Scanner(System.in);
            cho = ch.nextInt();
            if (cho == 1) {
                System.out.println("Enter species");
                Scanner sp = new Scanner(System.in);
                species = sp.nextLine();
                zoo.insert(species);
            }
            if (cho == 2 ){
                zoo.show_species_name();
            }
            if (cho == 3 ){
                zoo.show_how_much();
            }
            if ( cho == 4) {
                System.out.println("Enter species");
                Scanner sp = new Scanner(System.in);
                species = sp.nextLine();
                zoo.find_species(species);
            }
            if (cho == 5) {
                flag = false;
            }
        }
    }
}
