class Solution(object):

        
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #transpose of the grid
        reversegrid=[[x[i] for x in grid] for i in range(len(grid[0]))]
        
        count=0
        
        #horizontally
        for ele in grid:

            string=''.join(map(str, ele))
            s=string.split('0')
            count+=len([a for a in s if '1' in a])
            
        #vertically
        for ele in reversegrid:

            string=''.join(map(str, ele))
            s=string.split('0')
            count+=len([a for a in s if '1' in a])
            
        return 2*count

        
