# [Lv.1] [정수 제곱근 판별](https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=javascript) - 12934 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(n) {
    const x = Math.sqrt(n);
    return Number.isInteger(x) ? Math.pow(x + 1, 2) : -1;
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 33.5 MB

2. 시간: 0.05 ms, 메모리: 33.4 MB
3. 시간: 0.04 ms, 메모리: 33.5 MB
4. 시간: 0.04 ms, 메모리: 33.5 MB
5. 시간: 0.04 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 01일 (금) 21:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges