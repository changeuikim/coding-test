# [Lv.0] [수열과 구간 쿼리 3](https://school.programmers.co.kr/learn/courses/30/lessons/181924?language=javascript) - 181924 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(arr, queries) {
    queries.forEach(([u, v]) => {
        [arr[u], arr[v]] = [arr[v], arr[u]];
    })
    return arr;
}
```

### 성능 요약

1. 시간: 0.65 ms, 메모리: 34.1 MB

2. 시간: 0.59 ms, 메모리: 33.9 MB
3. 시간: 0.51 ms, 메모리: 34 MB
4. 시간: 0.50 ms, 메모리: 34.1 MB
5. 시간: 0.46 ms, 메모리: 34 MB

### 제출 일자

2024년 10월 20일 (일) 22:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges