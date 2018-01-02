package nl.blikslager.Weedle;

import java.util.Scanner;

public class gui {
    private static String[][] boardState = {{" "," "," "," "},{" "," "," "," "},{" "," "," "," "},{" "," "," "," "}};
    private static Player p1;
    private static Player player;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args){
        MijnLieffBoard board = MijnLieffBoard.getNewBoard();
        player = board.getCurrentPlayer();
        p1 = player;

        printBoard(board);

        while(true) {
            player = board.getCurrentPlayer();
            if(player==p1){
                System.out.println("Turn player 1:");
            }
            else{
                System.out.println("Turn player 2:");
            }
            player.selectPiece(returnPiece(player));
            player.selectSquare(returnSquare("row"),returnSquare("column"));
            player.playPiece();

            printScore(board);
            printBoard(board);
        }
    }

    private static Pieces returnPiece(Player player) {
        String playablePieces = "";
        if(player.getPieces().contains(Pieces.STRAIGHT)){
            playablePieces = playablePieces + "s,";
        }
        if(player.getPieces().contains(Pieces.DIAGONAL)){
            playablePieces = playablePieces + "d,";
        }
        if(player.getPieces().contains(Pieces.PULLER)){
            playablePieces = playablePieces + "pl,";
        }
        if(player.getPieces().contains(Pieces.PUSHER)){
            playablePieces = playablePieces + "ps";
        }

        System.out.print("What piece do you want to play? [" + playablePieces + "] >> ");
        switch(s.nextLine()){
            case "s": return Pieces.STRAIGHT;
            case "d": return Pieces.DIAGONAL;
            case "pl": return Pieces.PULLER;
            case "ps": return Pieces.PUSHER;
            default: return returnPiece(player);
        }
    }

    private static int returnSquare(String loc) {
        System.out.print("In which " + loc + " do you want to play your piece? >> [1-4] ");
        int location = Integer.parseInt(s.nextLine());
        return location>0&&location<5?location:returnSquare(loc);
    }

    private static void printBoard(MijnLieffBoard board) {
        for (int row = 0; row<4; row++){
            for (int col = 0; col<4; col++){
                switch (boardState[row][col]) {
                    case " ":
                    case "N":
                        if(board.playable(row + 1, col + 1)){
                            boardState[row][col] = " ";
                        }
                        else{
                            if(board.getSquare(row + 1, col + 1).getPlayer()==null)
                                boardState[row][col] = "N";
                            else if(player==p1)
                                boardState[row][col] = "1";
                            else
                                boardState[row][col] = "2";
                        }
                        break;
                    default:
                }
            }
        }
        System.out.println("");
        System.out.println("["+ boardState[0][0] + "][" + boardState[0][1] + "][" +  boardState[0][2] + "][" +  boardState[0][3] + "]");
        System.out.println("["+ boardState[1][0] + "][" + boardState[1][1] + "][" +  boardState[1][2] + "][" +  boardState[1][3] + "]");
        System.out.println("["+ boardState[2][0] + "][" + boardState[2][1] + "][" +  boardState[2][2] + "][" +  boardState[2][3] + "]");
        System.out.println("["+ boardState[3][0] + "][" + boardState[3][1] + "][" +  boardState[3][2] + "][" +  boardState[3][3] + "]");
        System.out.println("");
    }

    private static void printScore(MijnLieffBoard board) {
        int[] score = board.getScore();
        System.out.println("");
        System.out.println("Score: " + score[0] + " - " + score[1]);
    }
}