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
        int index;

        ParsedFile(String head, String number, int index) {
            this.head = head.toLowerCase();
            this.number = Integer.parseInt(number);
            this.index = index;
        }
    }

    public static String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([a-zA-Z\\-\\. ]+)(\\d{1,5})");
        List<ParsedFile> parsedFiles = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            Matcher matcher = pattern.matcher(files[i]);
            if (matcher.find()) {
                String head = matcher.group(1);
                String number = matcher.group(2);
                parsedFiles.add(new ParsedFile(head, number, i));
            }
        }

        parsedFiles.sort((f1, f2) -> {
            int headComparison = f1.head.compareTo(f2.head);
            if (headComparison != 0) {
                return headComparison;
            }
            int numberComparison = Integer.compare(f1.number, f2.number);
            if (numberComparison != 0) {
                return numberComparison;
            }
            return Integer.compare(f1.index, f2.index);
        });

        String[] result = new String[files.length];
        for (int i = 0; i < parsedFiles.size(); i++) {
            result[i] = files[parsedFiles.get(i).index];
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 14.26 ms, 메모리: 74.1 MB

2. 시간: 12.06 ms, 메모리: 88.3 MB
3. 시간: 11.20 ms, 메모리: 92.8 MB
4. 시간: 10.75 ms, 메모리: 83.9 MB
5. 시간: 10.59 ms, 메모리: 82.8 MB

### 제출 일자

2024년 11월 27일 (수) 00:44

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges