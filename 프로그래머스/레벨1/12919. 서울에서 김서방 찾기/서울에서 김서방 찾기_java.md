# [Lv.1] [서울에서 김서방 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12919?language=java) - 12919 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public String solution(String[] seoul) {
        int idx = -1;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }
        return String.format("김서방은 %d에 있다", idx);
    }
}
```

### 성능 요약

1. 시간: 1.17 ms, 메모리: 74.9 MB

2. 시간: 1.09 ms, 메모리: 74.3 MB
3. 시간: 1.07 ms, 메모리: 75.8 MB
4. 시간: 1.04 ms, 메모리: 74.6 MB
5. 시간: 0.98 ms, 메모리: 76.5 MB

### 제출 일자

2024년 11월 01일 (금) 22:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges