# [Lv.1] [로또의 최고 순위와 최저 순위](https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=java) - 77484 

### 구분

코딩테스트 연습 > 2021 Dev－Matching： 웹 백엔드 개발자（상반기）

## Java 문제풀이

```java
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int zero_count = 0;
        Set<Integer> lottosSet = new HashSet<>();

        for (int num : lottos) {
            if (num == 0) {
                zero_count++;
            } else {
                lottosSet.add(num);
            }
        }

        int inter_count = 0;

        for (int win_num : win_nums) {
            if (lottosSet.contains(win_num)) {
                inter_count++;
            }
        }

        int max_count = inter_count + zero_count;
        int min_count = inter_count;

        return new int[]{rank[max_count], rank[min_count]};
    }
}
```

### 성능 요약

1. 시간: 0.07 ms, 메모리: 75 MB

2. 시간: 0.06 ms, 메모리: 74.4 MB
3. 시간: 0.05 ms, 메모리: 78 MB
4. 시간: 0.05 ms, 메모리: 76.6 MB
5. 시간: 0.05 ms, 메모리: 67.8 MB

### 제출 일자

2024년 11월 23일 (토) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges