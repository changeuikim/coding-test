# [Lv.2] [롤케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=java) - 132265 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
public class Solution {
    public int solution(int[] topping) {
        int result = 0;

        // 인덱스가 토핑 번호, 요소가 토핑의 수
        int[] left = new int[10000 + 1];
        int[] right = new int[10000 + 1];

        // 동생 초기화
        int rc = 0;    
        for (int i : topping) {
            if (right[i] == 0) {
                rc++;
            }
            right[i]++;
        }

        // 슬라이딩 윈도우
        int lc = 0;
        for (int i : topping) {
            // 동생 제거
            right[i]--;
            if (right[i] == 0) {
                rc--;
            }

            // 철수 추가
            if (left[i] == 0) {
                lc++;
            }
            left[i]++;

            // 비교
            if (lc == rc) {
                result++;
            }
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 24.51 ms, 메모리: 142 MB

2. 시간: 23.62 ms, 메모리: 127 MB
3. 시간: 21.56 ms, 메모리: 141 MB
4. 시간: 18.63 ms, 메모리: 125 MB
5. 시간: 18.58 ms, 메모리: 139 MB

### 제출 일자

2024년 11월 10일 (일) 23:09

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges