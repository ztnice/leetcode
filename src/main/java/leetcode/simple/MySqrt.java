package leetcode.simple;

public class MySqrt {

    public static void main(String[] args) {
//        System.out.println(0);
//        System.out.println(mySqrt1(1));
//        System.out.println(mySqrt1(2));
//        System.out.println(mySqrt1(3));
//        System.out.println(mySqrt1(4));
//        System.out.println(mySqrt1(5));
//        System.out.println(mySqrt1(6));
//        System.out.println(mySqrt1(7));
//        System.out.println(mySqrt1(8));
//        System.out.println(mySqrt1(9));
//        System.out.println(mySqrt1(10));
//        System.out.println(mySqrt1(11));
//        System.out.println(mySqrt1(12));
//        System.out.println(mySqrt1(13));
//        System.out.println(mySqrt1(14));
//        System.out.println(mySqrt1(15));
//        System.out.println(mySqrt1(16));
//        System.out.println(mySqrt1(17));
//        System.out.println(mySqrt1(144));
//        System.out.println(mySqrt1(200));
//        System.out.println(mySqrt1(1024));
//        System.out.println(mySqrt1(2147483647));
//        System.out.println(mySqrt(2147483647));

        long a = System.currentTimeMillis();
        for(int i = 0 ; i < 10000000 ; i++){

            mySqrt1(2147483647);

        }

        long b = System.currentTimeMillis();

        System.out.println((b- a) + ":ms");


        long a1 = System.currentTimeMillis();
        for(int i = 0 ; i < 10000000 ; i++){

            mySqrt(2147483647);

        }

        long b1 = System.currentTimeMillis();

        System.out.println((b1- a1) + ":ms");

//        System.out.println(Math.sqrt(2147483647));

    }




    public static int mySqrt(int x) {
        // 1,1 2,4 3,9 4,16 5,25 6,36 10,100  100,10000
        if(x == 0 || x ==1){
            return x;
        }
        //二分法

        int left = 0,right = x,ans = -1;

        while (left <= right){

            int mid = ((right - left) >> 1) + left;

            long a = (long) mid * mid;

            if(a <= x){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid  - 1;
            }

        }
        return ans;
    }



    public static int mySqrt1(int x) {
        // 1,1 2,4 3,9 4,16 5,25 6,36 10,100  100,10000
        if(x == 0 || x ==1){
            return x;
        }
        //二分法

        int k = 31;
        int n = ( x >> k) + 1;
        long n2 = (long) n * (long) n ;
        while (n2 <= x){
            k--;
            n = ( x >> k) + 1;
            n2 = (long) n * (long) n;
        }

        int n1 = ( x >> (k + 1)) + 1;

        //对这部分用二分法 比较好
        k = -1;
        while (n1 <= n){
            //这块二分解决
            int mid = ((n - n1) >> 1 ) + n1;
            n2 = (long) mid * mid;
            if(n2 <= x){
                k = mid;
                n1 =  mid + 1;
            }else {
                n = mid -1  ;
            }
        }
        return k;
    }



    //69题  leetcode
    //牛顿迭代法 解决问题 todo  这块需要掌握

    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
