def solution(s):
    answer = []
    count = dict()
    numbers = s.replace("{", "").replace("}","").split(",")
    
    for num in numbers:
        if int(num) in count:
            count[int(num)] += 1
        else:
            count[int(num)] = 1

    # count 딕셔너리 정렬
    # count.items로 하면 키값 기준 정렬, key를 사용해서 2번째 값 사용해 정렬, 내림차순 정렬
    # 반환값이 [2, 4] 2차원 배열이므로 key 값만 저장
    answer = [x[0] for x in sorted(count.items(), key=lambda x: x[1], reverse=True)]
    
    return answer