# [Bronze V] [개수 세기](https://www.acmicpc.net/problem/10807) - 10807 

NaN구현

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[201];
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int t = Integer.parseInt(st.nextToken());
            arr[t + 100]++;
        }
        int v = Integer.parseInt(br.readLine());
                
        System.out.println(arr[v + 100]);
    }
}
```

### 성능 요약

시간: 104 ms

메모리: 14196 KB

### 제출 일자

2024년 12월 07일 (토) 00:06

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

