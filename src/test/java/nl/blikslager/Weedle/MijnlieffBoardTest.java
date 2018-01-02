package nl.blikslager.Weedle;

import org.junit.*;

public class MijnlieffBoardTest {
    MijnLieffBoard board;

    @Before
    public void setup(){
        board = MijnLieffBoard.getNewBoard();
    }

    @Test
    public void staticInitiation(){
        Assert.assertTrue(board != null);
    }

    @Test
    public void boardHasPlayer(){
        Assert.assertTrue(board.getCurrentPlayer() != null);
    }

    @Test
    public void square_1_1_isPlayable(){
        Assert.assertTrue(board.playable(1,1));
    }

    @Test
    public void square_2_1_isPlayable(){
        Assert.assertTrue(board.playable(2,1));
    }

    @Test
    public void square_3_1_isPlayable(){
        Assert.assertTrue(board.playable(3,1));
    }

    @Test
    public void square_4_1_isPlayable(){
        Assert.assertTrue(board.playable(4,1));
    }

    @Test
    public void square_1_2_isPlayable(){
        Assert.assertTrue(board.playable(1,2));
    }

    @Test
    public void square_2_2_isNotPlayable(){
        Assert.assertFalse(board.playable(2,2));
    }

    @Test
    public void square_3_2_isNotPlayable(){
        Assert.assertFalse(board.playable(3,2));
    }

    @Test
    public void square_4_2_isPlayable(){
        Assert.assertTrue(board.playable(4,2));
    }

    @Test
    public void square_1_3_isPlayable(){
        Assert.assertTrue(board.playable(1,3));
    }

    @Test
    public void square_2_3_isNotPlayable(){
        Assert.assertFalse(board.playable(2,3));
    }

    @Test
    public void square_3_3_isNotPlayable(){
        Assert.assertFalse(board.playable(3,3));
    }

    @Test
    public void square_4_3_isPlayable(){
        Assert.assertTrue(board.playable(4,3));
    }

    @Test
    public void square_1_4_isPlayable(){
        Assert.assertTrue(board.playable(1,4));
    }

    @Test
    public void square_2_4_isPlayable(){
        Assert.assertTrue(board.playable(2,4));
    }

    @Test
    public void square_3_4_isPlayable(){
        Assert.assertTrue(board.playable(3,4));
    }

    @Test
    public void square_4_4_isPlayable(){
        Assert.assertTrue(board.playable(4,4));
    }

    // new tests
    @Test
    public void boardReturnsSquare(){
        Assert.assertNotEquals(null, board.getSquare(1,1));
    }

    @Test
    public void boardReturnsActualBoardSquare(){
        Assert.assertEquals(board.getSquare(1,1),board.getSquare(1,1));
    }

    @Test
    public void boardCanReturnDifferentBoardSquares(){
        Assert.assertNotEquals(board.getSquare(1,1),board.getSquare(1,2));
    }

    @Test
    public void setAllSquareToPlayable(){
        board.setAllSquaresAsPlayable();
        boolean boardIsPlayable = true;
        OUTER: for(int row=1; row<5; row++){
            for(int col=1; col<5; col++){
                if(!board.playable(row,col)){
                    boardIsPlayable = false;
                    break OUTER;
                }
            }
        }
        Assert.assertTrue(boardIsPlayable);
    }

    @Test
    public void setAllSquareToNonPlayable(){
        board.setAllSquaresAsNonPlayable();
        boolean boardIsPlayable = false;
        OUTER: for(int row=1; row<5; row++){
            for(int col=1; col<5; col++){
                if(board.playable(row,col)){
                    boardIsPlayable = true;
                    break OUTER;
                }
            }
        }
        Assert.assertFalse(boardIsPlayable);
    }

    @Test
    public void boardCanGiveScore(){
        Assert.assertEquals(0, board.getScore()[0]+board.getScore()[1]);
    }

    @Test
    public void playerOneHasAPoint_1_Horizontal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(1,3);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerOneNoPoints_1(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,1);
        player.playPiece();
        Assert.assertEquals(0,board.getScore()[0]);
    }

    @Test
    public void playerOneNoPoints_2(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,1);
        player.playPiece();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,2);
        player.playPiece();
        Assert.assertEquals(0,board.getScore()[0]);
    }

    @Test
    public void playerOneHasAPoint_2_Horizontal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,3);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(1,4);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerOneHasAPoint_3_Horizontal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(4,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(4,3);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(4,4);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerTwoHasAPoint(){
        Player player = board.getCurrentPlayer().getOpponent();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(3,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(3,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(3,3);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[1]);
    }

    @Test
    public void playerOneHasAPoint_1_Vertical(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(1,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(2,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(3,1);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerOneHasAPoint_2_Vertical(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(2,4);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT);
        player.selectSquare(3,4);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(4,4);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerOneHasAPoint_1_Diagonal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(1,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(2,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(3,3);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerOneHasTwoPoints_1_Diagonal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(1,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(2,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(3,3);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(4,4);
        player.playPiece();
        Assert.assertEquals(2,board.getScore()[0]);
    }

    @Test
    public void playerOneHasAPoint_2_Diagonal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(4,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(3,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(2,3);
        player.playPiece();
        Assert.assertEquals(1,board.getScore()[0]);
    }

    @Test
    public void playerOneHasTwoPoints_2_Diagonal(){
        Player player = board.getCurrentPlayer();
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(4,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(3,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(2,3);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(1,4);
        player.playPiece();
        Assert.assertEquals(2,board.getScore()[0]);
    }

    @Test
    public void playerOneHasAnotherTurn(){
        Player player = board.getCurrentPlayer();
        Player player1 = player;
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(1,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(2,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(2,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(1,1);
        player.playPiece();
        Assert.assertEquals(player1,board.getCurrentPlayer());
    }

    @Test
    public void playerOneHasAnotherTurnAndSquaresCanBePlayed(){
        Player player = board.getCurrentPlayer();
        Player player1 = player;
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(1,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(2,1);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.DIAGONAL);
        player.selectSquare(2,2);
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.PULLER);
        player.selectSquare(1,1);
        player.playPiece();
        Assert.assertTrue(board.getSquare(4,4).playable());
    }
}
