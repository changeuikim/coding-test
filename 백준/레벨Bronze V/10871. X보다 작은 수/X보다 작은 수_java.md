# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 처리        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 결과 처리
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value < X) sb.append(value).append(" ");
        }
            
        // 출력 처리
        System.out.println(sb.toString().trim());
    }
}
```

### 성능 요약

시간: 136 ms

메모리: 15376 KB

### 제출 일자

2024년 12월 02일 (월) 22:24

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

