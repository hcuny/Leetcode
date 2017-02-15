def moveZeroes(nums):
    """
    :type nums: List[int]
    :rtype: void Do not return anything, modify nums in-place instead.
    """

    leng=len(nums)
    count=leng #  position first remaining 0
    
    for i in range(leng):        
        
        while nums[i]==0 and count>i :            
            for j in range(i,count-1):
                nums[j]=nums[j+1]
                
            nums[count-1]=0
            print("round",i,"count",count,nums)
                
            count=count-1

    return nums


#Input: [0,0,1,0,1,0,12]
#round 0 count 7 [0, 1, 0, 1, 0, 12, 0]
#round 0 count 6 [1, 0, 1, 0, 12, 0, 0]
#round 1 count 5 [1, 1, 0, 12, 0, 0, 0]
#round 2 count 4 [1, 1, 12, 0, 0, 0, 0]
