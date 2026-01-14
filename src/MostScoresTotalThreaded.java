import java.util.*;
import java.util.stream.Collectors;

public class MostScoresTotalThreaded {
    public static String generate(ArrayList<Score> scores) throws InterruptedException {

        Map<String, Integer> cnts = new HashMap<>();

        Runnable counter = () ->{
            for (Score s : scores) {
                String name = s.getPlayerName();
                int crnt = cnts.getOrDefault(name, 0);
                cnts.put(name, crnt + 1);
            }
        };

        Thread t = new Thread(counter);
        t.start();
        t.join();

        return cnts.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}