# [Gold V] [배](https://www.acmicpc.net/problem/1092) - 1092 

NaN그리디 알고리즘, 정렬

## Java 11 문제풀이

```Java 11
/*
    골드5 - 1092번: 배 https://www.acmicpc.net/problem/1092
 */

import java.io.*;
import java.util.*;

class Solution {
    public void simulation() throws IOException {
        // 크레인 초기화
        int N = nextInt();
        int[] cranes = new int[N];
        for (int i = 0; i < N; i++) cranes[i] = nextInt();

        // 박스 초기화
        int M = nextInt();
        int[] boxes = new int[M];
        for (int i = 0; i < M; i++) boxes[i] = nextInt();

        // 원시타입은 오름차순 정렬
        Arrays.sort(cranes);
        reverse(cranes);
        Arrays.sort(boxes);
        reverse(boxes);

        // 가장 무거운 박스를 처리할 수 없는 경우
        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
        }
        // 매 턴을 시뮬레이션
        else {
            boolean[] done = new boolean[M];
            int turn = 0;
            int left = M;
    
            while (left > 0) {
                // 크레인 i, 박스 j
                int i = 0;
                for (int j = 0; j < M && i < N; j++) {
                    if (done[j]) continue;
    
                    if (cranes[i] >= boxes[j]) {
                        done[j] = true;
                        left--;
                        i++;
                    }
                }
                turn++;
            }
    
            System.out.println(turn);
        }
    }
    
    public void calculation() throws IOException {
        // 크레인 초기화
        int N = nextInt();
        int[] cranes = new int[N];
        for (int i = 0; i < N; i++) cranes[i] = nextInt();

        // 박스 초기화
        int M = nextInt();
        int[] boxes = new int[M];
        for (int i = 0; i < M; i++) boxes[i] = nextInt();

        // 원시타입은 오름차순 정렬
        Arrays.sort(cranes);
        reverse(cranes);
        Arrays.sort(boxes);
        reverse(boxes);

        // 가장 무거운 박스를 처리할 수 없는 경우
        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
        }
        // (특정 구간의 무게 박스 M개) / (가능한 크레인 N대)를 올림
        else {
            // 최소 시간 : 모든 박스를 모든 크레인이 옮길 수 있다.
            int maxTime = (M + N - 1) / N;

            // 크레인 i, 박스 j
            int j = 0;            
            for (int i = 1; i < N; i++) {
                // 현재 크레인 i 이상이 들 수 있는 박스 j를 탐색
                while (j < M && cranes[i] < boxes[j]) j++;

                // 현재 범위의 박스는 현재 범위의 크레인이 옮길 수 있다.
                int curTime = (i + j - 1) / i;
                maxTime = Math.max(maxTime, curTime);

                // 모든 박스를 계산했으면 종료
                if (j == M) break;
            }
            
            System.out.println(maxTime);
        }        
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }        
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException  {
        new Solution().calculation();
    }
}
```

### 성능 요약

시간: 108 ms

메모리: 14324 KB

### 제출 일자

2024년 12월 18일 (수) 15:07

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

