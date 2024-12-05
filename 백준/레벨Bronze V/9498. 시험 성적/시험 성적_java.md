# [Bronze V] [시험 성적](https://www.acmicpc.net/problem/9498) - 9498 

NaN구현

## Java 11 문제풀이

```Java 11
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine().trim());

        char result;
        if (score >= 90 && score <= 100) result = 'A';
        else if (score >= 80) result = 'B';
        else if (score >= 70) result = 'C';
        else if (score >= 60) result = 'D';
        else result = 'F';

        System.out.println(result);
    }
}
```

### 성능 요약

시간: 104 ms

메모리: 14212 KB

### 제출 일자

2024년 12월 05일 (목) 11:11

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

