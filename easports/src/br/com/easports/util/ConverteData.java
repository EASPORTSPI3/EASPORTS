package br.com.easports.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {
	
	public static Date stringToDate(String data) { 
 		if (data == null || data.equals(""))
 			return null;
         Date date = null;
         try {
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             date = new Date( (formatter.parse(data)).getTime() );
         } catch (Exception e) {            
             System.out.println(e.getMessage());;
         }
         return date;
 	}
	
	public static String dateToString(Date data) { 
 		if (data == null || data.equals(""))
 			return null;
         String dataString = null;
         try {
        	 Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        	 dataString = formatter.format(data);
         } catch (Exception e) {            
             System.out.println(e.getMessage());;
         }
         return dataString;
 	}

}
