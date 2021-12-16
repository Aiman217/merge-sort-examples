//CPT316/CPT211/CPM313 
//Programming Languages Implementation & Paradigms
//Group member
//1.TAN JING KAI (141130)
//2.LI PEI RAN (145141)
//3.MUHAMMAD AIMAN ARIF BIN BAHARUDIN (146824)

import java.io.*;
import java.util.*;

class Merge_sort{  
    public static void main(String args[]) throws Exception{  
        //Start time
        long begin = System.currentTimeMillis(); 
        //Open the file
        FileInputStream fstream = new FileInputStream("sgb-words.txt");
        //Buffer reader
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        //Declare variable for string from file
        ArrayList<String> data = new ArrayList<String>();
        String temp_read;
        int size = 0; //Count length of file
        //Read File
        while ((temp_read = br.readLine()) != null){
            //Add data into variable
            data.add(temp_read);
            size++;
        }
        //Close file
        fstream.close();
        //Create output file
        FileWriter outputFile = new FileWriter("output_java.txt");
        //Call class Merge_sort
        Merge_sort ms = new Merge_sort();  
        String temp_str; //Temporary holder for data
        //Convert each string to list of characters
        for (int i = 0; i < size; i++){
            temp_str = data.get(i);
            //Temporary holder for data in list of characters
            char[] temp_ch = new char[temp_str.length()]; 
            for (int x = 0; x < temp_str.length(); x++){
                temp_ch[x] = temp_str.charAt(x);
            } 
            //Call function mergeSort
            ms.mergeSort(temp_ch, 0, temp_str.length() - 1); 
            //Write result to output file 
            outputFile.write("Sorted Array: ");   
            for (int j = 0; j < temp_ch.length; j++){
                outputFile.write(temp_ch[j]);
            }
            outputFile.write("\n");
        }
        //Close output file
        outputFile.close();
        //End time
        long end = System.currentTimeMillis(); 
        //Execution time   
        long time = (end-begin); 
        System.out.println("\n"+time+" milliseconds");
    } 
    //Function to merge the subarrays 
    void merge(char ary[], int beg, int mid, int end){    
        int p, q, r;  
        int nleft = mid - beg + 1;    
        int nright = end - mid;    
          
        //Temporary arrays for left and right sub-arrays  
        char LeftArray[] = new char[nleft];  
        char RightArray[] = new char[nright];  
          
        //Copy data to temporary sub-arrays  
        for (int i = 0; i < nleft; i++)
            LeftArray[i] = ary[beg + i];
        for (int j = 0; j < nright; j++)
            RightArray[j] = ary[mid + 1 + j]; 
        
        p = 0; //Initial index of left side 
        q = 0; //Initial index of right side       
        r = beg; //Initial index of merged sub-array 
        
        //Sorting data based on accending order
        while (p < nleft && q < nright){    
            if(LeftArray[p] <= RightArray[q]){    
                ary[r] = LeftArray[p];    
                p++;    
            }    
            else{    
                ary[r] = RightArray[q];    
                q++;    
            }    
            r++;    
        } 
        //Merge sub-arrays   
        while (p < nleft){    
            ary[r] = LeftArray[p];    
            p++;    
            r++;    
        }       
        while (q < nright){    
            ary[r] = RightArray[q];    
            q++;    
            r++;    
        }    
    }    
      
    void mergeSort(char ary[], int beg, int end){  
        if (beg < end){  
            int mid = (beg + end) / 2;  
            //Sort first and second arrays
            mergeSort(ary, beg, mid);  
            mergeSort(ary, mid + 1, end);
            merge(ary, beg, mid, end);  
        }  
    }       
}
      