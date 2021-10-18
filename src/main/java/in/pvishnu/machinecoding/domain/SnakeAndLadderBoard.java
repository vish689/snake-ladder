package in.pvishnu.machinecoding.domain;

public class SnakeAndLadderBoard {

    Cell[] cells;

    public SnakeAndLadderBoard(int size) {
        cells = new Cell[size + 1];
    }

    public void initializeCells() {
        for (int i = 1; i < cells.length; ++i) {
            cells[i] = new Cell();
            cells[i].setCellNumber(i);
        }
    }

    public void addSnake(int startCell, int endCell) {
        cells[startCell].setSnakeTail(cells[endCell]);
    }

    public void addLadder(int startCell, int endCell) {
        cells[startCell].setLadderTop(cells[endCell]);
    }

    public boolean isFinalCell(Cell cell) {
        return cell.getCellNumber() == cells.length - 1;
    }

    public Cell getNextCell(Cell currentCell, int offset) {
        int nextCellIdx = Math.min(currentCell.getCellNumber() + offset, cells.length - 1);
        Cell nextCell = cells[nextCellIdx];
        return climbLadderOrGothroughSnake(nextCell);
    }

    public Cell getFirstCell() {
        return this.cells[1];
    }

    private Cell climbLadderOrGothroughSnake(Cell currentCell) {
        if (currentCell.getLadderTop() != null) {
            return currentCell.getLadderTop();
        } else if (currentCell.getSnakeTail() != null) {
            return currentCell.getSnakeTail();
        }
        return currentCell;
    }
}
