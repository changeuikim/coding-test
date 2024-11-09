# [Lv.1] [옹알이 (2)](https://school.programmers.co.kr/learn/courses/30/lessons/133499?language=java) - 133499 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.List;
import java.util.regex.*;

class Solution {
    public int solution(String[] babbling) {
        // 전방탐색(lookahead)
        List<String> words = List.of("aya", "ye", "woo", "ma");
        String lookahead = String.join("|", words.stream()
                                      .map(word -> String.format("%s(?!%s)", word, word))
                                      .toArray(String[]::new));
        Pattern pattern = Pattern.compile(String.format("^(%s)+$",lookahead));
        
        // 정규식
        int count = 0;
        for (String word : babbling) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                count++;
            }
        }
        
        return count;
    }
}
```

### 성능 요약

1. 시간: 4.80 ms, 메모리: 74.7 MB

2. 시간: 4.22 ms, 메모리: 75.3 MB
3. 시간: 4.05 ms, 메모리: 74.9 MB
4. 시간: 3.98 ms, 메모리: 73.1 MB
5. 시간: 3.96 ms, 메모리: 73.5 MB

### 제출 일자

2024년 11월 09일 (토) 22:35

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges