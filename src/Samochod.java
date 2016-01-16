
class Samochod extends UzytkownikDrogi {

    private int x = 0;
    private int y = 0;

    public Samochod() {
        kto = "Samochod";
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
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
