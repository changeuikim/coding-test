# [Lv.1] [같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=javascript) - 12906 

### 구분

코딩테스트 연습 > 스택／큐

## JavaScript 문제풀이

```js
function solution(arr) {
    stack = [arr[0]];
    
    arr.forEach(num => {
        if (num !== stack[stack.length - 1]) {
            stack.push(num);
        }
    });
    
    return stack;
}
```

### 성능 요약

1. 시간: 53.43 ms, 메모리: 83.5 MB

2. 시간: 45.41 ms, 메모리: 82.9 MB
3. 시간: 43.16 ms, 메모리: 83.2 MB
4. 시간: 42.78 ms, 메모리: 83.2 MB
5. 시간: 0.08 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 04일 (월) 19:40

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges