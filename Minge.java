public class Minge {
    private int x;
    private int y;

    public Minge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void suteaza() throws Out, Gol, Corner {
        CoordinateGenerator generator = new CoordinateGenerator();
        this.x = generator.generateX();
        this.y = generator.generateY();

        if (y <= 0 || y == 50) {
            throw new Out("Out: Mingea a iesit din teren.");
        }  if ((x == 0 || x == 100) && (y >= 20 && y <= 30)) {
            throw new Gol("Gol: Mingea a intrat in poarta.");
        }  if (x == 0 || x == 100) {
            throw new Corner("Corner: Mingea a iesit pe la colt.");
        }
    }
}
