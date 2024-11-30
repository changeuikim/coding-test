# [Lv.1] [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java) - 42862 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        students[0] = 0;
        
        for (int i : lost)      students[i]--;
        for (int i : reserve)   students[i]++;
        
        for (int i = 1; i <= n; i++) {
            if (students[i] == 2) {
                if (i > 1 && students[i - 1] == 0) {
                    students[i - 1]++;
                    students[i]--;
                } else if (i < n && students[i + 1] == 0) {
                    students[i + 1]++;
                    students[i] --;
                }
            }
        }
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] > 0) result++;
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 89.2 MB

2. 시간: 0.03 ms, 메모리: 88.7 MB
3. 시간: 0.03 ms, 메모리: 87.8 MB
4. 시간: 0.03 ms, 메모리: 85.3 MB
5. 시간: 0.03 ms, 메모리: 80.6 MB

### 제출 일자

2024년 11월 30일 (토) 20:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges