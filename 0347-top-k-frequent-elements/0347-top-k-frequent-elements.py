class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        dict_l={}
        new_nums=set(nums)
        for i in new_nums:
            dict_l[i]=nums.count(i)
        dict_l=sorted(dict_l.items(), key=lambda x: x[1], reverse=True)
        l=[]
        for i in range(k):
            l.append(dict_l[i][0])
        return l