N = int(input())
ropes = [int(input()) for _ in range(N)]
ropes.sort()
weights = []

for idx in range(N):
    weights.append(ropes[idx] * (N - idx))
print(max(weights))