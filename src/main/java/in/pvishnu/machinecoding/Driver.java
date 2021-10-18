package in.pvishnu.machinecoding;

import in.pvishnu.machinecoding.domain.SnakeAndLadderGame;
import javafx.util.Pair;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.initializeBoard(100);
        game.addSnakes(Arrays.asList(new Pair<>(20, 10)));
        game.addLadders(Arrays.asList(new Pair<>(9, 50)));
        game.addDie(6);
        game.addPlayer("Vishnu");
        game.addPlayer("Sruthi");
        game.play();
    }
}
