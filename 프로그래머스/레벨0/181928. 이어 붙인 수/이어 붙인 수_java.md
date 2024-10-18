# [Lv.0] [이어 붙인 수](https://school.programmers.co.kr/learn/courses/30/lessons/181928?language=java) - 181928 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public int solution(int[] num_list) {
        StringBuilder oddNums = new StringBuilder();
        StringBuilder evenNums = new StringBuilder();
        
        for (int num : num_list) {
            if ((num&1) == 1) {
                oddNums.append(num);
            } else {
                evenNums.append(num);
            }
        }
        
        return Integer.parseInt(oddNums.toString()) + Integer.parseInt(evenNums.toString());
    }
}
```

### 성능 요약

1. 시간: 0.09 ms, 메모리: 71.2 MB

2. 시간: 0.07 ms, 메모리: 78.9 MB
3. 시간: 0.06 ms, 메모리: 83.8 MB
4. 시간: 0.06 ms, 메모리: 80.5 MB
5. 시간: 0.06 ms, 메모리: 79.8 MB

### 제출 일자

2024년 10월 18일 (금) 11:29

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges