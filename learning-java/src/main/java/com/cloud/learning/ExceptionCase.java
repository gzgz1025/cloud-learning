package com.cloud.learning;

/**
 * @ClassName: ExceptionCase
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/29 10:03
 * @Version: 1.0
 */
public class ExceptionCase {
    private static  int times=0;
    public static void sendMsg(String message){
        try {
            int a=0;
            int b=1;
            int c=b/a;
        }catch (Exception e){
            times+=1;
            if(times>5){
                System.out.println("ccccc");
            }
        }
        //throw new RuntimeException("测试测试");
    }

    public static void main(String[] args) {
        for (int i=0;i<6;i++){
            sendMsg("12355");
        }

    }
}
