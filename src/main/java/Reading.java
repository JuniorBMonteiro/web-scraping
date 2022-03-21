import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Reading implements Runnable {
    private String path;
    private List<String> urls = Collections.synchronizedList(new ArrayList<>());
    private final ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private Writing writing = new Writing(urls);

    public Reading(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String linha = br.readLine();
            while (linha != null) {
                String url = separaUrl(linha);
                if (url.contains("http")) {
                    urls.add(url);
                    threadPool.execute(writing);
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String separaUrl(String linha) {
        if (linha.contains("<a href=")) {
            int caracteresIntermediarios = 9;
            int indiceInicial = linha.indexOf("<a href=\"");
            int indiceFinal = linha.indexOf("\"", indiceInicial + caracteresIntermediarios);
            return linha.substring(indiceInicial + caracteresIntermediarios, indiceFinal);
        }
        return "";
    }
}
