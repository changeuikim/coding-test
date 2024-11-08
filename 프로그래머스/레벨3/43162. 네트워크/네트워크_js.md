# [Lv.3] [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=javascript) - 43162 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## JavaScript 문제풀이

```js
const dfs = (i, visited, computers) => {
    visited[i] = true;
    for (let j = 0; j < computers[i].length; j++) {
        if (!visited[j] && computers[i][j] === 1) {
            dfs(j, visited, computers);
        }
    }
};

function solution(n, computers) {
    const visited = new Array(n).fill(false);
    let count = 0;
    
    for (let i = 0; i < computers.length; i++) {
        if (!visited[i]) {
            dfs(i, visited, computers);
            count++;
        }
    }
    
    return count;
}
```

### 성능 요약

1. 시간: 0.45 ms, 메모리: 33.7 MB

2. 시간: 0.38 ms, 메모리: 33.7 MB
3. 시간: 0.26 ms, 메모리: 33.4 MB
4. 시간: 0.23 ms, 메모리: 33.5 MB
5. 시간: 0.22 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 08일 (금) 22:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges