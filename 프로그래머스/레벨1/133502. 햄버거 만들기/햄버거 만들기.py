def solution(ingredient):
    stack = [0] * len(ingredient)
    top = -1
    result = 0
    
    for item in ingredient:
        top += 1
        stack[top] = item
        
        if top >= 3:
            if stack[top] == 1 and stack[top - 1] == 3 and stack[top - 2] == 2 and stack[top - 3] == 1:
                top -= 4
                result += 1
    
    return result