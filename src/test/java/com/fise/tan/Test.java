package com.fise.tan;

public class Test {

	public static void main(String[] args) {
		int arr[]= {8,3,3,8,2,2,5,6,6};
		int size = arr.length;
		System.out.println(findApperOnceNumberInArray(arr, size));
	}
	
    private static int   findApperOnceNumberInArray(int arr[],int size)  
    {  
         int  single_dog=0;  
         for(int i = 0;i<size;++i)  
         {  
             single_dog ^= arr[i];  
         }  
         return single_dog ;  
    }  

}
