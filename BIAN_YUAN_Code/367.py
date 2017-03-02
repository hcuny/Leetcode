class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        
        Binary search
        """
        if num==1:
            return True
            
        
        low=0
        high=num
        mid=(low+high)//2
        
        while mid**2!=num:
        
            if mid**2<num:
                low=mid
                mid=(low+high)//2
            else:
                high=mid
                mid=(low+high)//2
            
            if mid==low or mid==high:
                return False
        return True
                
        
            
