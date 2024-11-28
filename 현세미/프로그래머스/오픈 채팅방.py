def solution(record):
    user_info = {}
    actions = []

    for log in record:
        words = log.split()
        action = words[0]
        user_id = words[1]

        if action == "Enter":
            nickname = words[2]
            user_info[user_id] = nickname
            actions.append((user_id, "님이 들어왔습니다."))
        elif action == "Leave":
            actions.append((user_id, "님이 나갔습니다."))
        elif action == "Change":
            nickname = words[2]
            user_info[user_id] = nickname

    result = []
    for action in actions:
        user_id, message = action
        nickname = user_info[user_id]
        result.append(nickname + message)

    return result
