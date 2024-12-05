#include <iostream>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, X, a;
  cin >> N >> X;

  // 배열 A
  while(N--) {
    cin >> a;
    if (a < X) cout << a << " ";
  }
}