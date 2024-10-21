# 숫자 문자열과 영단어 - 백준
def solution(s):
    num_list = {
        "zero": "0", "one": "1", "two": "2", "three": "3", "four": "4",
        "five": "5", "six": "6", "seven": "7", "eight": "8", "nine": "9"
    }
    
    for text_num,num in num_list.items():
        s = s.replace(text_num, num)
    answer = int(s)
    return answer

