package nl.blikslager.Weedle;

public class Diagonal implements Piece{
    MijnLieffBoard board;

    public Diagonal(MijnLieffBoard board){
        this.board = board;

    }
    @Override
    public void playPiece(Square square) throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(board.getCurrentPlayer());
        board.setAllSquaresAsNonPlayable();
        square.cascadeTrueToRightDown();
        square.cascadeTrueToLeftUp();
        square.cascadeTrueToRightUp();
        square.cascadeTrueToLeftDown();
    }
}
