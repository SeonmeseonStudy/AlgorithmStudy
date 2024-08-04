# def solution(citations):
#     arr=[]
#     counta=0
#     countb=0
    
#     for i in range(len(citations)):
#         for j in range(len(citations)):
#             if citations[i]<=citations[j]:
#                 counta+=1
#             elif citations[i]>citations[j]:
#                 countb+=1
#         if counta>=citations[i] and countb<=citations[i]:
#             arr.append(citations[i])
#             counta=0
#             countb=0
    
#     arr.sort(reverse=True)
#     answer = arr[0]
#     return answer


def solution(citations):
    citations.sort(reverse=True)
    h_index = 0
    
    for i in range(len(citations)):
        if citations[i] >= i + 1:
            h_index = i + 1
        else:
            break
            
    return h_index
