
class DekoratorPieszy extends Dekorator {

    UzytkownikDrogi uzytkownikDrogi;
    private int x = 0;
    private int y = 0;

    public DekoratorPieszy(UzytkownikDrogi uzytkownikDrogi) {
        this.uzytkownikDrogi = uzytkownikDrogi;
        x = uzytkownikDrogi.getX();
        y = uzytkownikDrogi.getY();
        kto="Pieszy";
    }

    @Override
    public String opis() {
        return uzytkownikDrogi.kto + " zamienia się w pieszego";
    }

    @Override
    public int predkosc() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return "P";
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
