class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n<=0:
            return False
        while n>1:
            if n!=int(n):
                return False
            
            else:
                n=n/(2*1.0)
                
        return True
            
