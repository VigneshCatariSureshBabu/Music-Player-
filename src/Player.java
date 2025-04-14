import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Player {
    String filePath;
    File file;

    Player(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
    }

    void play() {
        try (Scanner scanner = new Scanner(System.in); AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.file)) {
            String response = "";
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            while (!response.equals("STOP")) {
                System.out.println("Enter P to Play the music");
                System.out.println("Enter S to Pause the music");
                System.out.println("Enter R to Play from start");
                System.out.println("Enter Q to Quit the music");
                System.out.print("Enter your choice : ");
                response = scanner.next().toUpperCase();
                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> response = "STOP";
                    default -> System.out.println("Invalid choice");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (LineUnavailableException e) {
            System.out.println("Unavilation to access : " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported AudioFile");
        } catch (IOException e) {
            System.out.println("IO Exception occured : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("Thanks for playing ");
        }
    }
}
