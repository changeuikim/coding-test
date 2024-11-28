# [Lv.3] [최고의 집합](https://school.programmers.co.kr/learn/courses/30/lessons/12938?language=javascript) - 12938 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(n, s) {
    if (n > s) {
        return [-1];
    }

    const q = Math.floor(s / n);
    const r = s % n;
    const result = new Array(n).fill(q);

    for (let i = n - r; i < n; i++) {
        result[i] += 1;
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.33 ms, 메모리: 37.4 MB

2. 시간: 0.27 ms, 메모리: 37.1 MB
3. 시간: 0.26 ms, 메모리: 37.1 MB
4. 시간: 0.25 ms, 메모리: 37.1 MB
5. 시간: 0.24 ms, 메모리: 37.1 MB

### 제출 일자

2024년 11월 28일 (목) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges