"""
Key point: designed 2 pointers i & j indicating start and end position of each component
example: 1122211, 3 component: "11","222","11"
"""

class Solution(object):
    
    def countsay(self, n): #Designed to get the next element in the sequence given the previous one
        
        s=list(str(n))
        i,j,diff=0,1,1
        target=''
        leng=len(s)
        while (j<leng):
            if s[i]!=s[j]: #not equal, next iteration           
                diff=j-i
                target=target+str(diff)+str(s[i])
                i=j
                j=i+1
            else:          #equal same iteration
                j+=1
                
            diff=j-i       
            
        return target+str(diff)+str(s[i])
                
    
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        result=1
        if n==1:
            return str(result)
        else:
            for i in range(n-1):
                result=self.countsay(result)
        
            return result
        
