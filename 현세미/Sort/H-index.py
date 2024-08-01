def solution(citations):
    citations.sort(reverse=True)
    h_index = 0

    for i in range(len(citations)):
     
        if citations[i] >= i + 1:
            h_index = i + 1
        else:
            break
    
    return h_index


#오름차순 정렬
#def solution(citations):
#    citations = sorted(citations)
#    l = len(citations)
#    for i in range(l):
#        if citations[i] >= l-i:
#            return l-i
#    return 0
