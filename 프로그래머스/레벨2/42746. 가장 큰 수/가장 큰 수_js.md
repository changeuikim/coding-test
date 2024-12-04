# [Lv.2] [가장 큰 수](https://programmers.co.kr/) - 42746 

### 구분

코딩테스트 연습 > 정렬

## JavaScript 문제풀이

```js
const compare = (x, y) => {
    const left = x + y;
    const right = y + x;
    
    if (left > right) return -1;
    else if (left < right) return 1;
    else return 0;
}

function solution(numbers) {
    const result = numbers.map(String).sort(compare);
    return result[0] === "0" ? "0" : result.join("");
}
```

### 성능 요약

1. 시간: 92.25 ms, 메모리: 44.8 MB

2. 시간: 83.01 ms, 메모리: 44.7 MB
3. 시간: 69.75 ms, 메모리: 43.2 MB
4. 시간: 67.89 ms, 메모리: 44.5 MB
5. 시간: 48.67 ms, 메모리: 42.1 MB

### 제출 일자

2024년 12월 04일 (수) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges