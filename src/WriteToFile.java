import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class WriteToFile {
    public static boolean save(String fileName,Set<String> players){
        try{
            FileWriter fw = new FileWriter(fileName);
            for (String p : players) {
                fw.write(p + "\n");
            }
            fw.close();
            return true;
        }catch (IOException e){
            return false;
        }
    }
    public static boolean save(String fileName, ArrayList<String> players){
        try{
            FileWriter fw = new FileWriter(fileName);
            for (String p : players) {
                fw.write(p + "\n");
            }
            fw.close();
            return true;
        }catch (IOException e){
            return false;
        }
    }
    public static boolean save(String fileName,String player){
        try{
            FileWriter fw = new FileWriter(fileName);
            fw.write(player);
            fw.close();
            return true;
        }catch (IOException e){
            return false;
        }
    }
}
