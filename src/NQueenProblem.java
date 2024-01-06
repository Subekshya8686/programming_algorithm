import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    boolean isSafe(char [][] board, int r, int c){
        //checking vertically
        int i;
        for(i=0;i<board.length;i++){
            if(board[i][c]=='Q'){
                return  false;
            }
        }
        //checking horizontally
        for(i=0;i<board.length;i++){
            if(board[r][i]=='Q'){
                return  false;
            }
        }

        //checking upward left
        i=r;
        for(int j=c;i>0 && j>0;i--,j--){
            if(board[i][j]=='Q'){
                return  false;
            }
        }

        //checking downward right
        i=r;
        for(int j=c;i<board.length && j<board.length;i++,j++){
            if(board[i][j]=='Q'){
                return  false;
            }
        }

        //checking upwardright
        i=r;
        for(int j=c;i>0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return  false;
            }
        }

        //checking downward left

        i=r;
        for(int j=c;i<board.length&&j>0;i++,j--){
            if(board[i][j]=='Q'){
                return  false;
            }
        }

        return  true;
    }

    void saveBoard(char board[][],List<List<Character>> allboard){
        //saveboard to the list
    }

    void helper(char [][] board,int c,List<List<Character>> allboard){
        if(c== board.length){
            saveBoard(board,allboard);
            //save each row of column to allboard list
            //saveBoard(board,allboard);
            //implement by yourself remaning soln of saving board
            return;

        }
        for(int r=0;r<board.length;r++){
            if(isSafe(board,r,c)){
                board[r][c]='Q';
                helper(board,c+1,allboard);
                board[r][c]='.';
            }
        }
    }

    public static void main(String[] args) {
        NQueenProblem q=new NQueenProblem();
        List<List<Character>> allBoard=new ArrayList<>();
        q.helper(new char[4][4],0,allBoard);

    }
}
