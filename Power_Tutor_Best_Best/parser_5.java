
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parser_5 {
	public static void main(String[] args) 
    {
       System.out.println("Reading File from Java code");
       //Name of the file
       String fileName="PowerTrace1461512460454_Instagram.txt";
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
          List<Integer> liste_10 = new ArrayList<Integer>();
          List<Integer> liste_11 = new ArrayList<Integer>();
          List<Integer> liste_12 = new ArrayList<Integer>();
          List<Integer> liste_13 = new ArrayList<Integer>();
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
          int sayac_begin = 0 ; 
          int sayac_batt_current = 0 ;
          int sayac_WIFI = 0 ;
          int sayac_Wifi = 0 ;
          int sayac_CPU = 0 ;
          int sayac_CPU_1 = 0 ;
          int sayac_CPU_2 = 0 ;
          int sayac_3G = 0 ;
          // Read file line by line and print on the console
          while ((line = bufferReader.readLine()) != null)   { 
        	  katar = line.substring(0,2);
        	  switch (katar)
        	{
        	  case "be" :
        		sayac_begin = sayac_begin + 1 ;
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
        			  sayac_batt_current = sayac_batt_current + 1 ;
        			  if ( (sayac_batt_current-sayac_begin) < 0 )
        			  {
        				  while ( (sayac_batt_current-sayac_begin) < 0 )
        				  {
        					  liste_3.add(Double.valueOf(0));
        					  sayac_batt_current = sayac_batt_current + 1 ;
        				  }
        				  
        			  }
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
        		  if ( line.substring(0,3).equals("3G "))
        		  {	  	
      	  			sayac_3G = sayac_3G + 1 ;	

		  			 if ( (sayac_begin-sayac_3G) > 0 )
		  			 {
		  				 while ( sayac_3G < sayac_begin)
		  				 {
		  					 liste_5.add(0);
		  					 sayac_3G = sayac_3G + 1 ;
		  				 }
		  				 
		  			 }			
        			  
		  			 			String[] ParserArray_1 =  line.split(" ");
        				  		int  buffer_3 = Integer.valueOf(ParserArray_1[1]);
        				  		liste_5.add(buffer_3);	        	        				
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
        			  			sayac_WIFI = sayac_WIFI + 1 ;	

        			  			 if ( (sayac_begin-sayac_WIFI) > 0 )
        			  			 {
        			  				 while ( sayac_WIFI < sayac_begin)
        			  				 {
        			  					 liste_7.add(0);
        			  					 sayac_WIFI = sayac_WIFI + 1 ;
        			  				 }
        			  				 
        			  			 }
         			  			int j = 0 ;
         			  			String[] ParserArray =  line.split(" ");
         			  			int uzunluk = ParserArray.length ;
        			  			int buffer_4 = Integer.valueOf(ParserArray[ uzunluk - 1 ]);
        			  			liste_7.add(buffer_4);
        			  			
        			  		}
        		  }
        		  break;
        
        	  case "LC" :
        		  if ( line.substring(0,4).equals("LCD "))
        		  	{	  	
        			  		String[] ParserArray_2 =  line.split(" ");
        			  		int  buffer_5 = Integer.valueOf(ParserArray_2[1]);
        			  		liste_6.add(buffer_5);
        		  }
        		  break ;
        	  case "Au":
        		  if ( line.substring(0,6).equals("Audio "))
        		  {
        				String[] ParserArray_3 =  line.split(" ");
    			  		int  buffer_6 = Integer.valueOf(ParserArray_3[1]);
    			  		liste_8.add(buffer_6);
        		  }
        		  break ;
        	  case "GP":
        		  if (line.substring(0,4).equals("GPS "))
        		  {
        				String[] ParserArray_4 =  line.split(" ");
    			  		int  buffer_7 = Integer.valueOf(ParserArray_4[1]);
    			  		liste_9.add(buffer_7);
        		  }
        		  break ;
        		    
        	  case "Wi":
        		  if ( line.substring(0,5).equals("Wifi "))
        		  {
			  			sayac_Wifi = sayac_Wifi + 1 ;	

			  			 if ( (sayac_begin-sayac_Wifi) > 0 )
			  			 {
			  				 while ( sayac_Wifi < sayac_begin)
			  				 {
			  					 sayac_Wifi = sayac_Wifi + 1 ;
			  					 liste_10.add(0);
			  					 
			  				 }
			  				 
			  			 }
        			  	String[] ParserArray_5 =  line.split(" ");
    			  		int  buffer_8 = Integer.valueOf(ParserArray_5[1]);
    			  		liste_10.add(buffer_8);
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
        			  					sayac_CPU_1 = sayac_CPU_1 + 1 ;
        			  					
        			  		  			 if ( (sayac_begin-sayac_CPU_1) > 0 )
        					  			 {
        					  				 while ( sayac_CPU_1 < sayac_begin)
        					  				 {
        					  					 sayac_CPU_1 = sayac_CPU_1 + 1 ;
        					  					 liste_11.add(0);
        					  					 
        					  				 }
        					  				 
        					  			 }
        			  					int j = 0 ;
        			  					String[] animalsArray_3 =  line.split(" ");
        			  					int uzunluk = animalsArray_3.length ;
        			  					int buffer_6 = Integer.valueOf(animalsArray_3[ uzunluk -1 ]);
        			  					liste_11.add(buffer_6);
        			  				}
        		  		}
        		  else if ( line.substring(4,9).equals(String.valueOf(processID)))
        		  {
		  					sayac_CPU_2 = sayac_CPU_2 + 1 ;
		  					
		  		  			 if ( (sayac_begin-sayac_CPU_2) > 0 )
				  			 {
				  				 while ( sayac_CPU_2 < sayac_begin)
				  				 {
				  					 sayac_CPU_2 = sayac_CPU_2 + 1 ;
				  					 liste_12.add(0);
				  					 
				  				 }
				  			 }
        			  	int j = 0 ;
	  					String[] animalsArray_3 =  line.split(" ");
	  					int uzunluk = animalsArray_3.length ;
	  					int buffer_6 = Integer.valueOf(animalsArray_3[ uzunluk -1 ]);
	  					liste_12.add(buffer_6);
        		  }
        		 }
        		  else if ( line.substring(0,4).equals("CPU "))
        		  {
        			  sayac_CPU = sayac_CPU + 1 ;
        			  
     	  			 if ( (sayac_begin-sayac_CPU) > 0 )
		  			 {
		  				 while ( sayac_CPU < sayac_begin)
		  				 {
		  					 sayac_CPU = sayac_CPU + 1 ;
		  					 liste_13.add(0);
		  					 
		  				 }
		  				 
		  			 }
        			  String[] ParserArray_2 =  line.split(" ");
    			  	  int  buffer_5 = Integer.valueOf(ParserArray_2[1]);
    			  	  liste_13.add(buffer_5);
        		  }
        		 
        		 
        		  break ;

        	  default:
        		  	continue ; 

        	  }

        	  }

       bufferReader.close();

       PrintWriter pw = new PrintWriter(new File("Instagram.xls"));
       StringBuilder sb = new StringBuilder();
       sb.append("Begin");
       sb.append(',');
       sb.append("Time");
       sb.append(',');
       sb.append("Batt_Current");
       sb.append(',');
       sb.append("Total_Power");
       sb.append(',');
       sb.append("3G_GENEL");
       sb.append(',');
       sb.append("LCD_GENEL");
       sb.append(',');
       sb.append("WIFI_TOTAL");
       sb.append(',');
       sb.append("AUDIO_GENEL");
       sb.append(',');
       sb.append("GPS_GENEL");
       sb.append(',');
       sb.append("WIFI_GENEL");
       sb.append(',');
       sb.append("CPU_1_TOTAL");
       sb.append(',');
       sb.append("CPU_2");
       sb.append(',');
       sb.append("Cpu_GENEL");
       sb.append("\n");
       
       int i ;
       if ( sayac_batt_current < sayac_begin )
    	   {
    	   		while ( sayac_batt_current != sayac_begin )
    	   		{
    	   			liste_3.add(0.0);
    	   			sayac_batt_current = sayac_batt_current + 1 ;
    	   		}
    	   }

       if ( sayac_CPU_1 < sayac_begin )
	   {
	   		while ( sayac_CPU_1 != sayac_begin )
	   		{
	   			liste_11.add(0);
	   			sayac_CPU_1 = sayac_CPU_1 + 1 ;
	   		}
	   }
       
       if ( sayac_CPU_2 < sayac_begin )
	   {
	   		while ( sayac_CPU_2 != sayac_begin )
	   		{
	   			liste_12.add(0);
	   			sayac_CPU_2 = sayac_CPU_2 + 1 ;
	   		}
	   }
      
       
       for (i=0;i<liste_1.size();i++)
       {
       	sb.append(String.valueOf(liste_1.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
       	sb.append(",");
       	sb.append(String.valueOf(liste_2.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
       	sb.append(",");
       	String k = String.valueOf(liste_3.subList(i, i+1)).replaceAll("[\\[\\]]", "");
       	sb.append(k);
       	sb.append(",");    	   
       	sb.append(String.valueOf(liste_4.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
       	sb.append(","); 
       	sb.append(String.valueOf(liste_5.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
      	sb.append(",");
        sb.append(String.valueOf(liste_6.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
        sb.append(",");
 	   	sb.append(String.valueOf(liste_7.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
 	   	sb.append(",");
        sb.append(String.valueOf(liste_8.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
        sb.append(",");
      	sb.append(String.valueOf(liste_9.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
      	sb.append(",");
      	sb.append(String.valueOf(liste_10.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
 	   	sb.append(",");
 	   	sb.append(String.valueOf(liste_11.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
 	   	sb.append(",");
 	   	sb.append(String.valueOf(liste_12.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
 	   	sb.append(",");
	   	sb.append(String.valueOf(liste_13.subList(i, i+1)).replaceAll("[\\[\\]]", ""));
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