# [Lv.2] [다리를 지나는 트럭](https://programmers.co.kr/) - 42583 

### 구분

코딩테스트 연습 > 스택／큐

## JavaScript 문제풀이

```js
function solution(bridge_length, weight, truck_weights) {
    const bridge = Array(bridge_length).fill(0);
    let totalWeight = 0;
    let time = 0;

    for (let truck of truck_weights) {
        while (true) {
            time++;
            totalWeight -= bridge.shift();

            if (totalWeight + truck <= weight) {
                bridge.push(truck);
                totalWeight += truck;
                break;
            } else {
                bridge.push(0);
            }
        }
    }

    return time + bridge_length;
}
```

### 성능 요약

1. 시간: 29.00 ms, 메모리: 38.1 MB

2. 시간: 10.53 ms, 메모리: 37.9 MB
3. 시간: 7.31 ms, 메모리: 37.8 MB
4. 시간: 5.56 ms, 메모리: 37.4 MB
5. 시간: 0.87 ms, 메모리: 33.6 MB

### 제출 일자

2024년 12월 09일 (월) 22:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges