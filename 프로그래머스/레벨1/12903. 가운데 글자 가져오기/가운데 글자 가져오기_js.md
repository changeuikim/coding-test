# [Lv.1] [가운데 글자 가져오기](https://school.programmers.co.kr/learn/courses/30/lessons/12903?language=javascript) - 12903 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(s) {
    const n = s.length;
    const start = Math.floor((n - 1) / 2);
    const end = Math.floor(n / 2) + 1;
    return s.slice(start, end);
}
```

### 성능 요약

1. 시간: 0.04 ms, 메모리: 33.5 MB

2. 시간: 0.03 ms, 메모리: 33.5 MB
3. 시간: 0.03 ms, 메모리: 33.5 MB
4. 시간: 0.03 ms, 메모리: 33.4 MB
5. 시간: 0.03 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 02일 (토) 21:33

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges