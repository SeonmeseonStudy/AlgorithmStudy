def solve(s):
    def helper(start, end):
        if start > end:
            return
        # 현재 범위에서 사전순으로 가장 앞선 문자 탐색
        min_index = start
        for i in range(start, end + 1):
            if s[i] < s[min_index]:
                min_index = i

        print(s[min_index], end='')
        helper(min_index + 1, end)
        helper(start, min_index - 1)

    def print_steps(s):
        result = ''
        indices = []

        def recursive(start, end):
            if start > end:
                return
            min_index = start
            for i in range(start, end + 1):
                if s[i] < s[min_index]:
                    min_index = i
            indices.append(min_index)
            recursive(min_index + 1, end)
            recursive(start, min_index - 1)

        recursive(0, len(s) - 1)

        result_list = []
        added = [False] * len(s)
        for idx in indices:
            added[idx] = True
            current = ''.join([s[i] for i in range(len(s)) if added[i]])
            result_list.append(current)

        for r in result_list:
            print(r)

    print_steps(s)

solve(input())
