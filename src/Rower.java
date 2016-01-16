
class Rower extends UzytkownikDrogi {

    private int x = 0;
    private int y = 0;

    public Rower() {
        kto = "Rowerzysta";
    }

    @Override
    public int predkosc() {
        return 2;
    }

    @Override
    public String getSymbol() {
        return "R";
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
