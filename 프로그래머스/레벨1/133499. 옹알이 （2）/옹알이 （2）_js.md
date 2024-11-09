# [Lv.1] [옹알이 (2)](https://school.programmers.co.kr/learn/courses/30/lessons/133499?language=javascript) - 133499 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(babbling) {
    // 전방탐색(lookahead)
    const words = ['aya', 'ye', 'woo', 'ma']
    const lookahead = words.map(word => `${word}(?!${word})`).join('|');
    const pattern = new RegExp(`^(${lookahead})+$`);
    
    // 정규식
    let count = 0;
    for (const word of babbling) {
        if (pattern.test(word)) {
            count++;
        }
    }
    
    return count;
}
```

### 성능 요약

1. 시간: 0.28 ms, 메모리: 33.6 MB

2. 시간: 0.28 ms, 메모리: 33.5 MB
3. 시간: 0.26 ms, 메모리: 33.5 MB
4. 시간: 0.26 ms, 메모리: 33.4 MB
5. 시간: 0.25 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 09일 (토) 22:34

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges