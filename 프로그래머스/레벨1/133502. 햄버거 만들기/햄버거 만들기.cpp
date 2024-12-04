#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    vector<int>stack(ingredient.size(),0);
    int top = -1;
    int result = 0;
    
    for (int item : ingredient) {
        stack[++top] = item;

        if (top >= 3) {
            if (stack[top] == 1 && stack[top-1] == 3 && stack[top-2] == 2 && stack[top-3] == 1) {
                top -= 4;
                result++;
            }
        }
    }

    return result;    
}