import heapq
import sys

N = int(input())

lectures = []
rooms = []

for i in range(N):
    lectures.append(list(map(int, sys.stdin.readline().split())))

lectures.sort(key=lambda lecture: lecture[0])
for lecture in lectures:
    if not rooms:
        heapq.heappush(rooms, lecture[1])
        continue
    if lecture[0] >= rooms[0]:
        heapq.heappop(rooms)
        heapq.heappush(rooms, lecture[1])
    else:
        heapq.heappush(rooms, lecture[1])

print(len(rooms))