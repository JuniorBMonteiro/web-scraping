public class App {
    public static void main(String[] args) {
        Reading reading = new Reading("src/main/resources/exemplo.html");
        Thread thread = new Thread(reading);
        thread.start();
    }
}
