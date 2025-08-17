class Solution {
    public List<List<Integer>> generate(int numRows) {
        /**
        Time Complexity = O(numRows^2)
        Space Complexity = O(numRows^2)

        On all levels if cell is boundary cell then fill 1, else 
        fill sum of (level-1,i-1) and (level-1,i)
         */
        List<List<Integer>> triangle = new ArrayList<>();
    
        for(int level=0;level<numRows;level++){
            List<Integer> current = new ArrayList<>();
            for(int i=0;i<=level;i++){
                if(i==0 || i==level){
                    current.add(1);
                }else{
                    current.add(triangle.get(level-1).get(i-1)+triangle.get(level-1).get(i));
                }
            }
            triangle.add(current);
        }

        return triangle;
    }
}