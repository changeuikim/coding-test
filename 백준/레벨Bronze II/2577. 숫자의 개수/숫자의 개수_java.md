# [Bronze II] [숫자의 개수](https://www.acmicpc.net/problem/2577) - 2577 

NaN사칙연산, 구현, 수학

## Java 11 문제풀이

```Java 11
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        int[] digits = new int[10];
        int number = A * B * C;

        while (number > 0) {
            digits[number % 10]++;
            number /= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int count : digits) {
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 100 ms

메모리: 14140 KB

### 제출 일자

2024년 12월 05일 (목) 19:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

