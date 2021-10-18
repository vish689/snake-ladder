package in.pvishnu.machinecoding.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {
    private int cellNumber;
    private Cell snakeTail;
    private Cell ladderTop;
}
