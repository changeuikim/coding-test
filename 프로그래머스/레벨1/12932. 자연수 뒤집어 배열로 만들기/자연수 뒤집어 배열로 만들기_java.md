# [Lv.1] [자연수 뒤집어 배열로 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java) - 12932 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public int[] solution(long n) {
        int size = (int) Math.log10(n) + 1;
        int[] result = new int[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = (int) (n % 10);
            n /= 10;
        }
                
        return result;        
    }
}
```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 76.7 MB

2. 시간: 0.05 ms, 메모리: 78.6 MB
3. 시간: 0.05 ms, 메모리: 77.7 MB
4. 시간: 0.05 ms, 메모리: 74.3 MB
5. 시간: 0.05 ms, 메모리: 73.1 MB

### 제출 일자

2024년 11월 01일 (금) 20:31

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges