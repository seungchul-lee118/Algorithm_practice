n = int(input())

for i in range(1, n + 1):
    str = ' '* (n - i)
    for j in range(1, 2*i):
        str += '*' if j % 2 == 1 else ' '
    print(str)