# [Lv.1] [두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=javascript) - 68644 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## JavaScript 문제풀이

```js
function solution(numbers) {
    const nSet = new Set();
    
    for (let i = 0; i < numbers.length; i++) {
        for (let j = i + 1; j < numbers.length; j++) {
            nSet.add(numbers[i] + numbers[j]);
        }
    }
    
    return [...nSet].sort((a, b) => a - b);
}
```

### 성능 요약

1. 시간: 0.66 ms, 메모리: 33.4 MB

2. 시간: 0.51 ms, 메모리: 33.4 MB
3. 시간: 0.51 ms, 메모리: 33.4 MB
4. 시간: 0.19 ms, 메모리: 33.6 MB
5. 시간: 0.17 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 06일 (수) 22:09

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges