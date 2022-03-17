public class App {
    public static void main(String[] args) {
        Reading reading = new Reading();
        Thread thread = new Thread(reading);
        thread.start();
    }
}
