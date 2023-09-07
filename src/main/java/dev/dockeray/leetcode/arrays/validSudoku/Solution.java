package dev.dockeray.leetcode.arrays.validSudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[] bucket;
        boolean valid = true;
        for(int ybox = 0; ybox < 9 && valid; ybox += 3){
            for(int xbox = 0; xbox < 9 && valid; xbox+=3) {
                bucket = new boolean[9];
                for (int x = 0; x < 3 && valid; x++) {
                    for(int y = 0; y < 3 && valid; y++ ){
                        int yb = y+ybox;
                        int xb = x+xbox;
                        char current = board[yb][xb];
                        if(Character.isDigit(current)) {
                            int idx = Character.digit(current-1, 10);
                            if(row[yb][idx] || col[xb][idx] || bucket[idx]){
                                valid = false;
                            } else {
                                row[yb][idx] = true;
                                col[xb][idx] = true;
                                bucket[idx] = true;
                            }
                        }

                    }
                }
            }
        }
        return  valid;
    }
}
