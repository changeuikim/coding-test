from functools import cmp_to_key

def compare(x, y):
    left = x + y
    right = y + x
    
    if left > right:
        return -1
    elif left < right:
        return 1
    else:
        return 0

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=cmp_to_key(compare))
    return "0" if numbers[0] == "0" else "".join(numbers)