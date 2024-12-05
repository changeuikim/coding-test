from sys import stdin

input = stdin.readline
T = int(input())

for _ in range(T):
    a, b = map(int, input().split())
    print(a+b)