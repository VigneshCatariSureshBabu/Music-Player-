public class Main {
    public static void main(String[] args) {
        String filePath = "src\\yendi.wav";
        Player player = new Player(filePath);
        player.play();
    }
}