# [Lv.1] [문자열 내 p와 y의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916?language=javascript) - 12916 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(s){
    s = s.toLowerCase();
    let cnt = 0;
    for (let i = 0; i < s.length; i++) {
        let char = s[i];
        if (char === 'p') {
            cnt += 1;
        } else if (char === 'y') {
            cnt -= 1;
        }
    }
    return cnt === 0;
}
```

### 성능 요약

1. 시간: 0.18 ms, 메모리: 33.5 MB

2. 시간: 0.17 ms, 메모리: 33.4 MB
3. 시간: 0.16 ms, 메모리: 33.5 MB
4. 시간: 0.14 ms, 메모리: 33.5 MB
5. 시간: 0.14 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 01일 (금) 19:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges