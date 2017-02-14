import re
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
    
        vowels = re.findall('(?i)[aeiou]', s) # RE to find vowels as list
        return re.sub('(?i)[aeiou]', lambda m: vowels.pop(), s) # pop means get from bottom
        
            
        
