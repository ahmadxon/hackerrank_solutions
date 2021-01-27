import java.io.*;

import java.util.*;

 

public class Solution {

 

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int R = in.nextInt();

        int C = in.nextInt();

        int n = in.nextInt();

        String[] str = new String[R];

        for(int i=0;i<R;i++){

            str[i] = in.next();

        }

        

        for(int i=0;i<R;i++){

            for(int j=0;j<C;j++){

                if(str[i].charAt(j) == 'O'){

                    if(n%2==0 || n%4==1){

                        System.out.print("O");

                    }else{

                        System.out.print(".");

                    }

                }else{

                    if(!nearHasBomb(i,j,str)){

                        if(n==0 || n==1){

                            System.out.print(".");

                        }else{

                            if(n%2==0 || n%4 == 3){

                                System.out.print("O");

                            }else{

                                System.out.print(".");

                            }

                        }

                    }else{

                        boolean nearnearClean = false;

                        if(i+1<R){

                            if(str[i+1].charAt(j) == '.'){

                                if(!nearHasBomb(i+1,j,str)){

                                    nearnearClean = true;

                                }

                            }

                        }

                        if(i-1>=0){

                            if(str[i-1].charAt(j) == '.'){

                                if(!nearHasBomb(i-1,j,str)){

                                    nearnearClean = true;

                                }

                            }

                        }

                        if(j+1<C){

                            if(str[i].charAt(j+1) == '.'){

                                if(!nearHasBomb(i,j+1,str)){

                                    nearnearClean = true;

                                }

                            }

                        }

                        if(j-1>=0){

                            if(str[i].charAt(j-1) == '.'){

                                if(!nearHasBomb(i,j-1,str)){

                                    nearnearClean = true;

                                }

                            }

                        }

                        if(!nearnearClean){

                            if(n==0 || n==1){

                                System.out.print(".");

                            }else{

                                if(n%2==0 || n%4==1){

                                    System.out.print("O");

                                }else{

                                    System.out.print(".");

                                }

                            }

                        }else{

                            if(n==0 || n%2==1){

                                System.out.print(".");

                            }else{

                                System.out.print("O");

                            }

                        }

                    }

                }

            }

            System.out.print("\n");

        }

    }

    static boolean nearHasBomb(int i,int j, String[] str){

        boolean nearHasBomb = false;

        if(i>0){

            if(str[i-1].charAt(j) == 'O'){

                nearHasBomb = true;

            }

        }

        if(i<str.length-1){

            if(str[i+1].charAt(j) == 'O'){

                nearHasBomb = true;

            }

        }

        if(j>0){

            if(str[i].charAt(j-1) == 'O'){

                nearHasBomb = true;

            }

        }

        if(j<str[i].length()-1){

            if(str[i].charAt(j+1) == 'O'){

                nearHasBomb = true;

            }

        }

        return nearHasBomb;

    }

}