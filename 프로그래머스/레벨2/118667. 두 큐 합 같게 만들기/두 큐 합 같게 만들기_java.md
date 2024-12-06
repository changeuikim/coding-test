# [Lv.2] [두 큐 합 같게 만들기](https://programmers.co.kr/) - 118667 

### 구분

코딩테스트 연습 > 2022 KAKAO TECH INTERNSHIP

## Java 문제풀이

```java
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 빠른 반환 : 합이 홀수
        long q1_sum = Arrays.stream(queue1).sum();
        long total_sum = q1_sum + Arrays.stream(queue2).sum();
        if ((total_sum & 1) == 1) return -1;

        // 종료 조건 : 현재 합이 전체 합의 절반
        long current_sum = q1_sum;
        long target_sum = total_sum >> 1;

        // 원형 큐 : 두 큐를 결합
        int n = queue1.length;
        int size = 2 * n;
        int[] q = new int[size];
        System.arraycopy(queue1, 0, q, 0, n);
        System.arraycopy(queue2, 0, q, n, n);

        // 투 포인터 : i나 j가 한바퀴를 돌면 종료
        int cnt = 0, i = 0, j = n - 1;
        while (i < size && j < size) {
            if (current_sum == target_sum)  return cnt;

            if (current_sum > target_sum)   current_sum -= q[i++ % size];
            else                            current_sum += q[++j % size];

            cnt++;
        }

        return -1;
    }
}
```

### 성능 요약

1. 시간: 24.07 ms, 메모리: 118 MB

2. 시간: 16.22 ms, 메모리: 135 MB
3. 시간: 16.19 ms, 메모리: 142 MB
4. 시간: 13.74 ms, 메모리: 126 MB
5. 시간: 13.44 ms, 메모리: 144 MB

### 제출 일자

2024년 12월 06일 (금) 20:04

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges