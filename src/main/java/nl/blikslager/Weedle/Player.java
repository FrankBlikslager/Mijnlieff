package nl.blikslager.Weedle;

import java.util.*;

public class Player {
    private List<Pieces> pieces = new ArrayList<>();
    private Pieces selectedPiece;
    private Player opponent;
    private Square selectedSquare;
    private MijnLieffBoard board;

    public Player(MijnLieffBoard board){
        this.board = board;
        getStartingPieces();
        opponent = new Player(board,this);
    }

    private Player(MijnLieffBoard board, Player opponent) {
        this.board = board;
        this.opponent = opponent;
        getStartingPieces();
    }

    private void getStartingPieces() {
        for(int i = 0; i<2; i++) {
            pieces.add(Pieces.STRAIGHT);
            pieces.add(Pieces.DIAGONAL);
            pieces.add(Pieces.PULLER);
            pieces.add(Pieces.PUSHER);
        }
    }

    public Player getOpponent() {
        return opponent;
    }

    public List<Pieces> getPieces() {
        return new ArrayList(pieces);
    }

    public void selectPiece(Pieces selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public void selectSquare(int row, int col) {
        selectedSquare = board.getSquare(row,col);
    }

    public void playPiece() {
        try{
            if(pieces.remove(selectedPiece)) {
                if(selectedSquare!=null)
                    playSelectedPiece();
                selectedPiece = null;
                board.updateCurrentPlayer(opponent);
            }
        }
        catch (SquareHasAlreadyBeenPlayedException e){
            pieces.add(selectedPiece);
        }
    }

    private void playSelectedPiece() throws SquareHasAlreadyBeenPlayedException {
        switch (selectedPiece) {
            case STRAIGHT:
                new Straight(board).playPiece(selectedSquare);
                break;
            case DIAGONAL:
                new Diagonal(board).playPiece(selectedSquare);
                break;
            case PULLER:
                new Puller(board).playPiece(selectedSquare);
                break;
            case PUSHER:
                new Pusher(board).playPiece(selectedSquare);
                break;
        }
    }
}