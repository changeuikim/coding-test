# [Lv.1] [같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java) - 12906 

### 구분

코딩테스트 연습 > 스택／큐

## Java 문제풀이

```java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque();
        
        stack.push(arr[0]);
        for (int num : arr) {
            if (stack.peek() != num) {
                stack.push(num);
            }
        }
        
        int[] result = new int[stack.size()];
        int idx = result.length - 1;
        
        for (Integer num : stack) {
            result[idx--] = num;
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 43.99 ms, 메모리: 115 MB

2. 시간: 42.76 ms, 메모리: 115 MB
3. 시간: 42.50 ms, 메모리: 115 MB
4. 시간: 40.62 ms, 메모리: 115 MB
5. 시간: 0.31 ms, 메모리: 83.2 MB

### 제출 일자

2024년 11월 04일 (월) 19:40

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges