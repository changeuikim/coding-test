# [Lv.1] [이상한 문자 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=javascript) - 12930 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(s) {
    const result = [];
    let wordIdx = 0;
    
    for (let i = 0; i < s.length; i++) {
        let char = s[i];
        
        if (char === ' ') {
            result.push(' ');
            wordIdx = 0;
        } else {
            if (wordIdx % 2 == 0) {
                result.push(char.toUpperCase());
            } else {
                result.push(char.toLowerCase());
            }
            wordIdx++;
        }
    }
    
    return result.join('');
}
```

### 성능 요약

1. 시간: 0.28 ms, 메모리: 33.6 MB

2. 시간: 0.26 ms, 메모리: 33.6 MB
3. 시간: 0.26 ms, 메모리: 33.5 MB
4. 시간: 0.26 ms, 메모리: 33.5 MB
5. 시간: 0.25 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 04일 (월) 23:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges