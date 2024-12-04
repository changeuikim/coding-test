function solution(ingredient) {
    const stack = new Array(ingredient.length).fill(0);
    let top = -1;
    let result = 0;
    
    for (const item of ingredient) {
        stack[++top] = item;
        
        if (top >= 3) {
            if (stack[top] === 1 && stack[top-1] === 3 && stack[top-2] === 2 && stack[top-3] === 1) {
                top -= 4;
                result++;
            }
        }
    }
    
    return result;
}