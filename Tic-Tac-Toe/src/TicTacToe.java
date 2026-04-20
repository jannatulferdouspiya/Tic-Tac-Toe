import java.util.*;
public class TicTacToe {

    public static void main(String[] Args){

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[3][3];

        for(int row = 0; row< board.length;row++){
            for(int col = 0; col < board.length;col++){
                board[row][col] = ' ';
            }
        }

        //input the board;
        //matrix 3*3
        // Player
        //Rules
        //draw if both players do the same
        //player1 = X
        //Player2 = Y


        char player = 'X';

        boolean gameOver = false;

        while(!gameOver){
            printBoard(board);

            System.out.println("Player "+ player + " enter ");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){

                board[row][col] = player;

                gameOver = haveWon(board,player);

                if(gameOver== true){
                    System.out.println("Player "+ player + " has won");
                }
                else{
                    if(player == 'X'){
                        player = 'O';
                    }
                    else{
                        player = 'X';
                    }
                }

            }
            else{
                System.out.println("Invalid move. Try Again");
            }

        }

        printBoard(board);

    }

    public static void printBoard(char[][] board){

        for(int row = 0; row< board.length;row++){
            for(int col = 0; col < board.length;col++){
                System.out.print(board [row][col] + " ");

                if(col < 2){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(row < 2){
                System.out.println(" --------- ");
            }
        }

    }

    public static boolean haveWon(char[][] board,char player){

        //check rows

        for(int row = 0; row< board.length;row++){

            if( board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        for(int col = 0; col< board.length;col++){

            if( board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //diagonal

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
return false;
    }


}
