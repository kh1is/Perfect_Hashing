import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
public class ReadFile {
    // Creating The ArrayList of integers
	public int maximum = 0;
    private ArrayList<Integer> source = new ArrayList<Integer>();
    public ReadFile(File file) {
        // Creating File Reader
    	
    	//file without commas
    	/*
        FileReader inputFile = null;
        try {
            inputFile = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Creating Buffer Reader
        BufferedReader in = new BufferedReader(inputFile);
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (s != null) {
            source.add(Integer.parseInt(s));
            try {
                s = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    	
    	//file with commas
    	 BufferedReader br = null;
         String line = "";
         String cvsSplitBy = ",";
         try {

             br = new BufferedReader(new FileReader(file));
             while ((line = br.readLine()) != null) {

                 // use comma as separator
            	 String[]  country = line.split(cvsSplitBy);
            	 for(int i=0;i<country.length;i++){
                	 source.add(Integer.parseInt(country[i]));
                 }
             }

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (br != null) {
                 try {
                     br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
        /*
         for(int i=0;i<source.size();i++){
        	 System.out.println(source.get(i));
         }
        */
         System.out.println("lenght= " +  source.size());
        // Check if file is Empty
        if (source.size() == 0){
            throw null;
        }
       
    }
    
    public int[] getSource(){
        int[] ret = new int[this.source.size()];
        Iterator<Integer> iterator = this.source.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
            if(ret[i] > maximum)
            	maximum = ret[i];
        }
        return ret;
    }
    
}