package nl.blikslager.Weedle;

import org.junit.*;

public class PusherTest {
    MijnLieffBoard board;
    Pusher p;

    @Before
    public void setUp() {
        board = MijnLieffBoard.getNewBoard();
        p = new Pusher(board);
    }

    @Test
    public void playPusher_1() throws SquareHasAlreadyBeenPlayedException{
        p.playPiece(board.getSquare(1,1));
        Assert.assertFalse(board.playable(1,1));
    }

    @Test
    public void playPusher_2() throws SquareHasAlreadyBeenPlayedException{
        p.playPiece(board.getSquare(1,2));
        Assert.assertTrue(board.playable(1,4) && board.playable(3,3) && board.playable(3,1));
    }

    @Test
    public void playPusher_3() throws SquareHasAlreadyBeenPlayedException{
        p.playPiece(board.getSquare(4,2));
        Assert.assertTrue(board.playable(2,3) && board.playable(4,4) && board.playable(2,1));
    }

    @Test
    public void playPusher_4() throws SquareHasAlreadyBeenPlayedException{
        p.playPiece(board.getSquare(1,2));
        Assert.assertTrue(!board.playable(1,1) && !board.playable(2,1) && !board.playable(2,2) &&
                !board.playable(2,3) && !board.playable(1,3));
    }

    @Test
    public void playPusher_5() throws SquareHasAlreadyBeenPlayedException{
        p.playPiece(board.getSquare(4,2));
        Assert.assertTrue(!board.playable(3,1) && !board.playable(3,2) && !board.playable(3,3));
    }
}
