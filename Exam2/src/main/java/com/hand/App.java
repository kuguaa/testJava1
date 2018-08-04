package com.hand;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "请输入日期(如2018-08-04）：" );
        Scanner scanner=new Scanner(System.in);
        String data=scanner.next();
        int year,month,day,flag=0;
        //判断输入是否合法
        if(data.length()!=10)
            System.out.println("您输入的格式不符合要求");
        else{
            year=Integer.parseInt(data.substring(0,4));
            month=Integer.parseInt(data.substring(5,7));
            day=Integer.parseInt(data.substring(8,10));
            if(year<0||month<1||month>12||day<1||day>31)
                System.out.println("您输入的日期不合法");
            else if(month==2) {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    if (day > 29)
                        System.out.println("您输入的日期不存在");
                    else if(day == 29){
                        flag=1;//闰年二月最后一天
                        nextDay(year,month,day,flag);
                    }else
                        nextDay(year,month,day,flag);
                }else if(day > 28)
                    System.out.println("您输入的日期不存在");
                else if(day == 28) {
                    flag=1;//非闰年二月最后一天
                    nextDay(year, month, day,flag);
                }
            } else
                nextDay(year,month,day,flag);
        }
    }

    //计算输出下一天
    public static int nextDay(int year,int month,int day,int flag) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:{
                if(day==31){
                    day=1;
                    if(month==12){
                        month=1;
                        year++;
                    }else
                        month++;
                }else
                    day++;
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11:
            {
                if(day==31){
                    System.out.println("您输入的日期不合法");
                    return 0;
                }
                if(day==30){
                    day=1;
                    month++;
                }else
                    day++;
                break;
            }
            case 2:
            {
                if(flag==1){
                    day=1;
                    month++;
                }else
                    day++;
                break;
            }
        }
        String data=String.format("%04d",year)+"-"+String.format("%02d",month)+"-"+String.format("%02d",day);
        System.out.println("下一天为："+data);
        return 1;
    }
}

