# [Lv.0] [홀짝 구분하기](https://school.programmers.co.kr/learn/courses/30/lessons/181944?language=java) - 181944 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = (n & 1) == 1  ? "odd" : "even";
        System.out.printf("%d is %s", n, result);
        sc.close();
    }
}
```

### 성능 요약

1. 시간: 148.04 ms, 메모리: 66 MB

2. 시간: 142.82 ms, 메모리: 64.1 MB
3. 시간: 141.69 ms, 메모리: 64.5 MB
4. 시간: 135.69 ms, 메모리: 67.7 MB

### 제출 일자

2024년 10월 15일 (화) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges