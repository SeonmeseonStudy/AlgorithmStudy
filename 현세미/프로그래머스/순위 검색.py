from collections import defaultdict
from bisect import bisect_left

def solution(info, query):
    data = defaultdict(list)

    for i in info:
        parts = i.split()
        score = int(parts[-1])
        attrs = parts[:-1]

        # 모든 조건 조합 생성 
        for a in [attrs[0], "-"]:
            for b in [attrs[1], "-"]:
                for c in [attrs[2], "-"]:
                    for d in [attrs[3], "-"]:
                        key = f"{a}-{b}-{c}-{d}"
                        data[key].append(score)

    for key in data:
        data[key].sort()

    results = []
    for q in query:
        parts = q.replace(" and ", " ").split()
        key = "-".join(parts[:-1])
        score = int(parts[-1])

        scores = data[key]
        idx = bisect_left(scores, score)
        results.append(len(scores) - idx)

    return results
