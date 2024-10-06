n = int(input())
wine = [
    int(input()) for _ in range(n)
]

result = 0
if n == 1:
    result = wine[0]
elif n == 2:
    result = sum(wine)
else:
    wineList = [0] * (n+1)
    wineList[0] = wine[0]
    wineList[1] = wine[0] + wine[1]
    wineList[2] = max(wineList[1], wine[1]+wine[2], wine[0]+wine[2])
    # 점화식
    # 3개일때는 2개씩 비교해서 제일 큰값 : 가지수 3개
    # 3개보다 클때는 예를들어 4개인 경우 아래 경우 중 제일 큰 값
    # 1. 3개일때 값(1 + 2 + 3번 와인)
    # 2. 4번 와인 + 2개일때 값(1 + 2번 와인)
    # 3. 1개일때 값(1번 와인) + 3번 와인 + 4번 와인
    
    for i in range(3, n):
        wineList[i] = max(wineList[i-1], wine[i]+wine[i-1]+wineList[i-3], wine[i]+wineList[i-2])

    result = wineList[n-1]
print(result)