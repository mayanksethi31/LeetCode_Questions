from collections import deque
class Solution(object):
    def carFleet(self, target, position, speed):
        """
        :type target: int
        :type position: List[int]
        :type speed: List[int]
        :rtype: int
        """
        combined= list(zip(position, speed))
        combined.sort(key = lambda x:x[0], reverse=True)
        #print(combined)
        stack=deque()
        for i in combined:
            if stack and ((target*1.0-i[0])/i[1])<=((target*1.0-stack[-1][0])/stack[-1][1]) :
                #print("Speed",i[1])
                continue
            else:
                stack.append(i)
        print(stack)
        return len(stack)
            

