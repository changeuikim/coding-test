# [Bronze V] [시험 성적](https://www.acmicpc.net/problem/9498) - 9498 

NaN구현

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <iostream>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int score;
  cin >> score;

  if (score >= 90 && score <= 100) cout << 'A';
  else if (score >= 80) cout << 'B';
  else if (score >= 70) cout << 'C';
  else if (score >= 60) cout << 'D';
  else cout << 'F';
}
```

### 성능 요약

시간: 0 ms

메모리: 2208 KB

### 제출 일자

2024년 12월 05일 (목) 11:13

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

