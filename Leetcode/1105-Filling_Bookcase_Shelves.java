class Solution {
    static int totalBooks;
    static int newShelfWidth;

    public static int solve(int bookIdx, int books[][], int currShelfWidth, int currShelfHeight, int dp[][]) {
        // check max height for curr shelf coz book height can be greater than
        // currSHelfHeight
        int maxHeight = Math.max(currShelfHeight, books[bookIdx][1]);

        // base case
        if (bookIdx == totalBooks - 1) {
            // if this is the last book then,

            // check whether it accomodates in the same shelf or not, if it does then return
            // max height only coz currBookHeight can be more than currShelfHeight
            if (books[bookIdx][0] <= currShelfWidth)
                return maxHeight;
            // if not then do current height + book height and return it as it is placed in
            // new shelf and it will be the only book in that new shelf
            return currShelfHeight + books[bookIdx][1];
        }

        int sameShelf = Integer.MAX_VALUE;
        // make two choices either in same or new shelf
        if (books[bookIdx][0] <= currShelfWidth) {
            // to keep in same shelf we need constraint check that is there width available
            // or not
            // if available do currW-bookW and go to next bk
            sameShelf = solve(bookIdx + 1, books, currShelfWidth - books[bookIdx][0], maxHeight, dp);
        }

        if(dp[bookIdx][currShelfWidth]!=0){
            // if already solved for this book idx at currShelfwidth
            return dp[bookIdx][currShelfWidth];
        }
        // keep in new shelf it does not any constraint coz this will be the first book
        // to be kept in that shelf
        // as we are keeping the book in next shelf do currHeight + recurisve call for
        // next book
        int newShelf = currShelfHeight
                + solve(bookIdx + 1, books, newShelfWidth - books[bookIdx][0], books[bookIdx][1], dp);

        // return the min possible ans after making both choices
        return dp[bookIdx][currShelfWidth] = Math.min(newShelf, sameShelf);

    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalBooks = books.length;
        newShelfWidth = shelfWidth;
        int dp[][] = new int[totalBooks][newShelfWidth + 1];
        return solve(0, books, shelfWidth, 0, dp);
    }
}