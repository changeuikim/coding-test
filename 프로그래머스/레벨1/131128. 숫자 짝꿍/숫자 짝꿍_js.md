# [Lv.1] [숫자 짝꿍](https://school.programmers.co.kr/learn/courses/30/lessons/131128?language=javascript) - 131128 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(X, Y) {
    // X, Y의 Map
    const xMap = {};
    const yMap = {};

    for (const ch of X) {
        xMap[ch] = (xMap[ch] || 0) + 1;
    }

    for (const ch of Y) {
        yMap[ch] = (yMap[ch] || 0) + 1;
    }

    // X, Y의 교집합 키
    const rKeys = [];
    for (let i = 9; i >= 0; i--) {
        const key = i.toString();
        if (xMap[key] && yMap[key]) {
            rKeys.push(key);
        }
    }

    // 조기 반환
    if (rKeys.length === 0) {
        return "-1";
    } else if (rKeys[0] === "0") {
        return "0";
    }

    // 결과 반환
    const result = [];
    for (const key of rKeys) {
        const count = Math.min(xMap[key], yMap[key]);
        result.push(key.repeat(count));
    }

    return result.join('');
}
```

### 성능 요약

1. 시간: 248.90 ms, 메모리: 62.9 MB

2. 시간: 205.99 ms, 메모리: 62.9 MB
3. 시간: 191.37 ms, 메모리: 63 MB
4. 시간: 190.31 ms, 메모리: 63 MB
5. 시간: 179.29 ms, 메모리: 63.1 MB

### 제출 일자

2024년 12월 01일 (일) 23:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges