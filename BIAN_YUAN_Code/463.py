#思路： 分横向和纵向计算。横向举例：对每行而言，横向若有多岛相连，则视为一个整体，贡献周长为1x2=2，若有两岛中间隔水，则视为2个整体，贡献周长2x2=4 
#技巧： 每行都先转为string，再以‘0’隔开，数一下含‘1’的部分有几块，最后乘以2.
#如此对每行分别计算即可
#纵向即是对每一列分别计算
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

        
