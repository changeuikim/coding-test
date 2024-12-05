# [Bronze V] [A+B](https://www.acmicpc.net/problem/1000) - 1000 

NaN구현, 사칙연산, 수학

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(A+B);
    }
}
```

### 성능 요약

시간: 100 ms

메모리: 14172 KB

### 제출 일자

2024년 12월 05일 (목) 10:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

