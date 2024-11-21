# [Lv.3] [야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927?language=java) - 12927 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        int totalWorks = 0;
        
        // 최대힙
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            totalWorks += work;
            maxHeap.add((long) work);
        }
        
        if (totalWorks <= n) {
            return 0;
        }
        
        // heappushpop
        while (n-- > 0) {
            Long cur = maxHeap.poll();
            if (cur == 0) {
                break;
            }
            maxHeap.add(cur - 1);
        }
        
        // 최종 결과
        return maxHeap.stream().mapToLong(work -> work * work).sum();
    }
}
```

### 성능 요약

1. 시간: 147.28 ms, 메모리: 70.3 MB

2. 시간: 127.23 ms, 메모리: 69.5 MB
3. 시간: 5.23 ms, 메모리: 78.1 MB
4. 시간: 5.01 ms, 메모리: 78.4 MB
5. 시간: 4.60 ms, 메모리: 76.1 MB

### 제출 일자

2024년 11월 21일 (목) 23:47

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges