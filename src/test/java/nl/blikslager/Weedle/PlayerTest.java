package nl.blikslager.Weedle;

import org.junit.*;
import java.util.*;

public class PlayerTest {
    Player player;
    MijnLieffBoard board;

    @Before
    public void setup(){
        board = MijnLieffBoard.getNewBoard();
        player = board.getCurrentPlayer();
    }

    @Test
    public void playerHas8Pieces(){
        Assert.assertEquals(8,player.getPieces().size());
    }

    @Test
    public void playerHasTwoStraights(){
        List list = player.getPieces();
        list.remove(Pieces.STRAIGHT);
        list.remove(Pieces.STRAIGHT);
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void playerHasTwoDiagonals(){
        List list = player.getPieces();
        list.remove(Pieces.DIAGONAL);
        list.remove(Pieces.DIAGONAL);
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void playerHasTwoPullers(){
        List list = player.getPieces();
        list.remove(Pieces.PULLER);
        list.remove(Pieces.PULLER);
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void playerHasTwoPushers(){
        List list = player.getPieces();
        list.remove(Pieces.PUSHER);
        list.remove(Pieces.PUSHER);
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void playerPlaysStraight(){
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        Assert.assertEquals(7,player.getPieces().size());
    }

    @Test
    public void returnListIsSeparatedFromActualList(){
        List list = player.getPieces();
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        Assert.assertNotEquals(list.size(), player.getPieces().size());
    }

    @Test
    public void changeTurnAfterPlay(){
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        Assert.assertNotEquals(board.getCurrentPlayer(), player);
    }

    @Test
    public void changeTurnBackAfterOpponentHasPlayed(){
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        board.getCurrentPlayer().selectPiece(Pieces.STRAIGHT);
        board.getCurrentPlayer().playPiece();
        Assert.assertEquals(player,board.getCurrentPlayer());
    }

    @Test
    public void noPieceIsPlayedWhenNoneIsSelected(){
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        player.playPiece();
        Assert.assertEquals(7,player.getPieces().size());
    }

    @Test
    public void turnDoesNotChangeWhenPieceIsNotInList(){
        //
        Player player1 = player;
        player.selectPiece(Pieces.STRAIGHT); //1
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT); //2
        player.playPiece();
        board.updateCurrentPlayer(player);
        player.selectPiece(Pieces.STRAIGHT); //1
        player.playPiece();
        Assert.assertEquals(player1, board.getCurrentPlayer());
    }

    @Test
    public void playStraightOnSelectedSquare(){
        player.selectSquare(1,1);
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        Assert.assertTrue(!board.playable(1,1) && board.playable(1,4) && board.playable(4,1));
    }

    @Test
    public void playDiagonalOnSelectedSquare(){
        player.selectSquare(1,1);
        player.selectPiece(Pieces.DIAGONAL);
        player.playPiece();
        Assert.assertTrue(!board.playable(1,1) && board.playable(4,4));
    }

    @Test
    public void playPullerOnSelectedSquare(){
        player.selectSquare(1,1);
        player.selectPiece(Pieces.PULLER);
        player.playPiece();
        Assert.assertTrue(!board.playable(1,1) && board.playable(1,2) && board.playable(2,2) &&
                board.playable(2,1));
    }

    @Test
    public void playPusherOnSelectedSquare(){
        player.selectSquare(1,1);
        player.selectPiece(Pieces.PUSHER);
        player.playPiece();
        Assert.assertTrue(!board.playable(1,1) && !board.playable(1,2) && !board.playable(2,2) &&
                !board.playable(2,1));
    }

    @Test
    public void afterInvalidPlayPlayerRemainsWithPieces(){
        player.selectSquare(2,2);
        player.selectPiece(Pieces.STRAIGHT);
        player.playPiece();
        Assert.assertEquals(8,player.getPieces().size());
    }
}
