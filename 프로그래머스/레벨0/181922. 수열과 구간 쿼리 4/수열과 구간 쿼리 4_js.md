# [Lv.0] [수열과 구간 쿼리 4](https://school.programmers.co.kr/learn/courses/30/lessons/181922?language=javascript) - 181922 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(arr, queries) {
    queries.forEach(([s, e, k]) => {
        for (let i = s; i <= e; i++) {
            if (i % k === 0) {
                arr[i] += 1;
            }
        }
    });
    return arr;
}

```

### 성능 요약

1. 시간: 3.05 ms, 메모리: 36.2 MB

2. 시간: 2.58 ms, 메모리: 35.6 MB
3. 시간: 2.41 ms, 메모리: 35.9 MB
4. 시간: 2.10 ms, 메모리: 36.2 MB
5. 시간: 1.98 ms, 메모리: 35.9 MB

### 제출 일자

2024년 10월 20일 (일) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges