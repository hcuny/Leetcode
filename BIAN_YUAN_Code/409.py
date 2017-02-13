#Note: we can take any combo of the letters!
class Solution(object):

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
    
        dic_count={}  #dictionary of key-value pair: (Letter, Frequency)
        for i in range(len(s)):
            if s[i] in dic_count:
                dic_count[s[i]]+=1
            else:
                dic_count[s[i]]=1
    
        valuelist=dic_count.values()
    
        even_list = [ele for ele in valuelist if ele%2==0] #freqency of letters that appeared even times
        odd_list  = [ele for ele in valuelist if ele%2!=0] # ...
    
        if len(odd_list)==0:
            return sum(even_list)
            
        elif len(even_list)==0:
            return sum(odd_list)-len(odd_list)+1
            
        else:
            return sum(even_list)+sum(odd_list)-len(odd_list)+1

        
        
