# [Lv.1] [삼총사](https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=java) - 131705 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
public class Solution {
    public int solution(int[] number) {
        int count = 0;
        int n = number.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 77 MB

2. 시간: 0.03 ms, 메모리: 73.7 MB
3. 시간: 0.03 ms, 메모리: 73.4 MB
4. 시간: 0.03 ms, 메모리: 71.7 MB
5. 시간: 0.03 ms, 메모리: 71.4 MB

### 제출 일자

2024년 11월 05일 (화) 23:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges