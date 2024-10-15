# [Lv.0] [문자열 돌리기](https://school.programmers.co.kr/learn/courses/30/lessons/181945?language=java) - 181945 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(String.join("\n", str.split("")));
    }
}
```

### 성능 요약

1. 시간: 178.55 ms, 메모리: 66.6 MB

2. 시간: 174.42 ms, 메모리: 66.3 MB
3. 시간: 161.78 ms, 메모리: 68.9 MB

### 제출 일자

2024년 10월 15일 (화) 23:24

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges