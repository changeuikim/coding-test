# [Lv.0] [문자열 반복해서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181950?language=java) - 181950 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        System.out.println(str.repeat(n));
    }
}
```

### 성능 요약

1. 시간: 748.36 ms, 메모리: 67.4 MB

2. 시간: 204.38 ms, 메모리: 69.2 MB
3. 시간: 163.90 ms, 메모리: 68.3 MB

### 제출 일자

2024년 10월 13일 (일) 11:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges