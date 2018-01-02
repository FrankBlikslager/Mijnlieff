package nl.blikslager.Weedle;

public class MijnLieffBoard {
    private Player currentPlayer;
    private Player[] players = new Player[2];
    private Square[][] squares = new Square[4][4];

    private MijnLieffBoard(){
        currentPlayer = new Player(this);
        players[0] = currentPlayer;
        players[1] = currentPlayer.getOpponent();

        for (int iRow = 0; iRow<squares.length; iRow++){
            for (int iCol = 0; iCol<squares[0].length; iCol++){
                if ((iRow == 1 || iRow == 2) && (iCol == 1 || iCol == 2)){
                    squares[iRow][iCol] = new Square(false);
                }
                else {
                    squares[iRow][iCol] = new Square(true);
                }
            }
        }
        setRightNeighbours();
        setLeftNeighbours();
        setUpNeighbours();
        setDownNeighbours();
        setRightDownNeighbours();
        setLeftUpNeighbours();
        setRightUpNeighbours();
        setLeftDownNeighbours();
    }

    public static MijnLieffBoard getNewBoard() {
        return new MijnLieffBoard();
    }

    private void setRightNeighbours() {
        for (int iRow = 0; iRow<squares.length; iRow++){
            for (int iCol = 0; iCol<squares[0].length-1; iCol++){
                squares[iRow][iCol].setRightNeighbour(squares[iRow][iCol+1]);
            }
        }
    }

    private void setLeftNeighbours() {
        for (int iRow = 0; iRow<squares.length; iRow++){
            for (int iCol = 1; iCol<squares[0].length; iCol++){
                squares[iRow][iCol].setLeftNeighbour(squares[iRow][iCol-1]);
            }
        }
    }

    private void setUpNeighbours() {
        for (int iRow = 1; iRow<squares.length; iRow++){
            for (int iCol = 0; iCol<squares[0].length; iCol++){
                squares[iRow][iCol].setUpNeighbour(squares[iRow-1][iCol]);
            }
        }
    }

    private void setDownNeighbours() {
        for (int iRow = 0; iRow<squares.length-1; iRow++){
            for (int iCol = 0; iCol<squares[0].length; iCol++){
                squares[iRow][iCol].setDownNeighbour(squares[iRow+1][iCol]);
            }
        }
    }

    private void setRightDownNeighbours() {
        for (int iRow = 0; iRow<squares.length-1; iRow++){
            for (int iCol = 0; iCol<squares[0].length-1; iCol++){
                squares[iRow][iCol].setRightDownNeighbour(squares[iRow+1][iCol+1]);
            }
        }
    }

    private void setLeftUpNeighbours() {
        for (int iRow = 1; iRow<squares.length; iRow++){
            for (int iCol = 1; iCol<squares[0].length; iCol++){
                squares[iRow][iCol].setLeftUpNeighbour(squares[iRow-1][iCol-1]);
            }
        }
    }

    private void setRightUpNeighbours() {
        for (int iRow = squares.length-1; iRow>0; iRow--){
            for (int iCol = 0; iCol<squares[0].length-1; iCol++){
                squares[iRow][iCol].setRightUpNeighbour(squares[iRow-1][iCol+1]);
            }
        }
    }

    private void setLeftDownNeighbours() {
        for (int iRow = 0; iRow<squares.length-1; iRow++){
            for (int iCol = squares[0].length-1; iCol>0; iCol--){
                squares[iRow][iCol].setLeftDownNeighbour(squares[iRow+1][iCol-1]);
            }
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void updateCurrentPlayer(Player player) {
        if(boardHasPlayableOption())
        currentPlayer = player;
        else
        setAllSquaresAsPlayable();
    }

    private boolean boardHasPlayableOption() {
        for (int iRow = 0; iRow<squares.length; iRow++){
            for (int iCol = 0; iCol<squares[0].length; iCol++){
                if(squares[iRow][iCol].playable())
                    return true;
            }
        }
        return false;
    }

    public boolean playable(int row, int col) {
        return squares[row-1][col-1].playable();
    }

    public Square getSquare(int row, int col) {
        return squares[row-1][col-1];
    }

    public void setAllSquaresAsPlayable() {
        for(int row = 0; row<4; row++){
            for(int col = 0; col<4; col++){
                squares[row][col].setToTrue();
            }
        }
    }

    public void setAllSquaresAsNonPlayable() {
        for(int row = 0; row<4; row++){
            for(int col = 0; col<4; col++){
                squares[row][col].setToFalse();
            }
        }
    }

    public int[] getScore() {
        int score[] = {0,0};
        int iPlayer = -1;
        int[][] checkScorePattern = {{0,1}, {1,0}, {1,1}, {-1,1}};
        for(Player player : players) {
            iPlayer += 1;
            for (int[] patern : checkScorePattern)
                for (int iRow = 0; iRow < 4; iRow++)
                    for (int iCol = 0; iCol < 4; iCol++)
                        if (checkSquareCombo(player, iRow, iCol, 0, patern))
                            score[iPlayer] += 1;
        }
        return score;
    }

    private boolean checkSquareCombo(Player player, int row, int col, int squareCounter, int checkSquirePatern[]){
        if(row < 0 || row > 3 || col < 0 || col > 3){
            return false;
        }
        else if(squares[row][col].getPlayer() == null){
            return false;
        }
        else if(squares[row][col].getPlayer().equals(player)){
            squareCounter++;
            if(squareCounter<3)
                return checkSquareCombo(player, row + checkSquirePatern[0], col + checkSquirePatern[1], squareCounter, checkSquirePatern);
            else
            return true;
        }
        else{
            return false;
        }
    }
}
