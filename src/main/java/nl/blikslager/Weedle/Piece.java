package nl.blikslager.Weedle;

public interface Piece {
    void playPiece(Square square) throws SquareHasAlreadyBeenPlayedException;
}
