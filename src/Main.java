
import java.util.*;

public class Main {

    static int szerokosc, wysokosc;
    public static List<UzytkownikDrogi> listaUzytkownicy;
    static Random r = new Random();

    public static void main(String[] args) {
        listaUzytkownicy = new ArrayList<>();
        Scanner odczyt = new Scanner(System.in);
        //UzytkownikDrogi a = new DekoratorPieszy(new Pieszy());
        // System.out.println(a.opis());

        try {
            System.out.println("Podaj wysokosc planszy");
            wysokosc = Integer.parseInt(odczyt.nextLine());

            System.out.println("Podaj szerokosc planszy");
            szerokosc = Integer.parseInt(odczyt.nextLine());
        } catch (Exception e) {
            wysokosc = 10;
            szerokosc = 10;
            System.out.println("Niewlasciwe polecenie domyslna wielkosc 10x10");
        };

        wypisz();
        int wybor = 0;
        do {
            System.out.println("1.Dodaj pieszego, 2.Dodaj rowerzyste, 3.Dodaj samochod, 4.Ruszaj, 5.Zamien losowego uzytkownika drogi 6.Wyjdz");
            try {
                wybor = Integer.parseInt(odczyt.nextLine());
            } catch (Exception e) {
                wybor = 0;
                System.out.println("Niewlasciwe polecenie");
            };
            if (wybor == 1) {
                dodajPieszego();
            }
            if (wybor == 2) {
                dodajRowerzyste();
            }
            if (wybor == 3) {
                dodajSamochod();
            }
            if (wybor == 4) {
                ruch();
                if (kolizja() == true) {
                    wybor = 6;
                    System.out.println("Kolizja!");
                }
            }
            if (wybor == 5) {
                zamien();
            }

            wypisz();
        } while (wybor != 6);

    }

    public static void zamien() {
        int nr = r.nextInt(listaUzytkownicy.size());
        UzytkownikDrogi a;
        if (listaUzytkownicy.get(nr).getSymbol().equals("P")) {

            if (r.nextInt(2) == 0) {
                a = new DekoratorRower(listaUzytkownicy.get(nr));
            } else {
                a = new DekoratorSamochod(listaUzytkownicy.get(nr));
            }

        } else {
            if (listaUzytkownicy.get(nr).getSymbol().equals("R")) {
                if (r.nextInt(2) == 0) {
                    a = new DekoratorPieszy(listaUzytkownicy.get(nr));
                } else {
                    a = new DekoratorSamochod(listaUzytkownicy.get(nr));
                }
            } else {
                if (r.nextInt(2) == 0) {
                    a = new DekoratorPieszy(listaUzytkownicy.get(nr));
                } else {
                    a = new DekoratorRower(listaUzytkownicy.get(nr));
                }
            }
        }

        System.out.println(a.opis());
        listaUzytkownicy.add(nr, a);
        listaUzytkownicy.remove(nr + 1);

    }

    public static boolean kolizja() {
        for (int i = 0; i < listaUzytkownicy.size(); i++) {
            for (int j = i + 1; j < listaUzytkownicy.size(); j++) {
                if (listaUzytkownicy.get(i).getX() == listaUzytkownicy.get(j).getX() && listaUzytkownicy.get(i).getY() == listaUzytkownicy.get(j).getY()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void ruch() {
        int x, y;
        for (int i = 0; i < listaUzytkownicy.size(); i++) {
            x = listaUzytkownicy.get(i).getX() + (r.nextInt(3) - 1) * listaUzytkownicy.get(i).predkosc();
            y = listaUzytkownicy.get(i).getY() + (r.nextInt(3) - 1) * listaUzytkownicy.get(i).predkosc();
            if (x < 0) {
                x = 0;
            }
            if (x > szerokosc - 1) {
                x = szerokosc - 1;
            }
            if (y < 0) {
                y = 0;
            }
            if (y > wysokosc - 1) {
                y = wysokosc - 1;
            }
            listaUzytkownicy.get(i).setX(x);
            listaUzytkownicy.get(i).setY(y);
        }
    }

    public static void dodajPieszego() {
        UzytkownikDrogi a = new Pieszy();
        losujPolozenie(a);
    }

    public static void dodajRowerzyste() {
        UzytkownikDrogi a = new Rower();
        losujPolozenie(a);
    }

    public static void dodajSamochod() {
        UzytkownikDrogi a = new Samochod();
        losujPolozenie(a);
    }

    public static void losujPolozenie(UzytkownikDrogi a) {
        int x, y;
        boolean b = false;
        if (listaUzytkownicy.size() < szerokosc * wysokosc) {

            do {
                b = false;
                x = r.nextInt(szerokosc);
                y = r.nextInt(wysokosc);

                for (int jj = 0; jj < listaUzytkownicy.size(); jj++) {
                    if (listaUzytkownicy.get(jj).getX() == x && listaUzytkownicy.get(jj).getY() == y) {
                        b = true;
                    }
                }
            } while (b);
            a.setX(x);
            a.setY(y);
            listaUzytkownicy.add(a);
        } else {
            System.out.println("Nie ma juz miejsca na drodze dla kolejnego urzytkownika!!!");
        }
    }

    public static void wypisz() {
        int zz = -1;
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                for (int jj = 0; jj < listaUzytkownicy.size(); jj++) {
                    if (listaUzytkownicy.get(jj).getX() == j && listaUzytkownicy.get(jj).getY() == i) {
                        zz = jj;
                    }
                }
                if (zz != -1) {
                    System.out.print(listaUzytkownicy.get(zz).getSymbol() + " ");
                    zz = -1;
                } else {
                    System.out.print("= ");
                }

            }
            System.out.println();
        }
    }

}
