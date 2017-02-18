class Solution(object):

    def isSubsequence(self, s, t):
    
        start = 0
        for i in range(len(s)):
        
            start = t.find(s[i],start)  #return 1st index starting from "start"
            if start==-1:       #not found
                return False
            start += 1
            
        return True
