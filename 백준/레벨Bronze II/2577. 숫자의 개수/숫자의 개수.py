A = int(input())
B = int(input())
C = int(input())

digits = [0] * 10
number = A * B * C

while number:
    digits[number % 10] += 1
    number //= 10

for count in digits:
    print(count)