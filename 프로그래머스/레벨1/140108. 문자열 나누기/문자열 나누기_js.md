# [Lv.1] [문자열 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=javascript) - 140108 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(s) {
    let x = null;
    let diffCount = 0;
    let result = 0;

    for (let i = 0; i < s.length; i++) {
        // 문자열 구간 초기화
        if (diffCount === 0) {
            x = s[i];
            diffCount = 1;
            result++;
        } 
        // 현재 구간 상태 업데이트
        else {
            if (x === s[i]) diffCount++;
            else            diffCount--;
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.69 ms, 메모리: 33.5 MB

2. 시간: 0.49 ms, 메모리: 33.6 MB
3. 시간: 0.47 ms, 메모리: 33.4 MB
4. 시간: 0.43 ms, 메모리: 33.6 MB
5. 시간: 0.43 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 27일 (수) 21:14

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges