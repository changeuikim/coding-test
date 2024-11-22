# [Lv.1] [[1차] 다트 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=javascript) - 17682 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(dartResult) {
    const bonusMap = { 'S': 1, 'D': 2, 'T': 3 };
    const optionMap = { '*': 2, '#': -1, '': 1 };
    const scores = [];
    
    // 점수 | 보너스 | [옵션]
    const pattern = /(\d+)([SDT])([*#])?/g;
    const matches = dartResult.matchAll(pattern);
    
    for (const match of matches) {
        const score_str = match[1];
        const bonus = match[2];
        const opt = match[3] || '';
        
        let score = parseInt(score_str) ** bonusMap[bonus] * optionMap[opt];
        
        if (opt === '*' && scores.length > 0) {
            scores[scores.length - 1] *= optionMap[opt];
        }        
        
        scores.push(score);
    }
    
    return scores.reduce((acc, cur) => acc + cur, 0);
}
```

### 성능 요약

1. 시간: 0.23 ms, 메모리: 33.4 MB

2. 시간: 0.22 ms, 메모리: 33.4 MB
3. 시간: 0.22 ms, 메모리: 33.4 MB
4. 시간: 0.21 ms, 메모리: 33.5 MB
5. 시간: 0.21 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 22일 (금) 23:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges