# [Lv.2] [주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=java) - 42584 

### 구분

코딩테스트 연습 > 스택／큐

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];                
        int top = -1;
        int[] result = new int[n];                
        
        Arrays.fill(stack, -1);
                        
        // 인덱스의 역순으로 결과 배열을 초기화        
        for (int i = 0; i < n; i++) {
            result[i] = n - 1 - i;
        }
        
        // 단조 스택
        for (int i = 0; i < n; i++) {
            int cur = prices[i];
            
            while (top > -1 && cur < prices[stack[top]]) {
                int prevIdx = stack[top--];
                result[prevIdx] = i - prevIdx;
            }
            
            stack[++top] = i;
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 10.32 ms, 메모리: 70.4 MB

2. 시간: 9.32 ms, 메모리: 72.3 MB
3. 시간: 8.20 ms, 메모리: 69.9 MB
4. 시간: 5.94 ms, 메모리: 65.1 MB
5. 시간: 5.38 ms, 메모리: 62.5 MB

### 제출 일자

2024년 11월 19일 (화) 23:25

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges