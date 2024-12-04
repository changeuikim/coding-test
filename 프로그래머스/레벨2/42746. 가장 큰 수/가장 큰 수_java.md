# [Lv.2] [가장 큰 수](https://programmers.co.kr/) - 42746 

### 구분

코딩테스트 연습 > 정렬

## Java 문제풀이

```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> numbersList = new ArrayList<>();
        for (int number : numbers) {
            numbersList.add(String.valueOf(number));
        }
        
        Collections.sort(numbersList, (x, y) -> (y + x).compareTo(x + y));
        
        String result = String.join("", numbersList);
        
        return result.charAt(0) == '0' ? "0" : result;
    }
}
```

### 성능 요약

1. 시간: 157.25 ms, 메모리: 107 MB

2. 시간: 154.78 ms, 메모리: 125 MB
3. 시간: 130.09 ms, 메모리: 134 MB
4. 시간: 129.70 ms, 메모리: 110 MB
5. 시간: 91.17 ms, 메모리: 113 MB

### 제출 일자

2024년 12월 04일 (수) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges