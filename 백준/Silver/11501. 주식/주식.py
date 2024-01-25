import sys

input = sys.stdin.readline

T = int(input())
n_list = []
numbers_list = []
max_list = []

for _ in range(T):
    n_list.append(int(input()))
    numbers_list.append(list(map(int, input().split())))
    max_list.append([])

for idx in range(T):
    n = n_list[idx]
    max_list[idx] = [0] * n
    max_num = 0
    for i in range(n - 1, -1, -1):
        max_num = max(numbers_list[idx][i], max_num)
        max_list[idx][i] = max_num

for idx in range(T):
    n = n_list[idx]
    numbers = numbers_list[idx]
    result = 0
    for i in range(n):
        result += (max_list[idx][i] - numbers[i])
    print(result)