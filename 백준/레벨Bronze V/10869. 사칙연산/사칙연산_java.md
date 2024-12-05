# [Bronze V] [사칙연산](https://www.acmicpc.net/problem/10869) - 10869 

NaN구현, 사칙연산, 수학

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }
}
```

### 성능 요약

시간: 104 ms

메모리: 14148 KB

### 제출 일자

2024년 12월 05일 (목) 10:57

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

