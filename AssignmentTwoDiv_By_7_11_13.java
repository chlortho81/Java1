public class AssignmentTwoDiv_By_7_11_13 {  
  
    public static void main(String[] arg) {  
        int[] value = {7, 11, 13,};  
        int limit = 100000;  
        int largest = 0;  
        for(int i = 0; i <= limit; i++) {  
            boolean match = true;  
            for(int j = 0; j < value.length; j++) {  
                if(i % value[j] != 0) {  
                    match = false;  
                    break;    
                }  
            }  
            if(match)  
                largest = i;  
        }  
        System.out.print("Largest multiple of ");  
        for(int i = 0; i < value.length; i++)  
            System.out.print(" " + value[i]);  
        System.out.println(" is " + largest);  
    }  
}  
