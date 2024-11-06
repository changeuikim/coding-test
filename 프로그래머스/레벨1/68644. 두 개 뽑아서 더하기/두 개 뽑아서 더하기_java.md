# [Lv.1] [두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=java) - 68644 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## Java 문제풀이

```java
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> nSet = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                nSet.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] result = new int[nSet.size()];
        int idx = 0;
        for (int num : nSet) {
            result[idx++] = num;
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 2.49 ms, 메모리: 76.5 MB

2. 시간: 2.01 ms, 메모리: 76.6 MB
3. 시간: 1.60 ms, 메모리: 74.5 MB
4. 시간: 1.09 ms, 메모리: 78.8 MB
5. 시간: 0.86 ms, 메모리: 72.2 MB

### 제출 일자

2024년 11월 06일 (수) 22:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges