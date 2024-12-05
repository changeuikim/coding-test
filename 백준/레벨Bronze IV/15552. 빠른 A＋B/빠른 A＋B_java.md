# [Bronze IV] [빠른 A+B](https://www.acmicpc.net/problem/15552) - 15552 

NaN구현, 사칙연산, 수학

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        
        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 732 ms

메모리: 220620 KB

### 제출 일자

2024년 12월 05일 (목) 16:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

