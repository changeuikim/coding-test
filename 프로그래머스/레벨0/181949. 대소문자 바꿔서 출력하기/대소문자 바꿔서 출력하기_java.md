# [Lv.0] [대소문자 바꿔서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181949?language=java) - 181949 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Scanner;

public class Solution {
    static StringBuilder swapcase(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));                
            }
        }
        return sb;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(swapcase(str));
    }
}
```

### 성능 요약

1. 시간: 183.78 ms, 메모리: 63.6 MB

2. 시간: 180.72 ms, 메모리: 66.9 MB
3. 시간: 163.48 ms, 메모리: 68.2 MB
4. 시간: 153.31 ms, 메모리: 64.7 MB

### 제출 일자

2024년 10월 13일 (일) 11:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges