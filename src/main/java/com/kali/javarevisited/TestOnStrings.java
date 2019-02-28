package com.kali.javarevisited;

/**
 * Created by mpalavelli on 25-10-2017.
 */
class A{
    public void m1()throws Throwable {
        System.out.println(" A m1");
        //return 0;
    }
    public void m2(){
        System.out.println(" A m2");
    }
    public void m4(){
        System.out.println(" A m4");
    }
}
class B extends A{
    public void m1() throws Exception{
        System.out.println(" B m1");
        //return 0;
    }
    @Override
    public void m2(){
        System.out.println(" B m2");
    }
    public void m3(){
        System.out.println(" B m3");
    }
}
public class TestOnStrings {
    public static void main(String[] args) {
        stringVsRotation();
    }
    public static void stringVsRotation(){
        /*A a = new B();
        try {
            //a.m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.m2();a.m4();*/
        String s1 = "bcda";
        String s2 = "abcd";
        String s3 = "abcda";
        System.out.println(s3.indexOf("a"));
        if(s1.length()==s2.length()){
            if(s1.concat(s1).toLowerCase().contains(s2.toLowerCase())){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
