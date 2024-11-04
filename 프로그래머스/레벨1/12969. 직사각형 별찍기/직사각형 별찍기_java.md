# [Lv.1] [직사각형 별찍기](https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=java) - 12969 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(("*".repeat(a) + "\n").repeat(b));
    }
}
```

### 성능 요약

1. 시간: 207.92 ms, 메모리: 81.6 MB

2. 시간: 168.99 ms, 메모리: 65.4 MB
3. 시간: 168.30 ms, 메모리: 65.1 MB
4. 시간: 166.72 ms, 메모리: 64.3 MB
5. 시간: 165.70 ms, 메모리: 76.1 MB

### 제출 일자

2024년 11월 04일 (월) 18:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges