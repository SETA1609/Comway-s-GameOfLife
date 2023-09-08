import controller.Game;
import controller.GameInterface;

public class Main {
    public static void main(String[] args) {
        GameInterface gameInterface= new Game();
        // TODO give the number of frames to the starten method for the number of generations
        gameInterface.run();
    }
}