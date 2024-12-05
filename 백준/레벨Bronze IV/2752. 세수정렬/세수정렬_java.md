# [Bronze IV] [세수정렬](https://www.acmicpc.net/problem/2752) - 2752 

NaN구현, 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 3;
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        StringBuilder result = new StringBuilder();
        for (int num : numbers) result.append(num).append(" ");

        System.out.println(result);
    }
}
```

### 성능 요약

시간: 104 ms

메모리: 14292 KB

### 제출 일자

2024년 12월 05일 (목) 11:55

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

