public class Score {
    private String playerName;
    private String teamName;

    public String getPlayerName() {
        return playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return playerName + " : " + teamName;
    }

    public Score(String playerName, String teamName) {
        this.playerName = playerName;
        this.teamName = teamName;
    }
}
