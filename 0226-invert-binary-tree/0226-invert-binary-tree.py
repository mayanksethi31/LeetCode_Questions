# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        q=deque()

        if root:
            node=root
            q.append(node)
        while q:    
            level_length=len(q)
            for i in range(level_length):
                node=q.popleft()
                if node:
                    q.append(node.left)
                    q.append(node.right)
                    node.left, node.right=node.right, node.left

        return root

            



