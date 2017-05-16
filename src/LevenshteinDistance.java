
public class LevenshteinDistance 
{
	
	    
	    /**
	     * Uses bottom up DP to find the edit distance
	     * Implementation of the optimal solution
	     */
	   static public int dynamicEditDistance(char[] str1, int length1, char[] str2, int length2){
	        int D[][] = new int[length1+1][length2+1];
	        int l = D[0].length;
	        int l1 = D[1].length;
	        
	        for(int i=0; i < D[0].length; i++)
	        {
	            D[0][i] = i;
	        }
	        
	        for(int i=0; i < D.length; i++)
	        {
	            D[i][0] = i;
	        }
	        
	        for(int i=1;i <=str1.length; i++)
	        {
	            for(int j=1; j <= str2.length; j++)
	            {
	                if(str1[i-1] == str2[j-1]) // Same charactor X (i) = Y(j)
	                {
	                    D[i][j] = D[i-1][j-1];
	                }
	                else // Same charactor X (i) != Y(j)
	                {
	                    D[i][j] =  min((D[i-1][j-1] +2), (D[i-1][j] + 1), (D[i][j-1] + 1));
	                }
	            }
	        }
	        
	      
	        print2dMattric(D);
	        
	         printBacktracking(D, str1, str2);
	        
	        return D[str1.length][str2.length];
	    }

	    private static void print2dMattric(int[][] temp) 
	    {
	    	for(int i=0; i <temp.length; i++)
	        {
	            for(int j=0; j < temp[0].length; j++)
	            {
	            	System.out.print(temp[i][j] + "    ");
	            }
	            System.out.println();
	        }
			
		}

	    /**
	     * Backtracking of checking the operations
	     */
		public static void printBacktracking(int T[][], char[] str1, char[] str2) {
	        int i = T.length - 1;
	        int j = T[1].length - 1;
	        while(true) {
//	        	if(i == 1 || j ==1)
//	        	{
//	        		System.out.println();
//	        	}
	            if (i == 0 || j == 0) 
	            {
	            	if(i == 0 && j > 0)
	            	{
	            		if (T[i][j] == T[i][j-1] + 1)
	            		{
	            			System.out.println("insertion " + str2[j-1]);
	    	                j = j -1;
	            		}
	            	}
	            	else if(j == 0 && i > 0)
	            	{
	            		if (T[i][j] == T[i-1][j] + 1) 
	            		{
	            			System.out.println("deletion " + str1[i-1]);
	    	                i = i-1;
	            		}
	            	}
	            	
	            	
	                break;
	            }
	            if (str1[i-1] == str2[j-1]) 
	            {
	                i = i-1;
	                j = j-1;
	            } 
	            else if (T[i][j] == T[i-1][j-1] + 2)
	            {
	                System.out.println("substitution " + str1[i-1] + " to " + str2[j-1] + " in string1");
	                i = i-1;
	                j = j-1;
	            } 
	            else if (T[i][j] == T[i-1][j] + 1) 
	            {
	                System.out.println("deletion " + str1[i-1]);
	                i = i-1;
	            } 
	            else if (T[i][j] == T[i][j-1] + 1){
	                System.out.println("insertion " + str2[j-1]);
	                j = j -1;
	            } 
	            else 
	            {
	                throw new IllegalArgumentException("Some wrong with given data");
	            }

	        }
	    }
	    
	        
	        private static int min(int a,int b, int c)
	        {
	            int l = Math.min(a, b);
	            return Math.min(l, c);
	        }
	        
	        public static void main(String args[])
	        {
	        	//Test Strings
	        	String s1 = "abcd"; // converting intention to execution
	        	String s2 = "acdb"; 

	        	char[] str1 ;
	            char[] str2 ;
	            int length1 = 0;
	            int length2 = 0;
	            Parser.getStrings();
	            LevenshteinDistance editDistance = new LevenshteinDistance();
	            
	            	str1 = Parser.vector.get(0).getS();
	            	str2 = Parser.vector.get(1).getS();
	            	
	            	length1 = Parser.vector.get(0).getLen();
	            	length2 = Parser.vector.get(1).getLen();
	            
//	            str1 = s1.toCharArray();
//	            str2 = s2.toCharArray();
//	            length1 = str1.length;
//	            length2 = str2.length;

	            int result = editDistance.dynamicEditDistance(str1, length1, str2, length2);
	            System.out.print("Total no of operations -> "+ result);
	           
	        }
}
