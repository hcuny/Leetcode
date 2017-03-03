
# ---------------------------------------------------- Solution 1-----------------------------------------------------------
"""
First thought--"use" the result of the last valid perfect square problem垃圾解法
nearestPS(n) : return the nearest (less than n) perfect square number (其实是返回平方根)
& Use traditional DP idea.
"""
class Solution(object):
    def nearestPS(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num<=3:
            return 1        
        low=0
        high=num
        mid=(low+high)//2
        
        while mid**2>num or (mid+1)**2<=num:            
            if mid**2>num:
                high=mid
                mid=(low+high)//2
            else:
                low=mid
                mid=(low+high)//2
        return mid
    
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp=[None]*(n+1)
        dp[0]=0
        dp[1]=1
        
        if n<2:
            return dp[n]
        
        for i in range(2,n+1):
            dp[i]=min([dp[i-j**2]+1 for j in range(1, self.nearestPS(i)+1)])
            
        return dp[n]
        
#---------------------------------------------- Solution 2 --------------------------------------------
"""
Pure DP solution, just a little modification
"""

class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp=[None]*(n+1)
        dp[0]=0
        dp[1]=1
        
        if n<2:
            return dp[n]
        
        for i in range(2,n+1):
            min_value=i
            j=1
            while j**2<=i:
                temp=dp[i-j**2]+1
                if temp<min_value:
                    min_value=temp
                j+=1
                
            dp[i]=min_value
            
        return dp[n]



















