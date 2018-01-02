package nl.blikslager.Weedle;

import org.junit.*;

public class StraightTest {
    MijnLieffBoard board;

    @Before
    public void setUp() {
        board = MijnLieffBoard.getNewBoard();
    }

    @Test
    public void playStraight_1() throws SquareHasAlreadyBeenPlayedException{
        Straight s = new Straight(board);
        s.playPiece(board.getSquare(1,1));
        Assert.assertFalse(board.playable(1,1));
    }

    @Test
    public void playStraight_2() throws SquareHasAlreadyBeenPlayedException{
        Straight s = new Straight(board);
        s.playPiece(board.getSquare(1,1));
        Assert.assertFalse(board.playable(4,4));
    }

    @Test
    public void playStraight_3() throws SquareHasAlreadyBeenPlayedException{
        Straight s = new Straight(board);
        s.playPiece(board.getSquare(1,1));
        Assert.assertTrue(board.playable(1,4) && board.playable(4,1));
    }

    @Test
    public void playStraight_4() throws SquareHasAlreadyBeenPlayedException{
        Straight s = new Straight(board);
        s.playPiece(board.getSquare(4,4));
        Assert.assertTrue(board.playable(1,4) && board.playable(4,1));
    }
}
