package in.pvishnu.machinecoding.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class Player {
    private final String name;
    private Cell currentCell;

    public Player(String name, Cell firstCell) {
        this.name = name;
        this.currentCell = firstCell;
    }
}
