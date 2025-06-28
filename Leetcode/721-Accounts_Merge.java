class Solution {
    /*
    Time Complexity
        Map all emails -> O(T)

        Build adj list -> O(T)

        DFS traversal -> O(E + total edges)

        Sort groups -> O(E log E)

    Total: O(T + E log E); Since edges could be close to T, the DFS can visit every edge once.

    Space Complexity

        O(E) -> Maps, adj list

        O(E) -> DFS recursion stack in worst case

    So total is O(E + T)

     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashSet<String> hs = new HashSet();

        // step 1 = Assign Unique ID to every Distinct Email and store in map

        HashMap<String, Integer> emailToId = new HashMap(); // email to id
        HashMap<Integer, String> idToEmail = new HashMap(); // email to id
        HashMap<String, String> emailToName = new HashMap(); // email to name

        int currIdx = 0;
        for (List<String> acc : accounts) {
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, currIdx);
                    idToEmail.put(currIdx, email);
                    emailToName.put(email, acc.get(0));
                    currIdx++;
                }
            }
        }
        // step 2 = ADJ List Constructions using email to id mapping
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        int n = emailToId.size();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (List<String> acc : accounts) {
            String email = acc.get(1);
            int leaderId = emailToId.get(email);
            for (int i = 2; i < acc.size(); i++) {
                int childId = emailToId.get(acc.get(i));

                adj.get(leaderId).add(childId);
                adj.get(childId).add(leaderId);
            }
        }

        // step 3 - Count Components using DFS/DSU

        int comps = 0;
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        List<List<String>> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                comps++;
                dfs(adj, vis, n, i, comps);
                result.add(new ArrayList());

                for (int j = 0; j < n; j++) {
                    List<String> arr = result.get(comps - 1);
                    if (vis[j] == comps) {
                        arr.add(idToEmail.get(j));
                    }
                }
                Collections.sort(result.get(comps - 1));
                List<String> temp = result.get(comps - 1);
                temp.add(0, emailToName.get(temp.get(0)));
            }
        }

        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int vis[], int n, int i, int comps) {
        vis[i] = comps;

        for (int nbr : adj.get(i)) {
            if (vis[nbr] == -1) {
                dfs(adj, vis, n, nbr, comps);
            }
        }
    }
}