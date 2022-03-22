import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Reading implements Runnable {
    private final String file;
    private final List<String> urls = Collections.synchronizedList(new LinkedList<>());
    private final ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private final Writing writing = new Writing(urls);

    public Reading(String file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String row = br.readLine();
            while (row != null) {
                getUrl(row);
                row = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    private boolean hasTag(String row) {
        return row.contains("<a") && row.contains("href") && row.contains("http");
    }

    private void getUrl(String str) {
        String row = str;
        while (hasTag(row)) {
            int startIndex = row.indexOf("http");
            int endIndex = row.indexOf("\"", startIndex);
            urls.add(row.substring(startIndex, endIndex));
            threadPool.execute(writing);
            row = row.substring(endIndex);
        }
    }
}