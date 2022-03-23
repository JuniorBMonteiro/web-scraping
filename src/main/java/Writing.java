import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Writing implements Runnable {
    private final String FILE = "src/main/resources/url.csv";
    private final List<String> url;

    public Writing(List<String> url) {
        this.url = url;
    }

    @Override
    public synchronized void run() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))){
            bw.write(url.get(0));
            bw.write(";");
            url.remove(0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
