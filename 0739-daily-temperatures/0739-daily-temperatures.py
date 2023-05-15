from collections import deque
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        new_temperatures=temperatures
        res=[0]*len(new_temperatures)
        stack=[]
        for i, t in enumerate(new_temperatures):
            while stack and t>stack[-1][0]:
                    #print(len(stack))
                element, index=stack.pop()
                res[index]=i-index
            stack.append([t,i])
        return res


