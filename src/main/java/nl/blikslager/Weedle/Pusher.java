package nl.blikslager.Weedle;

public class Pusher implements Piece {
    MijnLieffBoard board;

    public Pusher(MijnLieffBoard board){
        this.board = board;
    }

    @Override
    public void playPiece(Square square) throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(board.getCurrentPlayer());
        board.setAllSquaresAsPlayable();
        square.setToFalse();
        square.setDirectNeighboursUnplayable();

    }
}
