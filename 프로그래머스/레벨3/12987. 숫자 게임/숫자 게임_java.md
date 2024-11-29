# [Lv.3] [숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987?language=java) - 12987 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int result = 0;
        int i = 0;
        
        for (int j = 0; j < B.length; j++) {
            if (B[j] > A[i]) {
                result++;
                i++;
            }
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 65.77 ms, 메모리: 69.9 MB

2. 시간: 64.07 ms, 메모리: 69.7 MB
3. 시간: 55.82 ms, 메모리: 67.2 MB
4. 시간: 7.29 ms, 메모리: 79.7 MB
5. 시간: 6.03 ms, 메모리: 75.4 MB

### 제출 일자

2024년 11월 29일 (금) 23:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges