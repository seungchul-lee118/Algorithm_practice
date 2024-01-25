import sys

input = sys.stdin.readline

n = int(input())
lines = [list(map(int, input().split())) for _ in range(n)]
lines.sort(key=lambda x: x[0])
result = []
answer = 0

for line in lines:
    if not result:
        result.append(line)
        continue
    if line[0] <= result[-1][1] < line[1]:
        result[-1][1] = line[1]
    elif line[0] > result[-1][1]:
        result.append(line)

for i in result:
    answer += i[1] - i[0]
print(answer)