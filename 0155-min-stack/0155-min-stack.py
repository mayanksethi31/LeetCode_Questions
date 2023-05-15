from collections import deque
class MinStack(object):

    def __init__(self):
        self.container=deque()
        self.minstack=deque()

    def push(self, val):
        self.container.append(val)
        if len(self.minstack)==0:
            self.minstack.append(val)
        elif self.minstack and val<self.minstack[-1]:
            self.minstack.append(val)
        else: 
            self.minstack.append(self.minstack[-1])
        """
        :type val: int
        :rtype: None
        """
        

    def pop(self):
        """
        :rtype: None
        """
        self.container.pop()
        self.minstack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.container[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()