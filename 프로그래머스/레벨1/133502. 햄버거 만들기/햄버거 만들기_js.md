# [Lv.1] [햄버거 만들기](https://programmers.co.kr/) - 133502 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(ingredient) {
    const stack = new Array(ingredient.length).fill(0);
    let top = -1;
    let result = 0;
    
    for (const item of ingredient) {
        stack[++top] = item;
        
        if (top >= 3) {
            if (stack[top] === 1 && stack[top-1] === 3 && stack[top-2] === 2 && stack[top-3] === 1) {
                top -= 4;
                result++;
            }
        }
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 33.24 ms, 메모리: 76.2 MB

2. 시간: 28.33 ms, 메모리: 70.7 MB
3. 시간: 24.95 ms, 메모리: 63.7 MB
4. 시간: 24.20 ms, 메모리: 65.9 MB
5. 시간: 19.10 ms, 메모리: 52.2 MB

### 제출 일자

2024년 12월 04일 (수) 22:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges