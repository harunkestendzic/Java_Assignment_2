public class Player {
    private String name;
    private String teamname;
    private int score;

    @Override
    public String toString(){
        return name + " in team "+teamname+" scored "+score;
    }
    public String getName() {
        return name;
    }

    public String getTeamname() {
        return teamname;
    }

    public int getScore() {
        return score;
    }

    public Player(String name, String teamname, int score) {
        this.name = name;
        this.teamname = teamname;
        this.score = score;
    }
}
