package foundation;

/**
 * Created by zhangjinchun on 2017/12/15.
 */
public class EaqualsTest {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        String s4 = new String("java");

        System.out.println(s1==s2);            //true
        System.out.println(s1.equals(s2));    //true
        System.out.println(s1==s4);            //true
        System.out.println(s3.equals(s4));    //true
    }

    public static void mRun(final String name) {
        new Runnable() {
            @Override
            public void run() {
                System.out.println(name);
            }
        };
    }

    public static void stringEquals() {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

    public static void mRun2(final String name) {
        new Runnable() {

            public void start() {
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }.start();
    }

    public static void IntegerEaquals() {
        Integer a = new Integer(1000);
        int b = 1000;
        Integer c = new Integer(10);
        Integer d = new Integer(10);
        System.out.println(a == b);
        System.out.println(c == d);
    }


}
