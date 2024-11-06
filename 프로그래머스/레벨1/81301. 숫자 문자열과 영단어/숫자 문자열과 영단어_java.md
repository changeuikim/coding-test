# [Lv.1] [숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=java) - 81301 

### 구분

코딩테스트 연습 > 2021 카카오 채용연계형 인턴십

## Java 문제풀이

```java
class Solution {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < nums.length; i++) {
            s = s.replaceAll(nums[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
```

### 성능 요약

1. 시간: 0.58 ms, 메모리: 73.1 MB

2. 시간: 0.53 ms, 메모리: 72.5 MB
3. 시간: 0.51 ms, 메모리: 75.2 MB
4. 시간: 0.49 ms, 메모리: 74.5 MB
5. 시간: 0.47 ms, 메모리: 72.2 MB

### 제출 일자

2024년 11월 06일 (수) 22:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges