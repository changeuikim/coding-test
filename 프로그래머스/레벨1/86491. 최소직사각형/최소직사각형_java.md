# [Lv.1] [최소직사각형](https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java) - 86491 

### 구분

코딩테스트 연습 > 완전탐색

## Java 문제풀이

```java
class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0, hMax = 0;
        
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
                
            if (width > height) {
                int temp = width;
                width = height;
                height = temp;
            }
            
            wMax = Math.max(wMax, width);
            hMax = Math.max(hMax, height);
        }
        
        return wMax * hMax;
    }
}
```

### 성능 요약

1. 시간: 1.75 ms, 메모리: 94.9 MB

2. 시간: 1.38 ms, 메모리: 84.4 MB
3. 시간: 1.09 ms, 메모리: 85.6 MB
4. 시간: 0.91 ms, 메모리: 77.1 MB
5. 시간: 0.73 ms, 메모리: 84.2 MB

### 제출 일자

2024년 11월 06일 (수) 19:03

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges