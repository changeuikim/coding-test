# [Lv.3] [베스트앨범](https://programmers.co.kr/) - 42579 

### 구분

코딩테스트 연습 > 해시

## Java 문제풀이

```java
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            if (!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new ArrayList<>());
            }
            songMap.get(genres[i]).add(new int[]{plays[i], i});
        }

        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        sortedGenres.sort((a, b) -> genreMap.get(b) - genreMap.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> sortedSongs = songMap.get(genre);
            sortedSongs.sort((a, b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
            for (int i = 0; i < Math.min(2, sortedSongs.size()); i++) {
                result.add(sortedSongs.get(i)[1]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

### 성능 요약

1. 시간: 10.96 ms, 메모리: 88.5 MB

2. 시간: 6.70 ms, 메모리: 74.4 MB
3. 시간: 4.77 ms, 메모리: 76.4 MB
4. 시간: 4.63 ms, 메모리: 83 MB
5. 시간: 4.30 ms, 메모리: 80 MB

### 제출 일자

2024년 12월 07일 (토) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges