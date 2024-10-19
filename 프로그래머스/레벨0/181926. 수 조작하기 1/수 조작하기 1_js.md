# [Lv.0] [수 조작하기 1](https://school.programmers.co.kr/learn/courses/30/lessons/181926?language=javascript) - 181926 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(n, control) {
    const ops = { "w" : 1, "s" : -1, "d" : 10, "a" : -10 };
    
    for (const key of control) {
        n += ops[key];
    }
    
    return n;    
}

```

### 성능 요약

1. 시간: 6.44 ms, 메모리: 38.4 MB

2. 시간: 6.21 ms, 메모리: 38.4 MB
3. 시간: 5.72 ms, 메모리: 38.1 MB
4. 시간: 5.66 ms, 메모리: 38.1 MB
5. 시간: 4.89 ms, 메모리: 38.1 MB

### 제출 일자

2024년 10월 19일 (토) 21:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges