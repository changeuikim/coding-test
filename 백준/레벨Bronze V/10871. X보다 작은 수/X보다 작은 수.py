from sys import stdin, stdout

lines = stdin.read().splitlines()

# 입력처리
N, X = map(int, lines[0].split())
A = map(int, lines[1].split())

# 출력처리
print(" ".join(str(a) for a in A if a < X))