class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        ss, st = sorted(s), sorted(t)
        for i in range(len(ss)):
            if st[i]!=ss[i]:
                return st[i]
            else:
                continue
        
        return st[-1]
