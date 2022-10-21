

/**
 * @author Kyrie
 * @date 2022/6/2 10:26
 */
class EagerSingleTon {
    private static EagerSingleTon test = new EagerSingleTon();

    private EagerSingleTon(){
        System.out.println("Outer class constructor");
    }

    public static EagerSingleTon getTest(){
        System.out.println("Outer class getTest");
        return test;
    }
}

class DoubleCheckLock {
    private static DoubleCheckLock dcl;
    private DoubleCheckLock(){}
    public static DoubleCheckLock getInstance(){
        if (dcl == null){
            synchronized (DoubleCheckLock.class){
                if (dcl == null){
                    dcl = new DoubleCheckLock();
                }
            }
        }
        return dcl;
    }
}

class Test {
    public static void main(String[] args) {
        EagerSingleTon eager = EagerSingleTon.getTest();
        EagerSingleTon eager1 = EagerSingleTon.getTest();
        System.out.println(eager == eager1);
        DoubleCheckLock dcl = DoubleCheckLock.getInstance();
        DoubleCheckLock dcl1 = DoubleCheckLock.getInstance();
        System.out.println(dcl == dcl1);
    }
}
