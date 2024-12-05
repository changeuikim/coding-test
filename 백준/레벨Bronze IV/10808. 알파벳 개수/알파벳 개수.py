word = input().rstrip()
alphabet = [0] * 26
ascii_a = ord('a')

for ch in word:
    alphabet[ord(ch) - ascii_a] += 1

print(*alphabet)