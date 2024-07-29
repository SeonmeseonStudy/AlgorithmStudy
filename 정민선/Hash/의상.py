from collections import Counter
def solution(clothes):
    answer = 1
    total = []
    for c in clothes:
        name, category = c
        total.append(category)
    total = Counter(total) # Counter 함수로 빈도값 구하기 얼굴 몇개, 상의 몇개 등등 카테고리 별로 개수 세기
    
    for t in total:
        answer *= total[t]+1 # 경우의수는 곱해서 구하니까 그리고 안입는 경우 포함
    
    return answer-1 # 처음에 곱하기 위해서 1로 선언했으니까 다시 빼기