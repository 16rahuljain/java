/* ************************************************************************  
* Date      : March 2016
* Author    : Rahul Jain
* Email     : 16rahuljain@gmail.com
* Purpose   : Validate Provider NPI (National Provider Indetification number) 
*             and return 1 if valid and 0 if invalid   
 **************************************************************************/


package NPI;

public class ValidateNPI {
      // Method returns true if input value is numeric otherwise false
	 static boolean isInteger(String input)
    {
       try
       {
          Integer.parseInt( input );
          return true;
       }
       catch( Exception e)
       {
          return false;
       }
   }
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
	   String NPI = null;                               //Input NPI which you want to validate
	   int Len = (NPI==null?0:NPI.length());
	   int Result = 0;
       int Total = 0;
       int Index = 0;       
       String TempStr = "";
       int TempInt = 0;
            
          
       if (Len == 0 || NPI == null)                     // Check if NPI is blank or null
       {
    	   Result = 0;
    	 
       }
                                                       // Check for invalid char in input NPI
       else if(Len != 10 || isInteger(NPI) == false || NPI.contains(".") 
    		   || (NPI.substring(0,1).equals("1") && NPI.substring(0,1).equals("2")))
       {
    	   Result = 0;
    	   System.out.println("in after len");
       }
       else                                            // Calculate checksum
       {
    	   Index = Len;
    	   while (Index>0)
    	   
    	   {
    		   TempStr = NPI.substring(Index-1,Index);
    		   
    		   Total = Total + Integer.parseInt(TempStr);
    		   
    		   TempStr = NPI.substring(Index-2,Index-1); 
    		           
    		   TempInt = Integer.parseInt(TempStr) * 2 ;
    		   
    		   if (TempInt < 10) 
    		   {
               Total = Total + TempInt;
    		   }
    		   else
    			   {
    	               TempStr = Integer.toString(TempInt); 
    	               Total = Total + Integer.parseInt(TempStr.substring(1,2)); 
    	               Total = Total + Integer.parseInt(TempStr.substring(0,1));
    		       }
    	            
    	         Index = Index-2;    
    	   }
       
    	   if (Len % 2 == 1) 
    	   {
    	          Total = Total + Integer.parseInt(NPI.substring(0,1)); 
    	   }
    	   if (Len == 10)
    	   {
    		   Total = Total + 24;
    	   }
    	   if (Total % 10 == 0)
    	   {
    		   Result = 1;
    	   }
    	   else 
    	   {
    	     Result = 0;
    	    
    	   }
       }
       
          System.out.println(Result);         //Output 1 if NPI is Valid, 0 if Invalid
	}

}
