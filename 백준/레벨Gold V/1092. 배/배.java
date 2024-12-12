import java.io.*;
import java.util.*;

public class Main {
    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        int N = Integer.parseInt(br.readLine().trim());
        
        int[] cranes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine().trim());
        
        int[] boxes = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        // 내림차순 정렬
        Arrays.sort(cranes);
        reverse(cranes);
        Arrays.sort(boxes);
        reverse(boxes);

        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
        } else {
            // 최소 시간 : 모든 박스 / 모든 크레인
            int maxTime = (M + N - 1) / N;
            int bIdx = 0;

            for (int cIdx = 1; cIdx < N; cIdx++) {
                // 현재 crane이 들 수 있는 가장 큰 box를 확인
                while (bIdx < M && cranes[cIdx] < boxes[bIdx]) {
                    bIdx++;
                }

                // 현재 시간 : 박스 수 / 크레인 수
                int curTime = (bIdx + cIdx - 1) / cIdx;
                maxTime = Math.max(maxTime, curTime);

                if (bIdx == M) break;
            }

            System.out.println(maxTime);
        }
    }
}