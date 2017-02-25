class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        trick: sort the list first, use 2 pointers to implement straight forward greedy
        """
        g=sorted(g)
        s=sorted(s)
        
        i,j,count=0,0,0
        
        while i<len(g) and j<len(s):
            if s[j]>=g[i]:
                count+=1
                i+=1
                j+=1
            else:
                j+=1
        return count
