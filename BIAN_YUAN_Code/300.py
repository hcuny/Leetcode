class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        dic={}
        dic[0]=1
        maxlen=1
        
        for i in range(1,len(nums)):
                
            dic[i]=max([dic[j] for j in range(i) if nums[i]>nums[j]]+[0])+1
                       
            if dic[i]>maxlen:
                maxlen=dic[i]
        
        return maxlen
        
