# [Gold IV] [비슷한 단어](https://www.acmicpc.net/problem/2179) - 2179 

NaN자료 구조, 해시를 사용한 집합과 맵, 정렬, 문자열

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

struct Word {
    string text;
    int index;

    Word(string t, int i) : text(t), index(i) {}
};

void solution() {
    int N;
    cin >> N;
    cin.ignore();

    vector<string> read(N + 1);
    for (int i = 1; i <= N; i++) {
        getline(cin, read[i]);
    }

    // 사전 순 정렬
    vector<Word> words;
    for (int i = 1; i <= N; i++) {
        words.emplace_back(read[i], i);
    }
    sort(words.begin(), words.end(), [](const Word& a, const Word& b) {
        return a.text < b.text;
    });

    // 인접 글자 간 LCP 처리
    int maxLen = 0;
    set<pair<int, string>> result;

    for (int i = 0; i < words.size() - 1; i++) {
        string pre = words[i].text;
        int preIdx = words[i].index;

        string nxt = words[i + 1].text;
        int nxtIdx = words[i + 1].index;

        int size = min(pre.size(), nxt.size());
        int curLen = 0;

        for (int j = 0; j < size; j++) {
            if (pre[j] == nxt[j]) curLen++;
            else break;
        }

        // LCP 갱신
        if (maxLen < curLen) {
            string lcp = pre.substr(0, curLen);
            maxLen = curLen;
            result.clear();
            result.emplace(preIdx, lcp);
            result.emplace(nxtIdx, lcp);
        } else if (maxLen == curLen) {
            string lcp = pre.substr(0, curLen);
            result.emplace(preIdx, lcp);
            result.emplace(nxtIdx, lcp);
        }
    }

    // 여러 개일 때에는 입력되는 순서대로(set은 정렬을 보장)
    vector<pair<int, string>> idxList(result.begin(), result.end());
    int idx1 = idxList[0].first;
    string common = idxList[0].second;

    int idx2 = -1;
    for (size_t i = 1; i < idxList.size(); i++) {
        if (idxList[i].second == common) {
            idx2 = idxList[i].first;
            break;
        }
    }

    cout << read[idx1] << '\n';
    cout << read[idx2] << '\n';
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
}
```

### 성능 요약

시간: 8 ms

메모리: 4816 KB

### 제출 일자

2024년 12월 17일 (화) 23:37

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

