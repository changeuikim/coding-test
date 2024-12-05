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