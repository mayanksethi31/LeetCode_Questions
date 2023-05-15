class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dict_s={}
        for i in set(list(str(s))):
            dict_s[i] = s.count(i)

        dict_t={}
        for i in set(list(str(t))):
            dict_t[i] = t.count(i)
        
        return True if dict_t==dict_s else False
        