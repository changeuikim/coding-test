# [Bronze II] [숫자의 개수](https://www.acmicpc.net/problem/2577) - 2577 

NaN사칙연산, 구현, 수학

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int digits[10];
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  int A, B, C;
  cin >> A >> B >> C;

  int number = A * B * C;

  while (number) {
    digits[number % 10]++;
    number /= 10;
  }

  for (int count : digits)
    cout << count << '\n';
}
```

### 성능 요약

시간: 0 ms

메모리: 2212 KB

### 제출 일자

2024년 12월 05일 (목) 19:50

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

