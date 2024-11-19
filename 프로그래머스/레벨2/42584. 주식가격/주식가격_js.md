# [Lv.2] [주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=javascript) - 42584 

### 구분

코딩테스트 연습 > 스택／큐

## JavaScript 문제풀이

```js
function solution(prices) {
    const n = prices.length;
    const stack = new Array(n).fill(-1);
    let top = -1;
    
    // 인덱스의 역순으로 결과 배열을 초기화
    const result = Array.from({ length: n }, (_, i) => n - 1 - i);
    
    // 단조 스택
    for (let i = 0; i < n; i++) {
        const cur = prices[i];
        
        while (top > -1 && cur < prices[stack[top]]) {
            const prevIdx = stack[top--];
            result[prevIdx] = i - prevIdx;
        }
        
        stack[++top] = i;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 26.76 ms, 메모리: 43.3 MB

2. 시간: 25.12 ms, 메모리: 41.9 MB
3. 시간: 11.52 ms, 메모리: 43.3 MB
4. 시간: 10.22 ms, 메모리: 41.3 MB
5. 시간: 9.76 ms, 메모리: 40.7 MB

### 제출 일자

2024년 11월 19일 (화) 23:23

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges