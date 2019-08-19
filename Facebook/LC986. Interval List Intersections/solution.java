
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        int i=0,j=0;
        List<int[]>output=new ArrayList<>();
        while(i<A.length && j<B.length)
        {
            int first[]=A[i];
            int second[]=B[j];
            if(!(first[1]<second[0]) && !(second[1]<first[0]))
            output.add(new int[]{Math.max(first[0],second[0]),Math.min(first[1],second[1])});
            
            //discard the former one
            if(first[1]<second[1])
                i++;
            else
                j++;
        }
       
        //output
        int [][]result=new int[output.size()][2];
        int p=0;
        for(int temp[]:output)
            result[p++]=temp;
           
        return result;
    }
}
