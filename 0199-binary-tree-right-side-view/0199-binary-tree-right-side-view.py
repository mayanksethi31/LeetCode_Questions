# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res=[]
        q=deque()
        q.append(root)
        
        while (q):
            level_last=None
            level_length=len(q)

            for i in range(level_length):
                node=q.popleft()
                if node:
                    level_last=node
                    q.append(node.left)
                    q.append(node.right)
                    
            if level_last:
                res.append(level_last.val)
        return res