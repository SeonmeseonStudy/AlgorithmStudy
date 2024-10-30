# 프로그래머스 - 실패율
def solution(N, stages):
    stage_counts = [0] * (N + 2)
    for stage in stages:
        stage_counts[stage] += 1

    total = len(stages)
    ratio = []
    for i in range(1, N + 1):
        if total > 0:
            fail_rate = stage_counts[i] / total
            ratio.append((i, fail_rate))
            total -= stage_counts[i]
        else:
            ratio.append((i, 0))

    ratio.sort(key=lambda x: (-x[1], x[0]))
    return [stage[0] for stage in ratio]
