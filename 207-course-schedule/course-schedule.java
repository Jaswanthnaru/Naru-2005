class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visit = new boolean[numCourses];

        // Check for cycle in each component
        for (int i = 0; i < numCourses; i++) {
            if (!visit[i]) {
                if (isCycle(i, new boolean[numCourses], visit, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCycle(int node, boolean[] curr,
                            boolean[] visit, List<List<Integer>> graph) {
        // If node is already in current path → cycle detected
        if (curr[node]) {
            return true;
        }

        // If already visited → no cycle from this node
        if (visit[node]) {
            return false;
        }

        visit[node] = true;
        curr[node] = true;

        // Traverse neighbors
        for (int neighbor : graph.get(node)) {
            if (isCycle(neighbor, curr, visit, graph)) {
                return true;
            }
        }

        // Backtrack
        curr[node] = false;
        return false;
    }
}