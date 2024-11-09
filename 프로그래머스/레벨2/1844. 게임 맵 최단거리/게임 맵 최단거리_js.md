# [Lv.2] [게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=javascript) - 1844 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## JavaScript 문제풀이

```js
function solution(maps) {
    // 초기화
    const n = maps.length;
    const m = maps[0].length;
    const directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]; // 동서남북
    const distance = Array.from({ length: n }, () => Array(m).fill(1)); // 이동 칸 수
    const queue = [[0, 0]]; // (y, x)

    // BFS
    while (queue.length > 0) {
        const [y, x] = queue.shift();

        // 종료 조건: n행 m열
        if (y === n - 1 && x === m - 1) {
            return distance[y][x];
        }

        // 방향 전환
        for (const [dy, dx] of directions) {
            const ny = y + dy;
            const nx = x + dx;
            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (distance[ny][nx] === 1 && maps[ny][nx] === 1) {
                    distance[ny][nx] = distance[y][x] + 1;
                    queue.push([ny, nx]);
                }
            }
        }
    }
    
    return -1;
}

```

### 성능 요약

1. 시간: 49.02 ms, 메모리: 38.4 MB

2. 시간: 19.88 ms, 메모리: 38.9 MB
3. 시간: 12.55 ms, 메모리: 38.9 MB
4. 시간: 10.59 ms, 메모리: 38.7 MB
5. 시간: 0.60 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 09일 (토) 23:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges