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
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        
        // 배열 A
        while (N-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            if (a < X) result.append(a).append(" ");
        }

        System.out.println(result.toString());
    }
}
```

### 성능 요약

시간: 136 ms

메모리: 15240 KB

### 제출 일자

2024년 12월 05일 (목) 10:33

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

