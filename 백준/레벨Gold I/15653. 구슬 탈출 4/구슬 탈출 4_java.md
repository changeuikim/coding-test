# [Gold I] [구슬 탈출 4](https://www.acmicpc.net/problem/15653) - 15653 

NaN너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Pos {
    int y, x, cnt;
    Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
    Pos(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

class State {
    Pos red, blue;
    int moves;

    State(Pos red, Pos blue, int moves) {
        this.red = red;
        this.blue = blue;
        this.moves = moves;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return red.y == state.red.y &&
               red.x == state.red.x &&
               blue.y == state.blue.y &&
               blue.x == state.blue.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red.y, red.x, blue.y, blue.x);
    }
}

public class Main {
    static int N, M;
    static char[][] board;

    static State initBoard() throws IOException {
        N = nextInt();
        M = nextInt();
        board = new char[N][M];
        Pos red = null, blue = null;

        for (int i = 0; i < N; i++) {
            String line = nextLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    red = new Pos(i, j);
                    board[i][j] = '.';
                }
                else if (board[i][j] == 'B') {
                    blue = new Pos(i, j);
                    board[i][j] = '.';
                }
            }
        }

        return new State(red, blue, 1);
    }

    static Pos move(int y, int x, int dy, int dx) {
        int count = 0;
        while (board[y + dy][x + dx] != '#' && board[y][x] != 'O') {
            y += dy;
            x += dx;
            count++;
        }
        return new Pos(y, x, count);
    }

    static int BFS(State state, int[][] dirs) {
        // 큐 초기화
        Queue<State> q = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        q.offer(state);
        visited.add(state);

        while (!q.isEmpty()) {
            State current = q.poll();
            Pos red = current.red;
            Pos blue = current.blue;
            int moves = current.moves;

            for (int[] dir : dirs) {
                Pos bluePos = move(blue.y, blue.x, dir[0], dir[1]);
                int nBy = bluePos.y, nBx = bluePos.x, bCnt = bluePos.cnt;

                Pos redPos = move(red.y, red.x, dir[0], dir[1]);
                int nRy = redPos.y, nRx = redPos.x, rCnt = redPos.cnt;

                // 파란구슬 실패
                if (board[nBy][nBx] == 'O') continue;

                // 빨간구슬 성공
                if (board[nRy][nRx] == 'O') return moves;

                // 위치가 겹치면 더 많이 움직인걸 뒤로
                if (nRy == nBy && nRx == nBx) {
                    if (rCnt > bCnt) {
                        nRy -= dir[0];
                        nRx -= dir[1];
                    } else {
                        nBy -= dir[0];
                        nBx -= dir[1];
                    }
                }
                
                // 큐에 추가
                State nextState = new State(new Pos(nRy, nRx), new Pos(nBy, nBx), moves + 1);
                if (!visited.contains(nextState)) {
                    q.offer(nextState);
                    visited.add(nextState);
                }                
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // 미로 초기화
        State state = initBoard();

        // 방향 초기화
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        // BFS
        int result = BFS(state, dirs);

        System.out.println(result);
    }

    static int nextInt() throws IOException {
        int n = 0;
        int c;
        while((c = System.in.read()) <= 32); // 탭 9, 개행 10, 공백 32
        do {
            n = n * 10 + (c - '0'); // 현재 자리를 추가
        } while ((c = System.in.read()) > 32); // 구분자 전까지
        return n;
    }

    static String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while((c = System.in.read()) <= 32); // 탭 9, 개행 10, 공백 32
        do {
            sb.append((char)c); // 현재 자리를 추가가
        } while ((c = System.in.read()) > 10); // 개행 전까지
        return sb.toString();
    }    
}
```

### 성능 요약

시간: 116 ms

메모리: 14316 KB

### 제출 일자

2024년 12월 15일 (일) 01:12

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

