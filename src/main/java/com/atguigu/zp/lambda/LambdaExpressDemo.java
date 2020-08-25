package com.atguigu.zp.lambda;

/**
 *  Lanbda Express
 *    1.口诀：拷贝小括号，写死右箭头，落地大括号
 *    2.@FunctionalInterface  用于检验函数式接口，只能有一个未实现的方法，可以有多个default和static方法
 */
@FunctionalInterface
interface Foo{
//    public void sayHello();
    public int add(int x, int y);

    default int div(int x, int y){
        System.out.println ("div...");
        return x/y;
    }

    default int div2(int x, int y){
        return x/y;
    }
    static int mul(int x, int y){
        System.out.println ("mul...");
        return x * y;
    }
}

/**
 * @author zhangpeng
 * @create 2020/8/25 16:20
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        /*Foo foo = new Foo () {
            @Override
            public void sayHello() {
                System.out.println ("hello");
            }
        };*/
        /*Foo foo = () -> {System.out.println ("hello");};
        foo.sayHello ();*/

        Foo foo = (x, y) -> {
            System.out.println ("add...");
            return x+y;
        };

        System.out.println (foo.add (1, 2));
        System.out.println (foo.div (4, 2));
        System.out.println (Foo.mul (5, 2));
    }

}
