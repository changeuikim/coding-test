# [Bronze IV] [알파벳 개수](https://www.acmicpc.net/problem/10808) - 10808 

NaN구현, 문자열

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int alphabet[26];
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string word;
  cin >> word;

  for (auto ch : word) {
    alphabet[ch - 'a']++;
  }
  
  for (auto count : alphabet) {
    cout << count << " ";
  }
}
```

### 성능 요약

시간: 0 ms

메모리: 2216 KB

### 제출 일자

2024년 12월 05일 (목) 16:18

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

