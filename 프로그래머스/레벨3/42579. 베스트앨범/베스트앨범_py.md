# [Lv.3] [베스트앨범](https://programmers.co.kr/) - 42579 

### 구분

코딩테스트 연습 > 해시

## Python 문제풀이

```py
from collections import defaultdict

def solution(genres, plays):
    genre_map = defaultdict(int)
    song_map = defaultdict(list)

    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_map[genre] += play
        song_map[genre].append((play, i))

    sorted_genres = sorted(genre_map.keys(), key=lambda x: genre_map[x], reverse=True)

    result = []
    for genre in sorted_genres:
        sorted_songs = sorted(song_map[genre], key=lambda x: (-x[0], x[1]))
        result.extend([song[1] for song in sorted_songs[:2]])

    return result
```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 10.2 MB

2. 시간: 0.07 ms, 메모리: 10.3 MB
3. 시간: 0.07 ms, 메모리: 10.3 MB
4. 시간: 0.07 ms, 메모리: 10.3 MB
5. 시간: 0.06 ms, 메모리: 10.2 MB

### 제출 일자

2024년 12월 07일 (토) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges