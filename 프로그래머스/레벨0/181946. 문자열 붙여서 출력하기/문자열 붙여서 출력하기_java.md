# [Lv.0] [문자열 붙여서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181946?language=java) - 181946 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(String.join("", a, b));
    }
}
```

### 성능 요약

1. 시간: 143.13 ms, 메모리: 66.4 MB

2. 시간: 143.06 ms, 메모리: 66.7 MB
3. 시간: 139.72 ms, 메모리: 66.4 MB
4. 시간: 126.49 ms, 메모리: 67.2 MB

### 제출 일자

2024년 10월 14일 (월) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges