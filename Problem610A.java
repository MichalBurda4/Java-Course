import java.util.Scanner;

public class Problem610A {
    public static void main() {
        //Podajemy długość kija
        Scanner s = new Scanner(System.in);
        System.out.print("Podaj dlugosc kija: ");
        int kij = s.nextInt();


        int count = 0;
        //Szukam wartosci boków prostokątów x-bok 1 2 y - bok 3 4
        for (int x = 1; x < kij / 2; x++) {
            for (int y = x; y < kij / 2; y++) {
                //wsarunmki
                //1.nie może być kwadratem
                //2.suma musi być równa długości kija
                if (x != y && x + x + y + y == kij) {
                    System.out.println("{"+x + ", " + x + ", " + y + ", " + y+"}"); //wypisanie możliwych prostokątów
                    count++;
                }
            }
        }


        //podajemy ilosc podziałów
        System.out.println("Ilość podziałów kija na prostokąty: " + count);
    }
}