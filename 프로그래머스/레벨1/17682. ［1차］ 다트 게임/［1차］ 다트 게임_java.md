# [Lv.1] [[1차] 다트 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=java) - 17682 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int solution(String dartResult) {
        Map<String, Integer> bonusMap = Map.of("S", 1, "D", 2, "T", 3);
        Map<String, Integer> optionMap = Map.of("*", 2, "#", -1, "", 1);
        Deque<Integer> scores = new LinkedList<>();
        
        // 점수 | 보너스 | [옵션]
        Pattern pattern = Pattern.compile("(\\d+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);      
        
        while (matcher.find()) {
            String scoreStr = matcher.group(1);
            String bonus = matcher.group(2);
            String opt = (matcher.group(3) != null) ? matcher.group(3) : "";
            
            int score = (int) Math.pow(Integer.parseInt(scoreStr), bonusMap.get(bonus)) * optionMap.get(opt);
            
            if (opt.equals("*") && !scores.isEmpty()) {
                scores.push(scores.pop() * 2);
            }
            
            scores.push(score);
        }
        
        return scores.stream().mapToInt(Integer::intValue).sum();
    }
}
```

### 성능 요약

1. 시간: 3.85 ms, 메모리: 73.7 MB

2. 시간: 2.78 ms, 메모리: 77.7 MB
3. 시간: 2.53 ms, 메모리: 78.8 MB
4. 시간: 2.30 ms, 메모리: 73.9 MB
5. 시간: 2.24 ms, 메모리: 75.6 MB

### 제출 일자

2024년 11월 22일 (금) 23:34

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges