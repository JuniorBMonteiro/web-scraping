import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writing implements Runnable {
    private final String FILE = "src/main/resources/url.csv";
    private String url;

    public Writing(String url) {
        this.url = url;
    }

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))){
            bw.write(url);
            bw.newLine();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
