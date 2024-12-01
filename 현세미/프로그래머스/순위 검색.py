def solution(info, query):
    result = []

    for q in query:
        q_parts = q.replace(" and ", " ").split()
        q_condition = q_parts[:-1]
        q_score = int(q_parts[-1])

        count = 0

        for i in info:
            i_parts = i.split()
            i_condition = i_parts[:-1]
            i_score = int(i_parts[-1])

            match = True
            for j in range(4):
                if q_condition[j] != "-" and q_condition[j] != i_condition[j]:
                    match = False
                    break

            if match and i_score >= q_score:
                count += 1

        result.append(count)

    return result
