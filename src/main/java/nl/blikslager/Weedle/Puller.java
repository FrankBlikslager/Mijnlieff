package nl.blikslager.Weedle;

public class Puller implements Piece {
    MijnLieffBoard board;

    public Puller(MijnLieffBoard board){
        this.board = board;
    }

    @Override
    public void playPiece(Square square) throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(board.getCurrentPlayer());
        board.setAllSquaresAsNonPlayable();
        square.setDirectNeighboursPlayable();
    }
}
