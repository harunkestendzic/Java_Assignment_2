import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class MostScoresAgainOneTeam {
    public static String generate(ArrayList<Score> scores){
        String player = scores.stream()
                .collect(Collectors.groupingBy(s -> s.getPlayerName() + " against " + s.getTeamName(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + ": " +entry.getValue())
                .orElse("No scores found");

        return player;
    }
}
