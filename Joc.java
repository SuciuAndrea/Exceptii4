public class Joc {
    private String team1;
    private String team2;
    private int scoreTeam1;
    private int scoreTeam2;
    private int totalOuts;
    private int totalCorners;

    public Joc(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.scoreTeam1 = 0;
        this.scoreTeam2 = 0;
        this.totalOuts = 0;
        this.totalCorners = 0;
    }

    public void simuleaza() {
        Minge minge = new Minge(50, 25);
        for (int i = 0; i < 1000; i++) {
            try {
                System.out.println(team1 + " - " + team2 + ": Mingea se afla la coordonatele (" + minge.getX() + "," + minge.getY() + ")");
                minge.suteaza();
            } catch (Out e) {
                totalOuts++;
                System.out.println(e.getMessage());
            } catch (Gol e) {
                if (i % 2 == 0) {
                    scoreTeam1++;
                } else {
                    scoreTeam2++;
                }
                System.out.println(e.getMessage());
                minge = new Minge(50, 25);
            } catch (Corner e) {
                totalCorners++;
                System.out.println(e.getMessage());
                minge = new Minge(minge.getX(), (minge.getY() < 25) ? 0 : 50);
            }
        }
    }

    @Override
    public String toString() {
        return "Joc intre " + team1 + " si " + team2  +
               "Scor: " + team1 + " " + scoreTeam1 + " - " + team2 + " " + scoreTeam2 + 
               "Total outs: " + totalOuts + 
               "Total corners: " + totalCorners;
    }

    public static void main(String[] args) {
        Joc joc1 = new Joc("Echipa1", "Echipa2");
        Joc joc2 = new Joc("Echipa3", "Echipa4");

        joc1.simuleaza();
        joc2.simuleaza();

        System.out.println(joc1);
        System.out.println(joc2);
    }
}
