from collections import deque
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        max_area=0
        stack=deque()

        for i, j in enumerate(heights):
            if stack and j<stack[-1][1]:
                while stack and j<stack[-1][1]:
                    #print(j, "Ruka")
                    index, element =stack.pop()
                    #print(index, element)
                    area=(i-index)*element
                    if area>max_area:
                        max_area=area
                    #print(max_area)
                stack.append((index,j))
            else:
                stack.append((i,j))

        while stack:
            index, element=stack.pop()
            area=(len(heights)-index)*element
            if area>max_area:
                        max_area=area
        #print(stack.pop())
        return (max_area)
        

