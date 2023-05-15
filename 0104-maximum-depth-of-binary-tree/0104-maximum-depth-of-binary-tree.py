# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        max_depth=0
        q=deque()
        depth=1
        if root:
            node=root
            q.append([node, depth])
        while q:
            element = q.pop()
            node = element[0]
            last_depth = element[1]
            if node:
                if node.left:
                    q.append([node.left, last_depth+1])
                if node.right:
                    q.append([node.right, last_depth+1])
            if last_depth>max_depth:
                max_depth=last_depth
        return max_depth