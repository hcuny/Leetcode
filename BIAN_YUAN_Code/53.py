class Solution(object):
    def maxSubArray(self, nums):
        i, j = 0, 1          # i, j is 2 pointers, to the start and end of current subarray
        leng=len(nums)
        summ=nums[0]    #current sum
        histmax=nums[i] #maximum in the history
        #histlst=[]
        while j<leng:
            #currentlst=nums[i:j]
    
            temp=summ+nums[j]

            if temp<nums[j]:
                summ=nums[j]
                i=j
                j=j+1
                #currentlst=nums[i:j]
            else:# temp is greater
                summ=temp
                j+=1
                #currentlst=nums[i:j]
                
            if summ>histmax:
                histmax=summ
                #histlst=currentlst
                
        return histmax
