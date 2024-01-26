positions = [list(map(int, input().split())) for _ in range(4)]
matrix = [[0 for i in range(101)] for i in range(101)]
area = 0;
for position in positions:
    for x in range(position[0], position[2]):
        for y in range(position[1], position[3]):
            matrix[x][y] = 1

for x in matrix:
    area += x.count(1)
print(area)