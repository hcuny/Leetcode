class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        Devide: e.g. 0-1000,d[0]-->non-repeat in [0,10), d[1]=d[0]+ non-repeat in [10,100),  etc..
        In fact it's O(1) time complexity
        """
        if n<=1:
            return 10**(n)

        d=[None]*(n+1)
        
        d[0]=10
        
        for i in range(1,n):
            
            d[i]=d[i-1]+9*math.factorial(9)/math.factorial(9-i)
            
        return d[n-1]
