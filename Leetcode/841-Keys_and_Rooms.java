class Solution {
    static int ans = 0;

    public void dfs(List<List<Integer>> rooms, int i, boolean vis[]) {
        vis[i] = true;
        ans++;
        for (int room : rooms.get(i)) {
            if (!vis[room]) {
                dfs(rooms, room, vis);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Do dfs count visited rooms if rooms are equal to n which can visited then true or
        // definately we cannot visit all rooms from room no. 0
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        ans = 0;

        dfs(rooms, 0, vis);

        return ans == n;
    }
}