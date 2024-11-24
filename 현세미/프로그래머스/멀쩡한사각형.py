import math

def solution(W, H):
    total = W * H

    #대각선에 있는 사각형 갯수(최대공약수와 같음ㅁ)
    gcd_val = math.gcd(W, H)

    #사용할 수 없는 정사각형(격자점 어쩌고 하는데 W+H에서 왜 빼주는지 정확히 이해 못함..)
    unusable = W + H - gcd_val

    return total - unusable
