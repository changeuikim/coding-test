# [Lv.1] [[PCCE 기출문제] 9번 / 지폐 접기](https://school.programmers.co.kr/learn/courses/30/lessons/340199?language=java) - 340199 

### 구분

코딩테스트 연습 > PCCE 기출문제

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Arrays.sort(bill);
        int count = 0;
        
        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            bill[1] /= 2;
            Arrays.sort(bill);
            count++;
        }
        
        return count;
    }
}
```

### 성능 요약

1. 시간: 0.55 ms, 메모리: 77.2 MB

2. 시간: 0.53 ms, 메모리: 75.7 MB
3. 시간: 0.51 ms, 메모리: 78 MB
4. 시간: 0.51 ms, 메모리: 77.9 MB
5. 시간: 0.51 ms, 메모리: 73.4 MB

### 제출 일자

2024년 11월 21일 (목) 23:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges