package nl.blikslager.Weedle;

public class Square {
    private boolean playable;
    private boolean hasPiece = false;
    private Player player;

    private Square rightNeighbour;
    private Square downNeighbour;
    private Square upNeighbour;
    private Square leftNeighbour;
    private Square rightDownNeighbour;
    private Square leftUpNeighbour;
    private Square rightUpNeighbour;
    private Square leftDownNeighbour;

    public Square(boolean playable){
        this.playable = playable;
    }

    public void setRightNeighbour(Square rightNeighbour) {
        this.rightNeighbour = rightNeighbour;
    }

    public void setLeftNeighbour(Square leftNeighbour) {
        this.leftNeighbour = leftNeighbour;
    }

    public void setUpNeighbour(Square upNeighbour) {
        this.upNeighbour = upNeighbour;
    }

    public void setDownNeighbour(Square downNeighbour) {
        this.downNeighbour = downNeighbour;
    }

    public void setRightDownNeighbour(Square rightDownNeighbour){
        this.rightDownNeighbour = rightDownNeighbour;
    }

    public void setLeftUpNeighbour(Square leftUpNeighbour){
        this.leftUpNeighbour = leftUpNeighbour;
    }

    public void setRightUpNeighbour(Square rightUpNeighbour){
        this.rightUpNeighbour = rightUpNeighbour;
    }

    public void setLeftDownNeighbour(Square leftDownNeighbour){
        this.leftDownNeighbour = leftDownNeighbour;
    }

    public boolean playable() {
        return playable;
    }

    public void setToFalse() {
        playable = false;
    }

    public void setToTrue() {
        if(!hasPiece) {
            playable = true;
        }
    }

    public void setPiece(Player player) throws SquareHasAlreadyBeenPlayedException{
        if(!playable)
            throw new SquareHasAlreadyBeenPlayedException();
        this.player = player;
        hasPiece = true;
    }

    public void cascadeTrueToRight() {
        if (rightNeighbour != null) {
            rightNeighbour.setToTrue();
            rightNeighbour.cascadeTrueToRight();
        }
    }

    public void cascadeTrueToDown() {
        if (downNeighbour != null) {
            downNeighbour.setToTrue();
            downNeighbour.cascadeTrueToDown();
        }
    }

    public void cascadeTrueToLeft() {
        if (leftNeighbour != null) {
            leftNeighbour.setToTrue();
            leftNeighbour.cascadeTrueToLeft();
        }
    }

    public void cascadeTrueToUp() {
        if (upNeighbour != null) {
            upNeighbour.setToTrue();
            upNeighbour.cascadeTrueToUp();
        }
    }

    public void cascadeTrueToRightDown() {
        if(rightDownNeighbour != null) {
            rightDownNeighbour.setToTrue();
            rightDownNeighbour.cascadeTrueToRightDown();
        }
    }

    public void cascadeTrueToLeftUp() {
        if(leftUpNeighbour != null){
            leftUpNeighbour.setToTrue();
            leftUpNeighbour.cascadeTrueToLeftUp();
        }
    }

    public void cascadeTrueToRightUp() {
        if(rightUpNeighbour != null){
            rightUpNeighbour.setToTrue();
            rightUpNeighbour.cascadeTrueToRightUp();
        }
    }

    public void cascadeTrueToLeftDown() {
        if(leftDownNeighbour != null){
            leftDownNeighbour.setToTrue();
            leftDownNeighbour.cascadeTrueToLeftDown();
        }
    }

    public void setDirectNeighboursPlayable() {
        if(upNeighbour!=null) upNeighbour.setToTrue();
        if(rightUpNeighbour!=null) rightUpNeighbour.setToTrue();
        if(rightNeighbour!=null) rightNeighbour.setToTrue();
        if(rightDownNeighbour!=null) rightDownNeighbour.setToTrue();
        if(downNeighbour!=null) downNeighbour.setToTrue();
        if(leftDownNeighbour!=null) leftDownNeighbour.setToTrue();
        if(leftNeighbour!=null) leftNeighbour.setToTrue();
        if(leftUpNeighbour!=null) leftUpNeighbour.setToTrue();
    }

    public void setDirectNeighboursUnplayable() {
        if(upNeighbour!=null) upNeighbour.setToFalse();
        if(rightUpNeighbour!=null) rightUpNeighbour.setToFalse();
        if(rightNeighbour!=null) rightNeighbour.setToFalse();
        if(rightDownNeighbour!=null) rightDownNeighbour.setToFalse();
        if(downNeighbour!=null) downNeighbour.setToFalse();
        if(leftDownNeighbour!=null) leftDownNeighbour.setToFalse();
        if(leftNeighbour!=null) leftNeighbour.setToFalse();
        if(leftUpNeighbour!=null) leftUpNeighbour.setToFalse();
    }

    public Player getPlayer() {
        return player;
    }
}

