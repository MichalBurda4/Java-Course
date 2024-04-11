import java.util.ArrayList;
import java.util.Scanner;

public class Problem115A {

    static ArrayList<Integer>[] pracownicy; //tablica z hierarchia pracownikow

    public static void main() {
        //skanujemy ilosc pracownikow
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        //Ograniczenie dla n czyli dla liczby pracowików
        if (n < 1 || n > 2000) {
            System.out.println("Zla ilosc pracownikow");
            return;
        }
        //lista sasiedztwa dla kazdego pracownika
        pracownicy = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            pracownicy[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int manager = s.nextInt();
            if (manager != -1) {
                pracownicy[manager - 1].add(i);
            }
        }
        //wypisywanie wyniku ilosci grup
        int grupy = findMinimumGroups();
        System.out.println(grupy);
    }

    //Funkcja znajduje minimalna liczbe grup

    static int findMinimumGroups() {
        //Sprawdzamy czy pracownik został już odwiedzony
        boolean[] odwiedzeni = new boolean[pracownicy.length];
        int grupy = 0;

        //iterujemy po pracownikach
        for (int i = 0; i < pracownicy.length; i++) {
            if (!odwiedzeni[i]) {
                boolean podwladni = false;
                //sprawdzamy przełożonych
                for (int subordinate : pracownicy[i]) {
                    if (!odwiedzeni[subordinate]) {
                        podwladni = true;
                        break;
                    }
                }
                //pracownik nie ma podwładnych czyli tworzy nowa grupe
                if (!podwladni) {
                    grupy++;
                    opp(i, odwiedzeni);
                }
            }
        }

        return grupy; //zwracamy liczbe grup
    }

    //funkcja do odwiedzania podwladnych pracownikow
    static void opp(int pracownik, boolean[] odwiedzony) {
        odwiedzony[pracownik] = true;
        //Rekurencyjnie odwiedzamy podwładnych. przełożonych
        for (int podwladny : pracownicy[pracownik]) {
            if (!odwiedzony[podwladny]) {
                opp(podwladny, odwiedzony);
            }
        }
    }
}
