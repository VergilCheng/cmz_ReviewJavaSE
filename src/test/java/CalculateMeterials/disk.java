package CalculateMeterials;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class disk {


    //升序打印
    public static void printArray(double [] a) {
        Arrays.sort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
        System.out.println("正序打印完成");
    }

    //倒叙打印
    public static void reversePrintArray(double [] a) {
        Arrays.sort(a);
        for (int i = a.length-1; i >=0 ; i--) {
            System.out.println(a[i]);
        }
        System.out.println("倒叙打印完成");
    }

    //计算洗过4次的压成片的离子电导率
    public static double[] calculate(double x) {
        double[] a = new double[7];
        for (int i = 0; i < 7; i++) {
            //System.out.println((double)-5/3*(1000/(x+273.15)) + 2.3351);
            a[i]=(double)-5/3*(1000/(x+273.15)) + 2.3351;
            //System.out.println((double)1000/(x+273.15));
            x+=10;
        }
        System.out.println("洗过4次的压成片的离子电导率计算完成");
        return a;
    }

    //没洗过压成片的离子电导率
    public static double[] calculate1(double x) {
        double[] a = new double[7];
        for (int i = 0; i < 7; i++) {
            //System.out.println(-5.3/3*(1000/(x+273.15)) + 2.4346);
            //System.out.println((double)1000/(x+273.15));
            a[i]=-5.3/3*(1000/(x+273.15)) + 2.4346;
            x+=10;
        }
        System.out.println("没洗过压成片的离子电导率计算完成");
        return a;
    }

    //没洗cp膜的离子电导率
    public static double[] calculate2(double x) {
        double[] a = new double[7];
        for (int i = 0; i < 7; i++) {
            //System.out.println(-5.3/3*(1000/(x+273.15)) + 2.4346);
            //System.out.println((double)1000/(x+273.15));
            a[i]=-0.26496*(1000/(x+273.15)) -3.0173888608;
            x+=10;
        }
        System.out.println("没洗过cp膜的离子电导率计算完成");
        return a;
    }

    //洗cp膜的离子电导率
    public static double[] calculate3(double x) {
        double[] a = new double[7];
        for (int i = 0; i < 7; i++) {
            //System.out.println(-5.3/3*(1000/(x+273.15)) + 2.4346);
            //System.out.println((double)1000/(x+273.15));
            a[i]=-0.697926*(1000/(x+273.15))-1.3044;
            x+=10;
        }
        System.out.println("洗过的cp膜离子电导率计算完成");
        return a;
    }






    public static void main(String[] args) {
        //洗过的LLZTO压成片的离子电导率
        double[] calculate = calculate(25.0);
        //System.out.println((double)-5/3*(1000/308.15)+2.3351);
        //System.out.println((double)-5/3);

        //公共x轴
        double b[]={3.3540164346805303,
                3.2451728054518907,
                3.1431714600031433,
                3.0473868657626086,
                2.9572674848440044,
                2.8723251472066638,
                2.792126204104426};
        printArray(b);
        reversePrintArray(calculate);

        //没洗过的压成片的LLZTO离子电导率
        double[] calculate1 = calculate1(25.0);
        reversePrintArray(calculate1);
        //没洗过的cp膜离子电导率
        double[] c = {-4.0503,
                -4.04232,
                -4.05495,
                -4.03494,
                -4.01658,
                -3.98607,
                -3.90607
        };
        reversePrintArray(c);
        reversePrintArray(calculate2(25.0));
        //洗过的cp膜离子电导率
        reversePrintArray(calculate3(25.0));
    }
}

