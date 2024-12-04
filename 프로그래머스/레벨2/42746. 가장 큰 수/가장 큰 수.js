const compare = (x, y) => {
    const left = x + y;
    const right = y + x;
    
    if (left > right) return -1;
    else if (left < right) return 1;
    else return 0;
}

function solution(numbers) {
    const result = numbers.map(String).sort(compare);
    return result[0] === "0" ? "0" : result.join("");
}