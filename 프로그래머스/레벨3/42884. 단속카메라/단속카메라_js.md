# [Lv.3] [단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=javascript) - 42884 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## JavaScript 문제풀이

```js
function solution(routes) {
    let camera = -30001;
    let result = 0;

    routes.sort((a, b) => a[1] - b[1]);

    for (let route of routes) {
        if (camera < route[0]) {
            result++;
            camera = route[1];
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 2.51 ms, 메모리: 36.3 MB

2. 시간: 2.23 ms, 메모리: 35.9 MB
3. 시간: 0.95 ms, 메모리: 33.7 MB
4. 시간: 0.65 ms, 메모리: 33.7 MB
5. 시간: 0.25 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 30일 (토) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges