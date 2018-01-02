package nl.blikslager.Weedle;

import org.junit.*;

public class SquareTest {
    Square square;
    Player player;

    @Before
    public void setUp() {
         player = MijnLieffBoard.getNewBoard().getCurrentPlayer();
        square = new Square(true);
    }

    @Test
    public void squareCanBeSetToFalse(){
        square.setToFalse();
        Assert.assertFalse(square.playable());
    }

    @Test
    public void squareCanBeSetToTrue(){
        square.setToFalse();
        square.setToTrue();
        Assert.assertTrue(square.playable());
    }

    @Test
    public void squareCannotBeSetToTrueWhenHasPiece() throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(player);
        square.setToFalse();
        square.setToTrue();
        Assert.assertFalse(square.playable());
    }

    @Test(expected = SquareHasAlreadyBeenPlayedException.class)
    public void squareCannotBePlayedWhenHasPiece() throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(player);
        square.setToFalse();
        square.setPiece(player);
    }

    @Test
    public void playedSquareBelongsToSquare() throws SquareHasAlreadyBeenPlayedException{
        square.setPiece(player);
        Assert.assertEquals(player,square.getPlayer());

    }
}
