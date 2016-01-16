
class DekoratorSamochod extends Dekorator {

    UzytkownikDrogi uzytkownikDrogi;
    private int x = 0;
    private int y = 0;

    public DekoratorSamochod(UzytkownikDrogi uzytkownikDrogi) {
        this.uzytkownikDrogi = uzytkownikDrogi;
        x = uzytkownikDrogi.getX();
        y = uzytkownikDrogi.getY();
        kto="Samochod";
    }

    @Override
    public String opis() {
        return uzytkownikDrogi.kto + " zamienia się w samochod";
    }

    @Override
    public int predkosc() {
        return 3;
    }

    @Override
    public String getSymbol() {
        return "S";
    }

    @Override
    public void setX(int x) {
        this.x=x;
    }

    @Override
    public void setY(int y) {
        this.y=y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
