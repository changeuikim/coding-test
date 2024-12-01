# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=javascript) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## JavaScript 문제풀이

```js
function solution(numbers) {
    const result = [];

    numbers.forEach(num => {
        const bigNum = BigInt(num);
        
        // 첫번째 0은 1로, 뒤는 모두 0
        const biggerNum = bigNum + 1n;
        // 첫번째 0 이전은 0, 뒤는 모두 1
        const bitDiff = bigNum ^ (bigNum + 1n);
        // 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
        const minNum = biggerNum + (bitDiff >> 2n);

        result.push(Number(minNum));
    });

    return result;
}
```

### 성능 요약

1. 시간: 38.81 ms, 메모리: 56.1 MB

2. 시간: 34.51 ms, 메모리: 57.7 MB
3. 시간: 33.61 ms, 메모리: 56.6 MB
4. 시간: 30.82 ms, 메모리: 56.2 MB
5. 시간: 30.30 ms, 메모리: 50.6 MB

### 제출 일자

2024년 12월 02일 (월) 00:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges