# [Lv.1] [크기가 작은 부분문자열](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=javascript) - 147355 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(t, p) {
    let cnt = 0;
    for (let i = 0; i < t.length - p.length + 1; i++) {
        const window = t.substring(i, i + p.length);
        if (window <= p) {
            cnt++;
        }
    }
    return cnt;
}
```

### 성능 요약

1. 시간: 2.44 ms, 메모리: 36.5 MB

2. 시간: 2.35 ms, 메모리: 36.7 MB
3. 시간: 2.29 ms, 메모리: 36.7 MB
4. 시간: 2.20 ms, 메모리: 36.7 MB
5. 시간: 2.19 ms, 메모리: 36.8 MB

### 제출 일자

2024년 11월 04일 (월) 21:31

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges