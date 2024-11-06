#프로그래머스 - 개인정보 수집 유효기간
def solution(today, terms, privacies):
    def date_to_days(date):
        year, month, day = map(int, date.split('.'))
        return year * 12 * 28 + month * 28 + day #년월일을 일수로 계산

    today_days = date_to_days(today)

    term_dict = {}
    for term in terms:
        kind, month = term.split()
        term_dict[kind] = int(month) * 28

    result = []

    for i, privacy in enumerate(privacies):
        date, kind = privacy.split()
        collected_days = date_to_days(date)
        expiry_days = collected_days + term_dict[kind]

        if today_days >= expiry_days:
            result.append(i + 1)
    
    return result
