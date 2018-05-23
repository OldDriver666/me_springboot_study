package algorithm;

import java.util.Scanner;

public class PascalTest {  
    public static void main(String[] args){  
        PascalTest pascal = new PascalTest();  
        Scanner scanner = new Scanner(System.in);  
        System.out.println("请输入巴斯卡三角行数：");  
        int num = scanner.nextInt();  
        pascal.pascalAssemble(num);  
    }  
      
    public void pascalAssemble(int num){  
        int[][] value = new int[num][num];  
        for(int i = 0; i < num ;i++){  
            value[i][0] = 1;  
            value[i][i] = 1;  
            if(i > 1){  
                for(int j = 1; j < i ;j++){  
                    value[i][j] = value[i-1][j-1] + value[i-1][j];  
                }  
            }  
        }  
        for(int i = 0; i < num ;i++){  
            for(int k = 0; k <= num - i;k++){  
                System.out.print("    ");  
            }  
            for(int j = 0; j<= i ;j++){  
                System.out.print(value[i][j]);
                int n = String.valueOf(value[i][j]).length();
                if (i > 1 && j > 1 && j < i && value[i][j+1] == 1) {
					n = n - 1;
				}
                for (int m = 0; m < 8 - n; m++) {
                	System.out.print(" ");
				}
                
            }  
            System.out.println();  
        }  
    }  
}  