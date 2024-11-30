# [Lv.1] [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=javascript) - 42862 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## JavaScript 문제풀이

```js
function solution(n, lost, reserve) {
    const students = new Array(n + 1).fill(1);
    students[0] = 0;
    
    for (let i of lost)     students[i]--;
    for (let i of reserve)  students[i]++;
    
    for (let i = 1; i <= n; i++) {
        if (students[i] === 2) {
            if (i > 1 && students[i - 1] === 0) {
                students[i - 1]++;
                students[i]--;
            } else if (i < n && students[i + 1] === 0) {
                students[i + 1]++;
                students[i]--;
            }
        }
    }
    
    let result = 0;
    for (let i = 1; i <= n; i++) {
        if (students[i] > 0) result++;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.18 ms, 메모리: 33.5 MB

2. 시간: 0.09 ms, 메모리: 33.4 MB
3. 시간: 0.09 ms, 메모리: 33.3 MB
4. 시간: 0.08 ms, 메모리: 33.5 MB
5. 시간: 0.08 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 30일 (토) 20:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges