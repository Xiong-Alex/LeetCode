class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // 9 sets of each to track rows, cols, boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // initialize each st
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++) {

            for(int c = 0; c < 9; c++) {

                // our current val
                char val = board[r][c];

                // skip empty slot
                if(val == '.') continue;

                // determine which box/quadrant we're in
                int boxIndex = (r/3) * 3 + (c/3);

                // check duplicates
                if (rows[r].contains(val) ||
                    cols[c].contains(val) ||
                    boxes[boxIndex].contains(val)) {
                    return false;
                }

                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}


// Notes
// Utilize Set to track duplicates for Row, Col, Box
// use 3 diff arrays to hold 9 diff sets for each.

// loop through and add val to corresponding sets
// calc box index to determin where to add val in box set