# [Lv.2] [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=java) - 42888 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static class Action {
        public String userId;
        public String message;

        public Action(String userId, String message) {
            this.userId = userId;
            this.message = message;
        }
    }    
    
    public String[] solution(String[] record) {
        Map<String, String> userNames = new HashMap<>();
        List<Action> actions = new ArrayList<>();
        Map<String, String> messages = Map.of(
            "Enter", "님이 들어왔습니다.",
            "Leave", "님이 나갔습니다."
        );

        for (String event : record) {
            String[] parts = event.split(" ");
            String action = parts[0];
            String userId = parts[1];

            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];
                userNames.put(userId, nickname);
            }

            if (action.equals("Enter") || action.equals("Leave")) {
                actions.add(new Action(userId, messages.get(action)));
            }
        }

        String[] result = new String[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            result[i] = userNames.get(action.userId) + action.message;
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 170.81 ms, 메모리: 147 MB

2. 시간: 158.53 ms, 메모리: 159 MB
3. 시간: 157.72 ms, 메모리: 162 MB
4. 시간: 152.79 ms, 메모리: 156 MB
5. 시간: 150.88 ms, 메모리: 146 MB

### 제출 일자

2024년 11월 25일 (월) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges