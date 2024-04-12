from collections import deque
import sys
moves = [[1,0],[0,1],[-1,0],[0,-1]]
minMoves = -2

def BFS(maps,start):
  Q = deque()
  for v in start:
    Q.append(v)
  while(Q):
    u = Q.popleft()
#    print("Where = ",u)
#    print(visited)
    for move in moves:
      x = u[1] + move[1]
      y = u[0] + move[0]
      if isValidMove(x,y,maps):
        Q.append((y,x))
        maps[y][x] = maps[u[0]][u[1]] + 1
  
  return

def isValidMove(x,y,maps):
  return (0 <= x < len(maps[0])) and (0 <= y < len(maps)) and (maps[y][x] == 0)

N,M = map(int,sys.stdin.readline().split())
#N,M = 1000,1000
maps = []
for k in range(M):
  maps.append(list(map(int,sys.stdin.readline().split())))
#  maps.append([0 for i in range(N)])
#maps[N-1][M-1] = 1
#L = [-1 for i in range(N-1)]
#L.append(0)
#maps[500] = L


startingPoints = []
for j in range(M):
  for i in range(N):
    if maps[j][i] == 1:
      startingPoints.append((j,i))

BFS(maps,startingPoints)

has_raw_tomato = False
for i in range(len(maps)):
  for j in range(len(maps[0])):
    if maps[i][j] == 0:
      has_raw_tomato = True
      break
    else:
      if maps[i][j] - 1 > minMoves:
        minMoves = maps[i][j] - 1

if has_raw_tomato:
  print(-1)
else:
  print(minMoves)

### BFS에서의 visited. Q의 원소끼리 서로 상호작용 할텐데, 문제가 없을 때만 쓰는 것인지?? ###
### visited를 Q에 넣을 때 바꿔줘야 하는 타당한 이유? dequeue할 때 바꿔주면 안되는 이유? ###

'''
2% 시간초과
3 3
1 1 1
1 1 1
1 1 0
'''