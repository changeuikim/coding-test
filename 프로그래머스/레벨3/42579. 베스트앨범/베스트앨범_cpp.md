# [Lv.3] [베스트앨범](https://programmers.co.kr/) - 42579 

### 구분

코딩테스트 연습 > 해시

## C++ 문제풀이

```cpp
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    unordered_map<string, int> genreMap;
    unordered_map<string, vector<pair<int, int>>> songMap;

    for (int i = 0; i < genres.size(); i++) {
        genreMap[genres[i]] += plays[i];
        songMap[genres[i]].emplace_back(plays[i], i);
    }

    vector<string> sortedGenres;
    for (const auto& g : genreMap) {
        sortedGenres.push_back(g.first);
    }
    sort(sortedGenres.begin(), sortedGenres.end(), [&](const string& a, const string& b) {
        return genreMap[b] < genreMap[a];
    });

    vector<int> result;
    for (const string& genre : sortedGenres) {
        auto& songs = songMap[genre];
        sort(songs.begin(), songs.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first == b.first ? a.second < b.second : a.first > b.first;
        });
        for (int i = 0; i < min(2, (int)songs.size()); i++) {
            result.push_back(songs[i].second);
        }
    }

    return result;
}

```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 4.22 MB

2. 시간: 0.04 ms, 메모리: 4.02 MB
3. 시간: 0.03 ms, 메모리: 4.27 MB
4. 시간: 0.03 ms, 메모리: 4.22 MB
5. 시간: 0.03 ms, 메모리: 4.14 MB

### 제출 일자

2024년 12월 07일 (토) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges