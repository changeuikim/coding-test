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