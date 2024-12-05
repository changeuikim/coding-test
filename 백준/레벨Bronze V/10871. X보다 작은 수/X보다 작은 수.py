N, X = map(int, input().split())
A = map(int, input().split())

print(" ".join(str(a) for a in A if a < X))