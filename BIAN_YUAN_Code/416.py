class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        To memorize all possible difference in each step, 
        E.g. list=[1,6,2,3]
        Step1: [1], memoset=(1)
        Step2: [1, 6], memoset=(1+6,6-1)=(7,5)
        Step3: [1, 6, 2], memoset=(7+2,7-2,5+2,5-2)=(9,5,7,3)
        Step4: Check 3 in (9,5,7,3), return True, in fact any number in (9,5,7,3) as the last number is fine.
        
        **Unique thinking, simple implementation but Not very good performance in computation
        """
        if len(nums)==1:
            return False
            
        elif len(nums)==2:
            return nums[0]==nums[1]
            
        else:
            memoset=set([nums[0]])
            for i in range(1,len(nums)-1):

                memoset=set(abs(ele-nums[i]) for ele in memoset).union(set(nums[i]+ele for ele in memoset))
                
            return nums[-1] in memoset
