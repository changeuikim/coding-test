class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        int[] inDegree = new int[N + 1];

        for (int[] parts : prerequisites) {
            int v = parts[0];
            int u = parts[1];
            
            graph.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) q.offer(i);
        } 

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) q.offer(v);
            }
        }

        return count == N;
    }
}