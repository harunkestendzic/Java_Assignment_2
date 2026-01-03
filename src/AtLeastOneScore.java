import java.util.*;

public class AtLeastOneScore {
     public static Set<String> generate(ArrayList<Score> scores){
        Set<String> players = new HashSet<>();

         scores.forEach(score -> {
             players.add(score.getPlayerName());
         });

         return players;
     }
//     public static ArrayList<String> generate(ArrayList<Score> scores){
//         Map<String,String> playersMap = new HashMap<>();
//
//         scores.forEach(score -> {
//            playersMap.put(score.getPlayerName(),score.getTeamName());
//         });
//
//         ArrayList<String> players = new ArrayList<>();
//         playersMap.forEach((s, s2) -> {
//            players.add(s);
//         });
//
//         return players;
//     }

}
