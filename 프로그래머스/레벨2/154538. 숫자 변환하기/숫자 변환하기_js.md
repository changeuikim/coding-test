# [Lv.2] [숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538?language=javascript) - 154538 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(x, y, n) {
    if (x === y) return 0;

    const dp = {};
    dp[y] = 0;
    const queue = [y];

    while (queue.length > 0) {
        const curr = queue.shift();

        // 종료 조건
        if (curr === x) {
            return dp[curr];
        }

        // 역방향 탐색
        const prevValues = [];

        if (curr - n >= x) {
            prevValues.push(curr - n);
        }
        if (curr % 2 === 0) {
            prevValues.push(curr / 2);
        }
        if (curr % 3 === 0) {
            prevValues.push(curr / 3);
        }

        // DP에 추가
        for (const prev of prevValues) {
            if (!(prev in dp)) {
                dp[prev] = dp[curr] + 1;
                queue.push(prev);
            }
        }
    }

    return -1;
}
```

### 성능 요약

1. 시간: 0.97 ms, 메모리: 33.9 MB

2. 시간: 0.87 ms, 메모리: 33.9 MB
3. 시간: 0.85 ms, 메모리: 33.8 MB
4. 시간: 0.66 ms, 메모리: 33.6 MB
5. 시간: 0.61 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 27일 (수) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges