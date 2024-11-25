# [Lv.2] [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=javascript) - 42888 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(record) {
    const userNames = {};
    const actions = [];
    const messages = { "Enter": "님이 들어왔습니다.", "Leave": "님이 나갔습니다." };

    record.forEach(event => {
        const parts = event.split(' ');
        const action = parts[0];
        const userId = parts[1];

        if (action === "Enter" || action === "Change") {
            const nickname = parts[2];
            userNames[userId] = nickname;
        }

        if (action === "Enter" || action === "Leave") {
            actions.push([userId, messages[action]]);
        }
    });

    return actions.map(([userId, message]) => `${userNames[userId]}${message}`);
}
```

### 성능 요약

1. 시간: 193.60 ms, 메모리: 107 MB

2. 시간: 180.36 ms, 메모리: 99.3 MB
3. 시간: 174.48 ms, 메모리: 106 MB
4. 시간: 168.85 ms, 메모리: 102 MB
5. 시간: 145.22 ms, 메모리: 106 MB

### 제출 일자

2024년 11월 25일 (월) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges