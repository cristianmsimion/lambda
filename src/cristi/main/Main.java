package cristi.main;

import cristi.main.callback.CallbackAsynchExceptionTest;
import cristi.main.callback.CallbackAsynchTest;
import cristi.main.callble.TestCallable;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;


/**
 * @author cristian
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        callbackTest();

        callableTest();

        lambda();

        //test1
    }

    /**
     *
     */
    private static void lambda() {


        GenerateKeygen g = f -> f;
        System.out.println(g.generateKey().generate("Cristi"));

        CristiFunction cf = f -> f;
        Integer i1 = cf.sum10().compute(1);
        Integer i2 = cf.modulo3().compute(9);
        System.out.println("i1 = " + i1 + "; i2 = " + i2);

        Function<Integer, Integer> f1 = x -> x + 1;
        Integer apply1 = f1.apply(1);
        System.out.println("apply1 =" + apply1);
        BinaryOperator<Integer> b1 = (b2, c2) -> b2 + c2;
        Integer apply2 = b1.apply(1, 1);
        System.out.println("apply2 =" + apply2);

        UnaryOperator<Integer> uo = (cc) -> cc + 4;
        System.out.println("unary = " + uo.apply(3));

        BinaryOperator<Function<Integer, Integer>> bo = (f2, f3) -> f -> f2.apply(f3.apply(4)) + f;
        Function<Integer, Integer> apply3 = bo.apply(f1, f1);
        Integer apply4 = apply3.apply(1);
        System.out.println("apply4 =" + apply4);

        SimpleInterface simpleClass = new SimpleClass()::test;
        System.out.println(simpleClass.lengt("test_1"));

//        Consumer<String> c = System.out::println;
        SimpleInterface si1 = (String v) -> v.length();
        System.out.println(si1.lengt("test"));


        Predicate<String> p1 = p -> p.length() < 20;
        System.out.println(p1.test("Gata"));

        Predicate<String> p2 = pp -> pp.length() > 5;

        Predicate<String> p3 = p1.and(p2);

        System.out.println(p3.test("mmm"));

        Collection<String> s1 = p1.test1("gata1");
        Collection<String> s2 = p1.test2("gata2");
        System.out.println(s1 + " " + s2);
    }

    /**
     *
     */
    private static void callableTest() {
        try {
            ExecutorService es = Executors.newSingleThreadExecutor();
            Future<String> submit = es.submit(new TestCallable());
            System.out.println(submit.get());
            es.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private static void callbackTest() {

        new CallbackAsynchTest() {
            @Override
            public void error(Exception e) {
                super.error(e);
                System.out.println(e.getMessage());
            }

            @Override
            public Object returnValue(Object o) {
                System.out.println(o);
                return super.returnValue(o);
            }
        };

        new CallbackAsynchExceptionTest() {
            @Override
            public void error(Exception e) {
                System.out.println(e.getMessage());
                super.error(e);
            }
        };


    }
}
