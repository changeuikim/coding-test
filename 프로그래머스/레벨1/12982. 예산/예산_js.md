# [Lv.1] [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=javascript) - 12982 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## JavaScript 문제풀이

```js
function solution(d, budget) {
    d.sort((a, b) => a - b);
    let cnt = 0;
    
    for (const cost of d) {
        budget -= cost;
        if (budget < 0) {
            break;
        }
        cnt++;
    }
    
    return cnt;
}
```

### 성능 요약

1. 시간: 0.22 ms, 메모리: 33.6 MB

2. 시간: 0.18 ms, 메모리: 33.6 MB
3. 시간: 0.18 ms, 메모리: 33.5 MB
4. 시간: 0.17 ms, 메모리: 33.6 MB
5. 시간: 0.17 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 04일 (월) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges