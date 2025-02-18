# [Medium] [Course Schedule II](https://leetcode.com/problems/course-schedule-ii) - 210 

### 구분

알고리즘, 데이터구조

## Java 문제풀이

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 인접리스트, 진입차수 초기화
        int N = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[N];
        
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int[] parts : prerequisites) {
            int v = parts[0];
            int u = parts[1];

            graph.get(u).add(v);
            inDegrees[v]++;
        }

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (inDegrees[i] == 0)
                q.offer(i);
        }

        // 위상 정렬
        while (!q.isEmpty()) {
            int u = q.poll();
            result[idx++] = u;

            for (int v : graph.get(u)) {
                inDegrees[v]--;
                if (inDegrees[v] == 0)
                    q.offer(v);
            }
        }

        // 사이클 확인
        if (idx != N)
            return new int[]{};

        return result;
    }
}
```

### 성능 요약

시간: 4 ms - 상위 NaN%

메모리: 46.3 MB - 상위 NaN%

### 제출 일자

2024년 12월 11일 (수) 11:05

> 출처: LeetCode, https://leetcode.com/problemset