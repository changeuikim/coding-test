# [Lv.3] [베스트앨범](https://programmers.co.kr/) - 42579 

### 구분

코딩테스트 연습 > 해시

## JavaScript 문제풀이

```js
function solution(genres, plays) {
    const genreMap = new Map();
    const songMap = new Map();

    genres.forEach((genre, i) => {
        genreMap.set(genre, (genreMap.get(genre) || 0) + plays[i]);
        if (!songMap.has(genre)) songMap.set(genre, []);
        songMap.get(genre).push([plays[i], i]);
    });

    const sortedGenres = Array.from(genreMap.keys()).sort((a, b) => genreMap.get(b) - genreMap.get(a));

    const result = [];
    sortedGenres.forEach((genre) => {
        const sortedSongs = songMap.get(genre).sort((a, b) => b[0] - a[0] || a[1] - b[1]);
        result.push(...sortedSongs.slice(0, 2).map(song => song[1]));
    });

    return result;
}
```

### 성능 요약

1. 시간: 0.43 ms, 메모리: 33.5 MB

2. 시간: 0.30 ms, 메모리: 33.6 MB
3. 시간: 0.30 ms, 메모리: 33.5 MB
4. 시간: 0.29 ms, 메모리: 33.5 MB
5. 시간: 0.29 ms, 메모리: 33.3 MB

### 제출 일자

2024년 12월 07일 (토) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges