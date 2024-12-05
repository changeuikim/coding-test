# [Bronze IV] [알파벳 개수](https://www.acmicpc.net/problem/10808) - 10808 

NaN구현, 문자열

## Java 11 문제풀이

```Java 11
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        int[] alphabet = new int[26];

        for (char ch : word.toCharArray()) {
            alphabet[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : alphabet) {
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 116 ms

메모리: 14288 KB

### 제출 일자

2024년 12월 05일 (목) 16:17

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

