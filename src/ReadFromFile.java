import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFromFile {
    public static Map<String,Integer> readPlayers(String path, boolean hasHeader) throws FileNotFoundException {
        File f = new File(path);
        Scanner s = new Scanner(f);

        if(hasHeader) if(s.hasNextLine()) s.nextLine();

        Map<String,Integer> players = new HashMap<>();

        while(s.hasNextLine()){
            String line = s.nextLine();
            String parts[] = line.split(",");

            if(parts.length != 2){
                System.out.println("ERROR: Wrong number of parameters: " + line);
                continue;
            }

            String name = parts[0].trim();
            if(name.isEmpty()) {
                System.out.println("ERROR: Emtpy name: " + line);
                continue;
            }

            Integer score = Integer.parseInt(parts[1].trim());

            players.put(name,score);
        }

        return players;

    }

    public static ArrayList<Score> readScores(String path, boolean hasHeader) throws FileNotFoundException {
        File f = new File(path);
        Scanner s = new Scanner(f);

        if(hasHeader) if(s.hasNextLine()) s.nextLine();

        ArrayList<Score> scores = new ArrayList<>();

        while(s.hasNextLine()){
            String line = s.nextLine();
            String parts[] = line.split(",");

            if(parts.length != 2){
                System.out.println("ERROR: Wrong number of parameters: " + line);
                continue;
            }

            String playerName = parts[0].trim();
            if(playerName.isEmpty()) {
                System.out.println("ERROR: Emtpy name: " + line);
                continue;
            }
            String teamName = parts[1].trim();
            if(teamName.isEmpty()) {
                System.out.println("ERROR: Emtpy name: " + line);
                continue;
            }


            Score sc = new Score(playerName,teamName);
            scores.add(sc);
        }

        return scores;

    }

    public static ArrayList<String> readTeams(String path,boolean hasHeader) throws FileNotFoundException {
        File f = new File(path);
        Scanner s = new Scanner(f);

        if(hasHeader) if(s.hasNextLine()) s.nextLine();

        ArrayList<String> teams = new ArrayList<>();

        while(s.hasNextLine()){
            String teamname = s.nextLine();

            teams.add(teamname);
        }

        return teams;

    }



}
