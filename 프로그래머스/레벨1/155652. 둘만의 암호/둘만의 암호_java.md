# [Lv.1] [둘만의 암호](https://school.programmers.co.kr/learn/courses/30/lessons/155652?language=java) - 155652 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int shiftCnt = index;
            char c = ch;

            while (shiftCnt > 0) {
                c = (c == 'z') ? 'a' : (char) (c + 1);
                if (!skipSet.contains(c)) {
                    shiftCnt--;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
```

### 성능 요약

1. 시간: 0.46 ms, 메모리: 87.7 MB

2. 시간: 0.39 ms, 메모리: 84.1 MB
3. 시간: 0.38 ms, 메모리: 84.8 MB
4. 시간: 0.37 ms, 메모리: 78.8 MB
5. 시간: 0.31 ms, 메모리: 85.6 MB

### 제출 일자

2024년 11월 28일 (목) 20:11

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges