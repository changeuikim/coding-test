# [Silver III] [두 수의 합](https://www.acmicpc.net/problem/3273) - 3273 

NaN정렬, 두 포인터

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());                
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        boolean[] occur = new boolean[2000001];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (x - arr[i] > 0 && occur[x - arr[i]]) cnt++;
            occur[arr[i]] = true;
        }

        System.out.println(cnt);
    }
}
```

### 성능 요약

시간: 248 ms

메모리: 27048 KB

### 제출 일자

2024년 12월 06일 (금) 23:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

