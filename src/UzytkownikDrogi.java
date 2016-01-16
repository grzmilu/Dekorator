
abstract class UzytkownikDrogi {

    protected String kto = "Uzytkownik drogi";

    public String opis() {
        return kto;
    }

    public abstract String getSymbol();

    public abstract void setX(int x);

    public abstract void setY(int y);

    public abstract int getX();

    public abstract int getY();

    public abstract int predkosc();
}
