import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reading implements Runnable{
    private final String PATH = "src/main/resources/exemplo.html" ;
    private StringBuilder urls = new StringBuilder();
    private Writing writing = new Writing();
    Thread thread = new Thread(writing);

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(PATH)))) {
            String linha = br.readLine();
            while (linha != null) {
                if (linha.contains("<a href=")){
                    int caracteresIntermediarios = 9;
                    int indiceInicial = linha.indexOf("<a href=\"");
                    int indiceFinal = linha.indexOf("\"", indiceInicial+ caracteresIntermediarios);
                    String url = linha.substring(indiceInicial + caracteresIntermediarios, indiceFinal);
                    urls.append(url).append(";");
                    thread.run();
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(urls);
    }
}
