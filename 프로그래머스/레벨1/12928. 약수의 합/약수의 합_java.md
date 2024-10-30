# [Lv.1] [약수의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=java) - 12928 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        List<Integer> divisors = new ArrayList<>();
        
        // 제곱근 이하의 범위에서 절반의 약수를 구할 수 있다.
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                
                // 제곱수는 제외한다.
                if (i != n / i) {
                    
                    // 약수로 나눈 수도 약수이다.
                    divisors.add(n / i);                    
                }                
            }
        }
        
        return divisors.stream().mapToInt(Integer::intValue).sum();
    }
}
```

### 성능 요약

1. 시간: 3.55 ms, 메모리: 72.7 MB

2. 시간: 1.90 ms, 메모리: 78.5 MB
3. 시간: 1.71 ms, 메모리: 73.5 MB
4. 시간: 1.67 ms, 메모리: 80.6 MB
5. 시간: 1.63 ms, 메모리: 79.7 MB

### 제출 일자

2024년 10월 30일 (수) 21:11

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges