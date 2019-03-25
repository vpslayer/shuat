/** Let's consider cases:
Case 1: a particular x, y is visited and it was not a matching letter during the last visit. This case we indeed want to revisit that node as it was not 'consumed' for the solution.
Case 2: th e previously visited x,y was a match. Then applying the bit mask of 256 (i.e. XOR with 0b100000000)
would change that to a not match for any ASCII letter we consider. Hence it will always be false until we apply the XOR again to bring back the original letter (which by then we are done exploring the neighbors anyway).
*/

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }
    
    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
            || exist(board, y, x-1, word, i+1)
            || exist(board, y+1, x, word, i+1)
            || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word = "ABCCED";
        if(exist(board, word))  System.out.println(word+" exists in board");
        else System.out.println(word+" doesn't exists in board");
    }
}