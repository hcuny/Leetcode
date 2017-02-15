class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num<=0:
            return False
            
        for ele in [2,3,5]:
            
            while num%ele==0:   # Mod operator
                #temp=num
                #num=num/(1.0*ele)
                num=num/ele
            #num=temp
            
        return num==1
