import java.io.*;
import java.util.*;

class Pos {
    int y, x, count;
    
    Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }

    Pos(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}

class State {
    Pos red, blue;
    int move;

    State(Pos red, Pos blue, int move) {
        this.red = red;
        this.blue = blue;
        this.move = move;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return this.red.y == state.red.y &&
               this.red.x == state.red.x &&
               this.blue.y == state.blue.y &&
               this.blue.x == state.blue.x;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(red.y, red.x, blue.y, blue.x);
    }
}

class BFS {
    private Pos roll(int y, int x, int dy, int dx, char[][] board) {
        int count = 0;
        // 벽에 부딪치기 전까지, 구멍에 빠질때까지
        while (board[y + dy][x + dx] != '#' && board[y][x] != 'O') {
            y += dy;
            x += dx;
            count += 1;
        }
        return new Pos(y, x, count);
    }

    public int solution() throws IOException {
        // 보드, 빨강, 파랑 초기화
        int N = nextInt(), M = nextInt();
        char[][] board = new char[N][M];
        Pos red = null, blue = null;

        for (int i = 0; i < N; i++) {
            char[] row = nextLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (row[j] == 'R') {
                    red = new Pos(i, j);
                    row[j] = '.';
                } else if (row[j] == 'B') {
                    blue = new Pos(i, j);
                    row[j] = '.';
                }
            }

            board[i] = row;
        }

        // 방향 : 좌우상하
        int[] dy = { 0, 0, -1, 1};
        int[] dx = { -1, 1, 0, 0};

        // 큐, 방문 초기화
        Queue<State> q = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State inits = new State(red, blue, 1);
        q.offer(inits);
        visited.add(inits);

        // BFS
        while (!q.isEmpty()) {
            State curState = q.poll();

            Pos cr = curState.red;
            Pos cb = curState.blue;
            int move = curState.move;
        
            // 좌우상하 굴리기
            for (int i = 0; i < 4; i++) {
                Pos nr = roll(cr.y, cr.x, dy[i], dx[i], board);
                Pos nb = roll(cb.y, cb.x, dy[i], dx[i], board);
        
                // 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
                if (board[nb.y][nb.x] == 'O') continue;
        
                // 빨간 구슬이 구멍에 빠지면 성공
                if (board[nr.y][nr.x] == 'O') return move;
        
                // 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다
                if (nr.y == nb.y && nr.x == nb.x) {
                // 빨간 구슬을 뒤로
                if (nr.count > nb.count) {
                    nr.y -= dy[i];
                    nr.x -= dx[i];
                }
                // 파란 구슬을 뒤로
                else {
                    nb.y -= dy[i];
                    nb.x -= dx[i];
                }
                }
        
                // 큐에 추가
                State nxtState = new State(nr, nb, move + 1);
                if (visited.contains(nxtState)) continue;
        
                q.offer(nxtState);
                visited.add(nxtState);
            }
          }
        
        return -1;
    }

    int nextInt() throws IOException {
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32); // 탭 9, 개행 10, 공백 32
        do {
            n = n * 10 + (c - '0'); // 한자리씩 추가
        } while ((c = System.in.read()) > 32); // 구분자 전까지
        return n;
    }

    String nextLine() throws IOException {
        char[] buf = new char[10];
        int idx = 0;
        int c;
        while ((c = System.in.read()) <= 32); // 탭 9, 개행 10, 공백 32
        do {
            buf[idx++] = (char)c; // 한글자씩 추가
        } while ((c = System.in.read()) > 10); // 개행 전까지지
        return new String(buf, 0, idx);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new BFS().solution());
    }
}