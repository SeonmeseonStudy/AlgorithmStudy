def solution(relation):
    today_year, today_month, today_day = map(int, "2022.05.19".split('.')) 

    term_dict = {}  
    for term in ["A 6", "B 12", "C 3"]:  
        t, months = term.split()
        term_dict[t] = int(months)

    expired_privacies = []  

    for i in range(1, 1 << len(relation[0])):  
        tmp_set = set()

        for j in range(len(relation)):
            tmp = ''
            for k in range(len(relation[0])):
                if i & (1 << k):  
                    tmp += str(relation[j][k])
            tmp_set.add(tmp)  

        if len(tmp_set) == len(relation):
            not_duplicate = True
            for num in expired_privacies:
                if (num & i) == num:
                    not_duplicate = False
                    break
            if not_duplicate:
                expired_privacies.append(i)  

    return len(expired_privacies)  

