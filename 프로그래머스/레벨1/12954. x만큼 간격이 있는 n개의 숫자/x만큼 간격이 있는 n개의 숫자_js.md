# [Lv.1] [x만큼 간격이 있는 n개의 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=javascript) - 12954 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(x, n) {
    return Array.from({ length: n}, (_, i) => x + x * i);
}
```

### 성능 요약

1. 시간: 0.16 ms, 메모리: 33.6 MB

2. 시간: 0.16 ms, 메모리: 33.6 MB
3. 시간: 0.14 ms, 메모리: 33.5 MB
4. 시간: 0.12 ms, 메모리: 33.5 MB
5. 시간: 0.11 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 31일 (목) 20:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges