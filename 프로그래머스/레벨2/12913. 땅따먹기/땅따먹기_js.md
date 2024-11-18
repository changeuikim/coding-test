# [Lv.2] [땅따먹기](https://school.programmers.co.kr/learn/courses/30/lessons/12913?language=javascript) - 12913 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(land) {
    const n = land.length;
    const m = 4;
    
    // 2행부터 DP
    for (let i = 1; i < n; i++) {
        let max1 = -1, idx = -1, max2 = -1;
        
        // 이전행 최대, 차대 찾기
        for (let j = 0; j < m; j++) {
            const cur = land[i - 1][j];
            
            if (cur > max1) {
                max2 = max1;
                max1 = cur;
                idx = j;
            }
            else if (cur > max2) {
                max2 = cur;
            }
        }
        
        // 이번행 DP
        for (let j = 0; j < m; j++) {
            let prev = max1;
            if (j === idx) {
                prev = max2;
            }
            
            land[i][j] += prev;
        }
    }    
    
    return Math.max(...land[n - 1]);    
}
```

### 성능 요약

1. 시간: 46.58 ms, 메모리: 77.3 MB

2. 시간: 41.99 ms, 메모리: 76.9 MB
3. 시간: 20.51 ms, 메모리: 78.2 MB
4. 시간: 18.42 ms, 메모리: 78.2 MB
5. 시간: 0.60 ms, 메모리: 33.8 MB

### 제출 일자

2024년 11월 18일 (월) 22:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges