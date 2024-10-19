# [Lv.0] [수 조작하기 2](https://school.programmers.co.kr/learn/courses/30/lessons/181925?language=javascript) - 181925 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(numLog) {
    const ops = new Map([
        [1, 'w'],
        [-1, 's'],
        [10, 'd'],
        [-10, 'a']
    ]);
    
    const controls = new Array(numLog.length - 1);
    
    for (let i = 0; i < numLog.length - 1; i++) {
        const key = numLog[i + 1] - numLog[i];
        controls[i] = ops.get(key);
    }
    
    return controls.join('');
}
```

### 성능 요약

1. 시간: 8.28 ms, 메모리: 43.1 MB

2. 시간: 7.78 ms, 메모리: 42.6 MB
3. 시간: 6.88 ms, 메모리: 41.2 MB
4. 시간: 6.82 ms, 메모리: 40.3 MB
5. 시간: 6.41 ms, 메모리: 40.9 MB

### 제출 일자

2024년 10월 19일 (토) 23:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges