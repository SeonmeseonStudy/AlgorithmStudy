import sys
def input(): return sys.stdin.readline().rstrip()

class Node:
    def __init__(self, data=None):
        self.data = data
        self.prev = None
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.cursor = self.tail
        
    def insert(self, data):
        node = Node(data)
        prev_node = self.cursor.prev
        
        prev_node.next = node
        node.prev = prev_node
        node.next = self.cursor
        self.cursor.prev = node
        
    def left(self):
        if self.cursor.prev != self.head:
            self.cursor = self.cursor.prev
            
    def right(self):
        if self.cursor != self.tail:
            self.cursor = self.cursor.next

    def delete(self):
        if self.cursor.prev != self.head:
            prev_node = self.cursor.prev
            prev_node.prev.next = self.cursor ## 앞앞 노드를 현재 노드 앞으로 변경
            self.cursor.prev = prev_node.prev ## 현재 노드 앞은 앞앞 노드로 변경

    def getText(self):
        result = []
        current = self.head.next
        while current != self.tail:
            result.append(current.data)
            current = current.next
        
        return "".join(result)

text = list(input())
n = int(input())

linkedText = LinkedList()

for t in text:
    linkedText.insert(t)
    
for _ in range(n):
    cmd = input().split()
    
    str_cmd = cmd[0]
    if str_cmd == "P":
        linkedText.insert(cmd[1])
    elif str_cmd == "L":
        linkedText.left()
    elif str_cmd == "D":
        linkedText.right()
    elif str_cmd == "B":
        linkedText.delete()

print(linkedText.getText())