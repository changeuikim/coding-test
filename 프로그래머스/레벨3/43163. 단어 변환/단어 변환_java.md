# [Lv.3] [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java) - 43163 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Java 문제풀이

```java
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    String word;
    int count;
    
    Pair(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));
        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String cur = current.word;
            int cnt = current.count;

            // 종료 조건
            if (cur.equals(target)) {
                return cnt;
            }

            // 1글자만 다르면 큐에 추가
            for (int idx = 0; idx < words.length; idx++) {
                if (visited[idx]) {
                    continue;
                }
                
                // 자리별 차이 계산
                int dif = 0;
                for (int i = 0; i < begin.length(); i++) {
                    if (cur.charAt(i) != words[idx].charAt(i)) {
                        dif++;
                    }
                    if (dif > 1) {
                        break;
                    }
                }

                // 엔큐
                if (dif == 1) {
                    visited[idx] = true;
                    queue.add(new Pair(words[idx], cnt + 1));
                }
            }
        }

        return 0;
    }
}
```

### 성능 요약

1. 시간: 0.41 ms, 메모리: 73.8 MB

2. 시간: 0.39 ms, 메모리: 76.8 MB
3. 시간: 0.33 ms, 메모리: 76.8 MB
4. 시간: 0.32 ms, 메모리: 74.7 MB
5. 시간: 0.06 ms, 메모리: 73.6 MB

### 제출 일자

2024년 11월 20일 (수) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges