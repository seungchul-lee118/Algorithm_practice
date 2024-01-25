import sys
import heapq

input = sys.stdin.readline

n, m = map(int, input().split())
numbers = []
list(map(lambda x: heapq.heappush(numbers, int(x)), input().split()))

for _ in range(m):
    num1 = heapq.heappop(numbers)
    num2 = heapq.heappop(numbers)
    heapq.heappush(numbers, num1 + num2)
    heapq.heappush(numbers, num1 + num2)

print(sum(numbers))