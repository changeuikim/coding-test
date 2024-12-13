import java.io.*;
import java.util.*;

class Pair {
    int y, x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
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

    public static void main(String[] args) throws IOException {
        // 미로 초기화
        int M = nextInt();
        int N = nextInt();

        String[] board = new String[N];

        for (int i = 0; i < N; i++) {
            board[i] = nextLine();
        }

        // 방향 설정
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        // 거리배열 초기화
        int[][] dist = new int[N][M];
        Arrays.stream(dist).forEach(row -> Arrays.fill(row, -1));
        dist[0][0] = 0;

        // 덱 초기화
        Deque<Pair> dq = new ArrayDeque<>();
        dq.offerLast(new Pair(0, 0));

        // 0-1 BFS
        while (!dq.isEmpty()) {
            Pair p = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i], nx = p.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (dist[ny][nx] == -1) {
                        if (board[ny].charAt(nx) == '0') {
                            dq.offerFirst(new Pair(ny, nx));
                            dist[ny][nx] = dist[p.y][p.x];
                          } else if (board[ny].charAt(nx) == '1') {
                            dq.offerLast(new Pair(ny, nx));
                            dist[ny][nx] = dist[p.y][p.x] + 1;
                          }                        
                    }
                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}