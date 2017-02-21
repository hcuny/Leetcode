#Sub-problem of this simple DP: unique path of every entry(i,j) d[i][j]=d[i-1][j]+d[i][j-1]
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        d=[[None]*n for i in range(m)]#mxn
        for i in range(n):
            d[0][i]=1
        for j in range(m):
            d[j][0]=1
        
        for i in range(1,m):
            for j in range(1, n):
                d[i][j]=d[i-1][j]+d[i][j-1]
                
        return d[m-1][n-1]
        
