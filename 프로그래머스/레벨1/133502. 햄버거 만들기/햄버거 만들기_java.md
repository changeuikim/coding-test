# [Lv.1] [햄버거 만들기](https://programmers.co.kr/) - 133502 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int top = -1;
        int result = 0;
        
        for (int item : ingredient) {
            stack[++top] = item;
            
            if (top >= 3) {
                if (stack[top] == 1 && stack[top-1] == 3 && stack[top-2] == 2 && stack[top-3] == 1) {
                    top -= 4;
                    result++;
                }
            }
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 13.87 ms, 메모리: 146 MB

2. 시간: 11.83 ms, 메모리: 123 MB
3. 시간: 10.74 ms, 메모리: 100 MB
4. 시간: 9.84 ms, 메모리: 86.8 MB
5. 시간: 9.60 ms, 메모리: 122 MB

### 제출 일자

2024년 12월 04일 (수) 23:01

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges