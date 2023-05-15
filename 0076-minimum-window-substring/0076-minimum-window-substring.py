class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """

        if t=="": return ""

        dict_T={}
        window_s={}

        for i in t:
            dict_T[i]=1+dict_T.get(i,0)
        have, need= 0, len(dict_T)
        l=0
        res_len=float("infinity")
        res=[-1,-1]
        for i in range(len(s)):
            c=s[i]
            if c in dict_T:
                window_s[c]=1+window_s.get(c, 0) 
                if window_s[c] == dict_T[c]:
                    have+=1
            while have==need:
                if (i-l+1)<res_len:
                    res_len=i-l+1
                    res=[l,i]
                if s[l] in dict_T:
                    window_s[s[l]]-=1
                    if window_s[s[l]]<dict_T[s[l]]:
                        have-=1
                l+=1
        l,r=res
        #print(l,r)

        return s[int(l):int(r)+1] if res_len!=float("infinity") else ""
                        




