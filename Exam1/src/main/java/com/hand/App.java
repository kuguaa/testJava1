package com.hand;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
class Tax{
    private static Tax tax=new Tax();
    private Tax(){ }
    public static Tax getTax(){
        return tax;
    }
    public double taxCount(double salary){
        double taxAmount=0;
        double n=salary-3500;
        if(n<=0)
            taxAmount=0;
        else if(n<=1500)
            taxAmount=n*0.03;
        else if(n<=4500)
            taxAmount=1500*0.03+(n-1500)*0.1;
        else if(n<=9000)
            taxAmount=1500*0.03+4500*0.1+(n-4500)*0.2;
        else if(n<=35000)
            taxAmount=1500*0.03+4500*0.1+9000*0.2+(n-9000)*0.25;
        else if(n<=55000)
            taxAmount=1500*0.03+4500*0.1+9000*0.2+35000*0.25+(n-35000)*0.3;
        else if(n<=80000)
            taxAmount=1500*0.03+4500*0.1+9000*0.2+35000*0.25+55000*0.3+(n-55000)*0.35;
        else
            taxAmount=1500*0.03+4500*0.1+9000*0.2+35000*0.25+55000*0.3+80000*0.35+(n-8000)*0.45;

        return taxAmount;
    }
}
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("请输入工资：");
            Double salary= scanner.nextDouble();
            Tax tax=Tax.getTax();
            System.out.println("所需缴纳的税费为："+tax.taxCount(salary));
            System.out.println("继续？（y/n)");
        } while (scanner.next().equals("y"));
    }
}
