# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e


class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        
        Sort By the End! And use greedy
        """
        if len(intervals)==1:
            return 0
            
        sortedInt=sorted(intervals , key=lambda x: (x.end, x.start))
        i,j,count=0,1,0
        while j<len(intervals):
            if sortedInt[j].start>=sortedInt[i].end:
                i=j
                j+=1
                
            else:
                count+=1
                j+=1
                
        return count
                
 #---------------------------------Compare to a Top solution-------------------------------------
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if not intervals: return 0
        intervals.sort(key=lambda x: x.start)  # sort on start time
        currEnd, cnt = intervals[0].end, 0
        for x in intervals[1:]:
            if x.start < currEnd:  # find overlapping interval
                cnt += 1
                currEnd = min(currEnd, x.end)  # erase the one with larger end time
            else:
                currEnd = x.end   # update end time
        return cnt
