#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool compare(const string &x, const string &y) {
    return (x + y) > (y + x);
}

string solution(vector<int> numbers) {
    vector<string> numbers_vector;
    for (int num : numbers) {
        numbers_vector.push_back(to_string(num));
    }

    sort(numbers_vector.begin(), numbers_vector.end(), compare);

    string result = "";
    for (const string &num : numbers_vector) {
        result += num;
    }

    return result[0] == '0' ? "0" : result;
}