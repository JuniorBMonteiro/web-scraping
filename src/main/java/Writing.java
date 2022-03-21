import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Writing implements Runnable {
    private final String FILE = "src/main/resources/url.csv";
    private List<String> url;

    public Writing(List<String> url) {
        this.url = url;
    }

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))){
            bw.write(url.get(url.size() -1));
            bw.newLine();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
