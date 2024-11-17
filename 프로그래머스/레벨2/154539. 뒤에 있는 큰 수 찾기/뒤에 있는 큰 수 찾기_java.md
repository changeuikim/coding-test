# [Lv.2] [뒤에 있는 큰 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=java) - 154539 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        int[] stack = new int[n];
        int top = -1;        

        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            while (top > -1 && numbers[i] > numbers[stack[top]]) {
                result[stack[top--]] = numbers[i];
            }
            stack[++top] = i;
        }

        return result;
    }
}

```

### 성능 요약

1. 시간: 34.72 ms, 메모리: 181 MB

2. 시간: 30.36 ms, 메모리: 182 MB
3. 시간: 28.65 ms, 메모리: 191 MB
4. 시간: 24.93 ms, 메모리: 195 MB
5. 시간: 24.43 ms, 메모리: 196 MB

### 제출 일자

2024년 11월 17일 (일) 23:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges