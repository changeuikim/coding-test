# [Lv.0] [마지막 두 원소](https://school.programmers.co.kr/learn/courses/30/lessons/181927?language=java) - 181927 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int lastNum = num_list[num_list.length - 1];
        int preNum = num_list[num_list.length - 2];        
        
        int[] newList = Arrays.copyOf(num_list, num_list.length + 1);
        
        if (lastNum > preNum) {
            newList[newList.length - 1] = lastNum - preNum;
        } else {
            newList[newList.length - 1] = 2 * lastNum;
        }        
        
        return newList;
    }
}

```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 77.3 MB

2. 시간: 0.03 ms, 메모리: 86 MB
3. 시간: 0.03 ms, 메모리: 76.5 MB
4. 시간: 0.03 ms, 메모리: 74.1 MB
5. 시간: 0.03 ms, 메모리: 72.3 MB

### 제출 일자

2024년 10월 19일 (토) 20:03

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges