def solution(clothes):

    clothes_list = {}

    for name, kind in clothes:
        if kind in clothes_list:
            clothes_list[kind] += 1
        else:
            clothes_list[kind] = 1

    ootd = 1
    for count in clothes_list.values():
        ootd *= (count + 1)

    return ootd -1
