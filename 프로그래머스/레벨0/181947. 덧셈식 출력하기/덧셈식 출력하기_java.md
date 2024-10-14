# [Lv.0] [덧셈식 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181947?language=java) - 181947 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.printf("%d + %d = %d", a, b, a+b);
    }
}
```

### 성능 요약

1. 시간: 161.49 ms, 메모리: 65.5 MB

2. 시간: 151.65 ms, 메모리: 65.4 MB
3. 시간: 139.74 ms, 메모리: 62.2 MB

### 제출 일자

2024년 10월 14일 (월) 22:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges