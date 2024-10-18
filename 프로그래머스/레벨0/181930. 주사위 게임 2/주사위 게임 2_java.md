# [Lv.0] [주사위 게임 2](https://school.programmers.co.kr/learn/courses/30/lessons/181930?language=java) - 181930 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    int calc(int a, int b, int c, int n) {
        return (int) Math.pow(a, n) + (int) Math.pow(b, n) + (int) Math.pow(c, n);
    }    
    
    public int solution(int a, int b, int c) {
        Set<Integer> dice_set = new HashSet<>(Arrays.asList(a, b, c));
        int result = 1;
        
        switch (dice_set.size()) {
            case 1:
                result *= calc(a, b, c, 3);
            case 2:
                result *= calc(a, b, c, 2);
            case 3:
                result *= calc(a, b, c, 1);
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 0.32 ms, 메모리: 76.1 MB

2. 시간: 0.25 ms, 메모리: 77.3 MB
3. 시간: 0.23 ms, 메모리: 76.5 MB
4. 시간: 0.23 ms, 메모리: 73.5 MB
5. 시간: 0.23 ms, 메모리: 72.3 MB

### 제출 일자

2024년 10월 18일 (금) 10:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges