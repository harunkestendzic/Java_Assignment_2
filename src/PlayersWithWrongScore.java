import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayersWithWrongScore {
    public static ArrayList<String> generate(ArrayList<Score> scores, Map<String, Integer> players) {

        Map<String,Long> actualScores = scores.stream()
                .collect(Collectors.groupingBy(Score::getPlayerName,Collectors.counting()));


        return players.entrySet().stream()
                .filter(entry -> {
                    long actualScore = actualScores.getOrDefault(entry.getKey(), 0L);
                    return entry.getValue() != actualScore;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
