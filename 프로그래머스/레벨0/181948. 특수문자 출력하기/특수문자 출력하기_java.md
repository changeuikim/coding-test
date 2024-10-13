# [Lv.0] [특수문자 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181948?language=java) - 181948 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("!@#$%^&*(")
            .append("\\")
            .append("'")
            .append("\"")
            .append("<>?:;");
        
        System.out.println(sb);
    }
}
```

### 성능 요약

1. 시간: 135.83 ms, 메모리: 62.7 MB



### 제출 일자

2024년 10월 14일 (월) 00:20

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges