# [Lv.1] [실패율](https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=javascript) - 42889 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(N, stages) {
    // 각 스테이지에 멈춘 플레이어 수 계산
    const stagePlayers = new Array(N + 2).fill(0);
    stages.forEach(stage => stagePlayers[stage]++);
    
    // 각 스테이지의 실패율 계산
    const stageFailure = [];
    let players = stages.length;
    
    for (let stage = 1; stage < N + 1; stage++) {
        let failureRate = players > 0 ? stagePlayers[stage] / players : 0;
        stageFailure.push({ stage, failureRate });
        players -= stagePlayers[stage];
    }
    
    // 실패율 내림차순, 스테이지 오름차순
    stageFailure.sort((a, b) => {
        if (b.failureRate !== a.failureRate) {
            return b.failureRate - a.failureRate;
        }
        return a.stage - b.stage;
    });
    
    return stageFailure.map(({ stage }) => stage);
}
```

### 성능 요약

1. 시간: 7.35 ms, 메모리: 38.4 MB

2. 시간: 6.58 ms, 메모리: 39.2 MB
3. 시간: 5.10 ms, 메모리: 37.8 MB
4. 시간: 4.83 ms, 메모리: 39.4 MB
5. 시간: 4.54 ms, 메모리: 36.6 MB

### 제출 일자

2024년 11월 13일 (수) 23:47

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges