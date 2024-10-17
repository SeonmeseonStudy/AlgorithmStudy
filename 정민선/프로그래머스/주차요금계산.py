from datetime import datetime, timedelta
import math

def solution(fees, records):
    answer = []
    # fees: 기본시간, 기본 요금, 기준 시간, 기준 요금
    basetime, basefee, unittime, unitfee = fees
    fmt = "%H:%M"
    park = dict()
    park_fee = []
    
    for r in records:
        time, car_number, state = map(str, r.split())
        
        if car_number not in park:
            park[car_number] = {'time' : time, 'total': 0}
        
        if state == "IN":
            park[car_number]['time'] = time
        else:
            t1 = datetime.strptime(time, fmt)
            t2 = datetime.strptime(park[car_number]['time'], fmt)

            park[car_number]['total'] += (t1 - t2).seconds//60
            park[car_number]['time'] = None

    for car, info in park.items():
        if info['time']:
            t1 = datetime.strptime("23:59", fmt)
            t2 = datetime.strptime(info['time'], fmt)

            info['total'] += (t1 - t2).seconds//60
            info['time'] = None
    
    for car, info in park.items():
        total = info['total']
        fee = basefee
        
        if total >= basetime:
            fee += math.ceil((total-basetime)/unittime)*unitfee
            
        park_fee.append((car, fee))
        
    park_fee.sort(key=lambda x: (x[0], x[1]))
    
    for car, fee in park_fee:
        answer.append(fee)
        
    return answer