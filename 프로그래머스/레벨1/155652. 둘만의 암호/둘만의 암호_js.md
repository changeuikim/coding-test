# [Lv.1] [둘만의 암호](https://school.programmers.co.kr/learn/courses/30/lessons/155652?language=javascript) - 155652 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(s, skip, index) {
    const skipSet = new Set(skip);
    const result = [];

    for (const char of s) {
        let shiftCnt = index;
        let c = char;

        while (shiftCnt > 0) {
            c = c === 'z' ? 'a' : String.fromCharCode(c.charCodeAt(0) + 1);
            if (!skipSet.has(c)) {
                shiftCnt--;
            }
        }

        result.push(c);
    }

    return result.join('');
}
```

### 성능 요약

1. 시간: 0.48 ms, 메모리: 33.4 MB

2. 시간: 0.29 ms, 메모리: 33.4 MB
3. 시간: 0.29 ms, 메모리: 33.3 MB
4. 시간: 0.26 ms, 메모리: 33.4 MB
5. 시간: 0.26 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 28일 (목) 20:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges