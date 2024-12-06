n = int(input().rstrip())
arr = list(map(int, input().split()))
x = int(input().rstrip())

arr.sort()

cnt, i, j = 0, 0, n-1
while i < j:
    curr = arr[i] + arr[j]
    if curr < x:
        i += 1
    elif curr > x:
        j -= 1
    else:
        cnt += 1
        i += 1
        j -= 1

print(cnt)