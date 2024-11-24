# [Lv.2] [택배상자](https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=java) - 131704 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new LinkedList<>();
        int head = 0;
        
        for (int box = 1; box <= order.length; box++) {
            if (box == order[head]) {
                head++;
            } else {
                stack.push(box);
            }
            
            while (!stack.isEmpty() && stack.peek() == order[head]) {
                stack.pop();
                head++;
            }            
        }
        
        return head;
    }
}
```

### 성능 요약

1. 시간: 179.62 ms, 메모리: 176 MB

2. 시간: 103.94 ms, 메모리: 150 MB
3. 시간: 55.26 ms, 메모리: 128 MB
4. 시간: 46.78 ms, 메모리: 142 MB
5. 시간: 33.13 ms, 메모리: 123 MB

### 제출 일자

2024년 11월 24일 (일) 23:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges