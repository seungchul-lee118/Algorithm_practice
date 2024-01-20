N, K = map(int, input().split())

coins = []
count = 0

for i in range(N):
    coins.append(int(input()))

for coin in sorted(coins, reverse=True):
    count += K // coin
    K %= coin

print(count)