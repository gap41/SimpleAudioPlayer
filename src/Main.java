import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Red.wav");

        Scanner scanner = new Scanner(System.in);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        String response = "";

        while(!response.equals("Q")){
            System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your choice: ");
            response = scanner.next();
            response = response.toUpperCase();

            switch(response){
                case ("P") : clip.start(); break;
                case ("S") : clip.stop(); break;
                case ("R") : clip.setMicrosecondPosition(0); break;
                case ("Q") : clip.stop(); break;
                default: System.out.println("Not a valid response");
            }
        }


    }
}