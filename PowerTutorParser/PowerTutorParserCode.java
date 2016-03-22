import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parser_2 {
	public static void main(String[] args) 
    {
       System.out.println("Reading File from Java code");
       //Name of the file
       String fileName="PowerTrace_Parser_Deneme.txt";
       try{
    	   System.out.println("Enter a process ID");
    	   Scanner in = new Scanner(System.in);
    	   String processID = in.nextLine();
    	   System.out.println("Application's processID: "+processID);
          //Create object of FileReader
          FileReader inputFile = new FileReader(fileName);

          //Instantiate the BufferedReader Class
          BufferedReader bufferReader = new BufferedReader(inputFile);
          List<Integer> liste_1 = new ArrayList<Integer>();
          List<Long> liste_2 = new ArrayList<Long>();
          List<Double> liste_3 = new ArrayList<Double>();
          List<Integer> liste_4 = new ArrayList<Integer>();
          List<Integer> liste_5 = new ArrayList<Integer>();
          List<Integer> liste_6 = new ArrayList<Integer>();
          List<Integer> liste_7 = new ArrayList<Integer>();
          List<Integer> liste_8 = new ArrayList<Integer>();
          List<Integer> liste_9 = new ArrayList<Integer>();
          //Variable to hold the one line data
          String line;
          String katar ;
          String katar_1 ;
          String katar_2 ;
          String katar_3 ;
          String katar_4 ;
          String katar_5 ;
          String katar_6 ;
          String katar_7 ;
          String katar_8 ;
          // Read file line by line and print on the console
          while ((line = bufferReader.readLine()) != null)   { 
        	  katar = line.substring(0,2);
        	  switch (katar)
        	{
        	  case "be" :
      		  	String[] array_1 = line.split(" ");
      		  	int buffer_0 = Integer.valueOf(array_1[1]);
      		  	liste_1.add(buffer_0);
      		  	break ;
        	  case "ti":
        		  String[] array_2 = line.split(" ");
        		  Long buffer = Long.valueOf(array_2[1]);
        		  liste_2.add(buffer) ;
        		  break ;
        	  case "ba" :
        		  if (line.substring(0, 12).equals("batt_current"))
        		  {
        			  String[] array_3 = line.split(" ");
        			  Double buffer_2 = Double.valueOf(array_3[1]);
        			  liste_3.add(buffer_2); 
        		  }
        		  break ;
        	  case "to":
        		  if ( line.substring(0,11).equals("total-power"))
        		  {
        			  String[] array_3 = line.split(" ");
        			  int buffer_1 = Integer.valueOf(array_3[1]);
        			  liste_4.add(buffer_1);        			  
        		  }
        		  break ;
        	  case "3G" :
        		  if ( line.substring(3,4).equals("T"))
        		  {	  	
        			  katar_2 = line.substring(3,8);
        			  String array_7[] = line.split("-");
        		  
        			  if (katar_2.equals("TOTAL") && array_7[2].equals(String.valueOf(processID)))
        		  			{
        			  
        				  		String[] process_katar_1 = line.split("-");
        				  				if ( process_katar_1[2].equals(processID))
        				  						{
        				  							int j = 0 ;
        				  							String[] ParserArray_1 =  line.split(" ");
        				  							int uzunluk = ParserArray_1.length ;
        				  							int  buffer_3 = Integer.valueOf(ParserArray_1[ uzunluk -1 ]);
        				  							liste_5.add(buffer_3);
        		  
        				  						}	
        		  			}
        		  }
        		  break ;
        	  case "WI" :
        		  katar_1 = line.substring(5,10);
        		  String array_8[] = line.split("-");
        		  if (katar_1.equals("TOTAL") && array_8[2].equals(String.valueOf(processID)))
        		  {
        			  String[] array = line.split("-");
        			  	if ( array[2].equals(processID))
        			  		{
        			  			int j = 0 ;
        			  			String[] ParserArray =  line.split(" ");
        			  			int uzunluk = ParserArray.length ;
        			  			int buffer_4 = Integer.valueOf(ParserArray[ uzunluk - 1 ]);
        			  			liste_6.add(buffer_4);
        			  		}
        		  }
        		  break;
        
        



        	  case "LC" :
        		  if ( line.substring(4,5).equals("T"))
        		  	{	  	
        			  		katar_3 = line.substring(4,9);
        			  		String array_9[] = line.split("-");
        			  			if (katar_3.equals("TOTAL") && array_9[2].equals(String.valueOf(processID)))
        			  					{
        			  						String[] process_katar_2 = line.split("-");
        			  						if ( process_katar_2[2].equals(processID))
        			  								{
        			  					  					int j = 0 ;
        			  					  					String[] ParserArray_2 =  line.split(" ");
        			  					  					int uzunluk = ParserArray_2.length ;
        			  					  					int  buffer_5 = Integer.valueOf(ParserArray_2[ uzunluk -1 ]);
        			  					  					liste_7.add(buffer_5);
        		  
       
        			  								}
        			  					}
        		  }
        		  break ;
        	  case "CP" :
        		 if (line.substring(2,4).equals("U-"))
        		 {
        			 katar_4 = line.substring(4,9);
        			 String array_10[] = line.split("-");
        		  if (katar_4.equals("TOTAL") && array_10[2].equals(String.valueOf(processID)))
        		  		{
        			  String[] process_katar = line.split("-");
        			  		if ( process_katar[2].equals(processID))
        			  				{
        			  					int j = 0 ;
        			  					String[] animalsArray_3 =  line.split(" ");
        			  					int uzunluk = animalsArray_3.length ;
        			  					int buffer_6 = Integer.valueOf(animalsArray_3[ uzunluk -1 ]);
        			  					liste_8.add(buffer_6);
        			  				}
        		  		}
        		  else if ( line.substring(4,9).equals(String.valueOf(processID)))
        		  {
        				
        			  	int j = 0 ;
	  					String[] animalsArray_3 =  line.split(" ");
	  					int uzunluk = animalsArray_3.length ;
	  					int buffer_6 = Integer.valueOf(animalsArray_3[ uzunluk -1 ]);
	  					liste_9.add(buffer_6);
        		  }
        		 }
        		 
        		  break ;

        	  default:
        		  	continue ; 

        	  }

        	  }

       bufferReader.close();
       
       PrintWriter pw = new PrintWriter(new File("test.xls"));
       StringBuilder sb = new StringBuilder();
       sb.append("Begin");
       sb.append(',');
       sb.append("Time");
       sb.append(',');
       sb.append("Batt_Current");
       sb.append(',');
       sb.append("Total_Power");
       sb.append(',');
       sb.append("3G");
       sb.append(',');
       sb.append("LCD");
       sb.append(',');
       sb.append("WIFI");
       sb.append(',');
       sb.append("CPU_1");
       sb.append(',');
       sb.append("CPU_2");
       sb.append("\n");
       
       int i ;
       for (i=0;i<liste_1.size();i++)
       {
       	sb.append(String.valueOf(liste_1.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
       	sb.append(",");
       	sb.append(String.valueOf(liste_2.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
       	sb.append(",");
       	sb.append("\n");
       }
       
       sb.append(",");
       sb.append("\n");
       sb.append("Batt_current");	
       sb.append("\n");
       for (i=0;i<liste_3.size();i++)
       {
           
    	   sb.append(String.valueOf(liste_3.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
           sb.append("\n");
       }
       
       sb.append(",");
       sb.append("\n");
       sb.append("total-power");
       sb.append("\n");
       
       for (i=0;i<liste_4.size();i++)
       {	
    	   sb.append(String.valueOf(liste_4.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
           sb.append("\n");
       }
       
       sb.append("\n");
       sb.append("CPU_2");
       sb.append("\n");
       
       for (i=0;i<liste_9.size();i++)
       {
    	   
    	   sb.append(String.valueOf(liste_9.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
    	   sb.append(",");
    	   sb.append("\n");
       }
       
       sb.append("\n");
       
       for (i=0;i<liste_5.size();i++)
       {
          	sb.append(String.valueOf(liste_5.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
          	sb.append(",");
          	sb.append(String.valueOf(liste_6.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
          	sb.append(",");
          	sb.append(String.valueOf(liste_7.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
          	sb.append(",");
          	sb.append(String.valueOf(liste_8.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
          	sb.append(",");
          	sb.append("\n");
       }
       
       pw.write(sb.toString());
       pw.close();
       System.out.println("done!");
        	 
          //Close the buffer reader
          
       }catch(Exception e){
          System.out.println("Error while reading file line by line:" + e.getMessage());                      
       }

     }
	

}
