import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        try{

        ArrayList<String> teams = ReadFromFile.readTeams("teams.csv",false);
        Map<String,Integer> players = ReadFromFile.readPlayers("players.csv",false);
        ArrayList<Score> scores = ReadFromFile.readScores("scores.csv",false);

        ArrayList<Score> validScores = scores.stream()
                .filter(score -> {
                    if(teams.contains(score.getTeamName())) return true;
                    else{
                        System.out.println("Team " + score.getTeamName() + " doesn't exist");
                        return false;
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));

        scores = validScores;


        //1
        Set<String> playersWithAtLeast1 = AtLeastOneScore.generate(scores);
        if(WriteToFile.save("PlayersWithAtLeastOneScore.txt",playersWithAtLeast1)){
            System.out.println("PlayersWithAtLeastOneScore.txt has been successfully saved");
        }else{
            System.out.println("File could not be saved");
        }

        //2
        String playerWithMost = MostScoresAgainOneTeam.generate(scores);
        if(WriteToFile.save("PlayersWithMostScoresAgainstOneTeam.txt",playerWithMost)){
            System.out.println("PlayersWithMostScoresAgainstOneTeam.txt has been successfully saved");
        }else{
            System.out.println("File could not be saved");
        }

        //3
        ArrayList<String> playersWithWrongScore = PlayersWithWrongScore.generate(scores,players);
        if(WriteToFile.save("PlayersWithWrongScore.txt",playersWithWrongScore)){
            System.out.println("PlayersWithWrongScore.txt has been successfully saved");
        }else{
            System.out.println("File could not be saved");
        }
        //4


        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
