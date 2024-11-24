# [Lv.2] [택배상자](https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=javascript) - 131704 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(order) {
    let head = 0;
    const stack = [];
    
    for (let box = 1; box <= order.length; box++) {
        if (box === order[head]) {
            head++;
        } else {
            stack.push(box);
        }
        
        while (stack.length > 0 && stack[stack.length - 1] === order[head]) {
            stack.pop();
            head++;
        }
    }
    
    return head;
}
```

### 성능 요약

1. 시간: 31.71 ms, 메모리: 74.1 MB

2. 시간: 30.75 ms, 메모리: 92.7 MB
3. 시간: 17.59 ms, 메모리: 56.1 MB
4. 시간: 17.18 ms, 메모리: 62.5 MB
5. 시간: 15.05 ms, 메모리: 75.1 MB

### 제출 일자

2024년 11월 24일 (일) 23:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges