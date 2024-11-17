# [Lv.2] [뒤에 있는 큰 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=javascript) - 154539 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(numbers) {
    const result = new Array(numbers.length).fill(-1);
    const stack = [];

    for (let i = 0; i < numbers.length; i++) {
        const num = numbers[i];
        while (stack.length > 0 && num > numbers[stack[stack.length - 1]]) {
            result[stack.pop()] = num;
        }
        stack.push(i);
    }

    return result;
}

```

### 성능 요약

1. 시간: 44.97 ms, 메모리: 160 MB

2. 시간: 41.91 ms, 메모리: 152 MB
3. 시간: 40.62 ms, 메모리: 149 MB
4. 시간: 24.97 ms, 메모리: 126 MB
5. 시간: 24.52 ms, 메모리: 108 MB

### 제출 일자

2024년 11월 17일 (일) 23:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges