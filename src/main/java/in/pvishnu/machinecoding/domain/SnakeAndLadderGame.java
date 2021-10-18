package in.pvishnu.machinecoding.domain;

import javafx.util.Pair;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class SnakeAndLadderGame {

    SnakeAndLadderBoard board;
    List<Player> players = new ArrayList<>();
    List<Die> dies = new ArrayList<>();

    int nextPlayer = 0;

    public void initializeBoard(int boardSize) {
        board = new SnakeAndLadderBoard(boardSize);
        board.initializeCells();
    }

    public void addSnakes(List<Pair<Integer, Integer>> snakes) {
        for (Pair<Integer, Integer> snake : snakes) {
            board.addSnake(snake.getKey(), snake.getValue());
        }
    }

    public void addLadders(List<Pair<Integer, Integer>> ladders) {
        for (Pair<Integer, Integer> ladder : ladders) {
            board.addSnake(ladder.getKey(), ladder.getValue());
        }
    }

    public void addPlayer(String name) {
        Player player = new Player(name, board.getFirstCell());
        this.players.add(player);
    }

    public void addDie(int faces) {
        Die die = new Die(faces);
        this.dies.add(die);
    }

    private int rollDies() {
        return this.dies.stream().map(Die::rollDie).mapToInt(i -> i).sum();
    }


    public Player play() {
        while (true) {
            Player nextPlayer = players.get(this.nextPlayer);
            int numberOfMoves = rollDies();
            Cell currentCell = nextPlayer.getCurrentCell();
            Cell nextCell = board.getNextCell(currentCell, numberOfMoves);
            nextPlayer.setCurrentCell(nextCell);
            System.out.println("Moving " + nextPlayer.getName() + " from Cell " + currentCell.getCellNumber() + " to " + nextCell.getCellNumber());
            if (board.isFinalCell(nextCell)) {
                System.out.println("Player " + nextPlayer.getName() + " wins!!");
                return nextPlayer;
            }
            this.nextPlayer = (this.nextPlayer + 1) % players.size();
        }
    }

}
