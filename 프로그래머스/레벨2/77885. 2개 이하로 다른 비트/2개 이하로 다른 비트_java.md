# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=java) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Java 문제풀이

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Long> solution(long[] numbers) {
        List<Long> result = new ArrayList<>();

        for (long num : numbers) {
            if (num % 2 == 0) {
                result.add(num + 1);
            } else {
                long bit = 1;
                while ((num & bit) != 0) {
                    bit <<= 1;
                }
                result.add(num + bit - (bit >> 1));
            }
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 13.52 ms, 메모리: 117 MB

2. 시간: 13.46 ms, 메모리: 118 MB
3. 시간: 11.61 ms, 메모리: 102 MB
4. 시간: 8.73 ms, 메모리: 117 MB
5. 시간: 8.65 ms, 메모리: 104 MB

### 제출 일자

2024년 12월 01일 (일) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges