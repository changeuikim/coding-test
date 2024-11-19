# [Lv.2] [더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java) - 42626 

### 구분

코딩테스트 연습 > 힙（Heap）

## Java 문제풀이

```java
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.add(s);
        }

        int count = 0;

        while (heap.peek() < K) {
            if (heap.size() < 2) {
                return -1;
            }

            int first = heap.poll();
            int second = heap.poll();
            heap.add(first + second * 2);
            count++;
        }

        return count;
    }
}

```

### 성능 요약

1. 시간: 1381.94 ms, 메모리: 124 MB

2. 시간: 1324.05 ms, 메모리: 123 MB
3. 시간: 252.21 ms, 메모리: 86.5 MB
4. 시간: 133.30 ms, 메모리: 65.7 MB
5. 시간: 132.92 ms, 메모리: 65.9 MB

### 제출 일자

2024년 11월 19일 (화) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges