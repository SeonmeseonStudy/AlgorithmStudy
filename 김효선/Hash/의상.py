def solution(clothes):
    from collections import Counter
    from functools import reduce

    clothes_counter = Counter([kind for _, kind in clothes])
    
    # all_combinations = reduce(lambda x, y: x * (y + 1), clothes_counter.values(), 1)
    all_combinations = 1
    for count in clothes_counter.values():
        all_combinations *= (count + 1)

    return all_combinations - 1