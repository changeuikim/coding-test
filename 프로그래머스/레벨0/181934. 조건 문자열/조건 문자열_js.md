# [Lv.0] [조건 문자열](https://school.programmers.co.kr/learn/courses/30/lessons/181934?language=javascript) - 181934 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(ineq, eq, n, m) {
    if (ineq === ">" && eq === "=") {
        return Number(n >= m)
    }    
    else if (ineq === ">" && eq === "!") {
        return Number(n > m)
    }
    else if (ineq === "<" && eq === "=") {
        return Number(n <= m)
    }    
    else if (ineq === "<" && eq === "!") {
        return Number(n < m)
    }
}
```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 33.4 MB

2. 시간: 0.05 ms, 메모리: 33.3 MB
3. 시간: 0.04 ms, 메모리: 33.5 MB
4. 시간: 0.04 ms, 메모리: 33.5 MB
5. 시간: 0.04 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 18일 (금) 01:14

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges