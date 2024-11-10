# [Lv.2] [[3차] 압축](https://school.programmers.co.kr/learn/courses/30/lessons/17684?language=java) - 17684 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        
        // LZW 사전
        Map<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dic.put(Character.toString((char) ('A' + i)), i + 1);
        }
        int idx = 27;
        
        // 압축
        String w = "";
        for (char c : msg.toCharArray()) {
            String wc = w + c;
            if (dic.containsKey(wc)) {
                w = wc;
            } else {
                result.add(dic.get(w));
                dic.put(wc, idx++);
                w = Character.toString(c);
            }
        }
        
        // 잔여 처리
        if (!w.isEmpty()) {
            result.add(dic.get(w));
        }

        // List<Integer> -> int[] 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;    
    }
}
```

### 성능 요약

1. 시간: 14.67 ms, 메모리: 76.2 MB

2. 시간: 14.11 ms, 메모리: 82.9 MB
3. 시간: 14.05 ms, 메모리: 81.3 MB
4. 시간: 13.89 ms, 메모리: 76.3 MB
5. 시간: 13.87 ms, 메모리: 87.2 MB

### 제출 일자

2024년 11월 10일 (일) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges