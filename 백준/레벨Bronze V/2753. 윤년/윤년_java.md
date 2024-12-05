# [Bronze V] [윤년](https://www.acmicpc.net/problem/2753) - 2753 

NaN구현, 사칙연산, 수학

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year = Integer.parseInt(st.nextToken());

        boolean result = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        System.out.println(result ? 1 : 0);
    }
}
```

### 성능 요약

시간: 100 ms

메모리: 14288 KB

### 제출 일자

2024년 12월 05일 (목) 13:09

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

