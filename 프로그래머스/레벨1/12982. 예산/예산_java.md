# [Lv.1] [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=java) - 12982 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt = 0;
        
        for (int cost : d) {
            budget -= cost;
            if (budget < 0) {
                break;
            }
            cnt++;
        }
        
        return cnt;
    }
}
```

### 성능 요약

1. 시간: 0.59 ms, 메모리: 73 MB

2. 시간: 0.58 ms, 메모리: 75.8 MB
3. 시간: 0.57 ms, 메모리: 65.8 MB
4. 시간: 0.53 ms, 메모리: 76.1 MB
5. 시간: 0.53 ms, 메모리: 74.9 MB

### 제출 일자

2024년 11월 04일 (월) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges