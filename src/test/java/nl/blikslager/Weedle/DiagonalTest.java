package nl.blikslager.Weedle;

import org.junit.*;

public class DiagonalTest {
    MijnLieffBoard board;

    @Before
    public void setUp() {
        board = MijnLieffBoard.getNewBoard();
    }

    @Test
    public void playDiagonal_1() throws SquareHasAlreadyBeenPlayedException{
        Diagonal d = new Diagonal(board);
        d.playPiece(board.getSquare(1,1));
        Assert.assertFalse(board.playable(1,1));
    }

    @Test
    public void playDiagonal_2() throws SquareHasAlreadyBeenPlayedException{
        Diagonal d = new Diagonal(board);
        d.playPiece(board.getSquare(1,1));
        Assert.assertTrue(board.playable(2,2) && board.playable(4,4));
    }

    @Test
    public void playDiagonal_3() throws SquareHasAlreadyBeenPlayedException{
        Diagonal d = new Diagonal(board);
        d.playPiece(board.getSquare(4,4));
        Assert.assertTrue(board.playable(3,3) && board.playable(1,1));
    }

    @Test
    public void playDiagonal_4() throws SquareHasAlreadyBeenPlayedException{
        Diagonal d = new Diagonal(board);
        d.playPiece(board.getSquare(4,1));
        Assert.assertTrue(board.playable(3,2) && board.playable(1,4));
    }

    @Test
    public void playDiagonal_5() throws SquareHasAlreadyBeenPlayedException{
        Diagonal d = new Diagonal(board);
        d.playPiece(board.getSquare(1,4));
        Assert.assertTrue(board.playable(2,3) && board.playable(4,1));
    }
}
