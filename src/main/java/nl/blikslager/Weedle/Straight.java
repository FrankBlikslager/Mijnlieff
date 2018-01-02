package nl.blikslager.Weedle;

public class Straight implements Piece {
    MijnLieffBoard board;

    public Straight(MijnLieffBoard board){
        this.board = board;
    }

    @Override
    public void playPiece(Square square) throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(board.getCurrentPlayer());
        board.setAllSquaresAsNonPlayable();
        square.cascadeTrueToRight();
        square.cascadeTrueToLeft();
        square.cascadeTrueToUp();
        square.cascadeTrueToDown();


    }
}
