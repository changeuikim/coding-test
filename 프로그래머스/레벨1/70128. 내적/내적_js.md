# [Lv.1] [내적](https://school.programmers.co.kr/learn/courses/30/lessons/70128?language=javascript) - 70128 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## JavaScript 문제풀이

```js
function solution(a, b) {
    return a.reduce((acc, cur, idx) => acc + cur * b[idx], 0);
}
```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 33.5 MB

2. 시간: 0.08 ms, 메모리: 33.5 MB
3. 시간: 0.08 ms, 메모리: 33.5 MB
4. 시간: 0.07 ms, 메모리: 33.6 MB
5. 시간: 0.07 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 02일 (토) 21:16

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges