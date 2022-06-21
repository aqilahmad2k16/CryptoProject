package com.cryptoproject.project01.TestClass;

public class FindTheMaxOfArray {
    
        
        public static int findTheMaxOfArray(int[] arr){

            int max = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i] > max){
                    max = arr[i];
                }
            }

            return max;
        }
    
}
