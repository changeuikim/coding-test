# [Lv.2] [[3차] 방금그곡](https://programmers.co.kr/) - 17683 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.*;

class Solution {
    private String noteConverter(String melody) {
        StringBuilder sb = new StringBuilder();
        for (char note : melody.toCharArray()) {
            if (note == '#') {
                int lastIdx = sb.length() - 1;
                char newNote = Character.toLowerCase(sb.charAt(lastIdx));
                sb.setCharAt(lastIdx, newNote);                
            } else {
                sb.append(note);
            }
        }
        return sb.toString();
    }

    private int minuteConverter(String timeString) {
        String[] parts = timeString.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return 60 * hour + minute;
    }

    private String melodyRepeater(String melody, int playTime) {
        return melody.repeat(playTime / melody.length() + 1).substring(0, playTime);
    }    

    public String solution(String m, String[] musicinfos) {
        String convM = noteConverter(m);
        String resultTitle = "(None)";
        int resultTime = 0;

        for (String musicinfo : musicinfos) {
            String[] parts = musicinfo.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = parts[3];

            int playTime = minuteConverter(end) - minuteConverter(start);
            String convMelody = noteConverter(melody);
            String repeatedMelody = melodyRepeater(convMelody, playTime);

            if (repeatedMelody.contains(convM) && playTime > resultTime) {
                resultTitle = title;
                resultTime = playTime;
            }
        }

        return resultTitle;
    }
}
```

### 성능 요약

1. 시간: 5.57 ms, 메모리: 79.2 MB

2. 시간: 4.06 ms, 메모리: 87 MB
3. 시간: 0.98 ms, 메모리: 75.5 MB
4. 시간: 0.65 ms, 메모리: 83.5 MB
5. 시간: 0.61 ms, 메모리: 77.3 MB

### 제출 일자

2024년 12월 10일 (화) 17:42

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges