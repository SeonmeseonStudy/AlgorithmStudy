n = int(input())
building = [
    tuple(map(int, input().split()))
    for _ in range(n)
]

maxheight = max(y for x, y in building) # 가장 높은 빌딩 높이

# 빌딩 위치 기준으로
building.sort(key= lambda x: x[0])

# 왼쪽
area = 0
bpos, bheight = building[0]
start = 0
count = 0
for i in range(1, n):
    pos, height = building[i]

    if height >= bheight:
        area += (pos-bpos) * bheight
        bpos, bheight = pos, height
    else:
        continue

    if height == maxheight:
        start = i
        break

leftmax = start
rightmax = start

# 오른쪽
for i in range(start, n):
    pos, height = building[i]

    if height == maxheight:
        rightmax = i
        
area += (building[rightmax][0] - building[leftmax][0] + 1) * maxheight
bpos, bheight = building[n-1]

for i in range(n-2, rightmax-1, -1):
    pos, height = building[i]

    if bheight <= height:
        area += (bpos-pos) * bheight
        bpos, bheight = pos, height

print(area)