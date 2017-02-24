class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        Still using little DP trick, i.e. to memorize the maximum 1s end with this component       
        """
        leng=len(nums)
        d=[None]*leng
        
        d[0]=nums[0]
        
        if leng==1:
            return d[0]
        
        for i in range(1, leng):
            if nums[i]==0:
                d[i]=0
            else:
                d[i]=1+d[i-1]
                
        return max(d)
