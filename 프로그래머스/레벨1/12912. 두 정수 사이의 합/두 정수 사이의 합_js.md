# [Lv.1] [두 정수 사이의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=javascript) - 12912 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(a, b) {
    if (a > b) {
        [a , b] = [b, a]
    }        
    
    let result = 0;
    for (let i = a; i <= b; i++) {
        result += i;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 23.07 ms, 메모리: 36.9 MB

2. 시간: 18.18 ms, 메모리: 36.8 MB
3. 시간: 15.44 ms, 메모리: 36.7 MB
4. 시간: 13.70 ms, 메모리: 36.5 MB
5. 시간: 9.83 ms, 메모리: 36.8 MB

### 제출 일자

2024년 11월 01일 (금) 18:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges