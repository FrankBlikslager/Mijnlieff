package nl.blikslager.Weedle;

import org.junit.*;

public class PullerTest {
    MijnLieffBoard board;

    @Before
    public void setUp() {
        board = MijnLieffBoard.getNewBoard();
    }

    @Test
    public void playPuller_1() throws SquareHasAlreadyBeenPlayedException{
        Puller p = new Puller(board);
        p.playPiece(board.getSquare(1,1));
        Assert.assertFalse(board.playable(1,1));
    }

    @Test
    public void playPuller_2() throws SquareHasAlreadyBeenPlayedException{
        Puller p = new Puller(board);
        p.playPiece(board.getSquare(1,1));
        Assert.assertFalse(board.playable(3,3) && board.playable(1,3) && board.playable(3,1));
    }

    @Test
    public void playPuller_3() throws SquareHasAlreadyBeenPlayedException{
        Puller p = new Puller(board);
        p.playPiece(board.getSquare(1,1));
        Assert.assertTrue(board.playable(1,2) && board.playable(2,2) && board.playable(2,1));
    }

    @Test
    public void playPuller_4() throws SquareHasAlreadyBeenPlayedException{
        Puller p = new Puller(board);
        p.playPiece(board.getSquare(4,4));
        Assert.assertTrue(board.playable(3,4) && board.playable(3,3) && board.playable(4,3));
    }

    @Test
    public void playPuller_5() throws SquareHasAlreadyBeenPlayedException{
        Puller p = new Puller(board);
        p.playPiece(board.getSquare(1,2));
        Assert.assertTrue(board.playable(2,1) && board.playable(2,3));
    }

    @Test
    public void playPuller_6() throws SquareHasAlreadyBeenPlayedException{
        Puller p = new Puller(board);
        p.playPiece(board.getSquare(4,2));
        Assert.assertTrue(board.playable(3,1) && board.playable(3,3));
    }
}
