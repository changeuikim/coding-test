# [Lv.2] [[3차] 파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=java) - 17686 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {
    static class ParsedFile {
        String head;
        int number;
        String original;

        ParsedFile(String head, int number, String original) {
            this.head = head;
            this.number = number;
            this.original = original;
        }
    }

    public static String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([a-zA-Z\\-\\. ]+)(\\d{1,5})");
        List<ParsedFile> parsedFiles = new ArrayList<>();

        for (String file : files) {
            Matcher matcher = pattern.matcher(file);
            if (matcher.find()) {
                String head = matcher.group(1);
                int number = Integer.parseInt(matcher.group(2));
                parsedFiles.add(new ParsedFile(head, number, file));
            }
        }

        parsedFiles.sort((f1, f2) -> {
            int headComparison = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            if (headComparison != 0) {
                return headComparison;
            }
            return Integer.compare(f1.number, f2.number);
        });

        String[] result = new String[parsedFiles.size()];
        for (int i = 0; i < parsedFiles.size(); i++) {
            result[i] = parsedFiles.get(i).original;
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 22.42 ms, 메모리: 95 MB

2. 시간: 20.60 ms, 메모리: 79.1 MB
3. 시간: 15.17 ms, 메모리: 83.8 MB
4. 시간: 13.95 ms, 메모리: 89.8 MB
5. 시간: 13.91 ms, 메모리: 95.8 MB

### 제출 일자

2024년 11월 26일 (화) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges