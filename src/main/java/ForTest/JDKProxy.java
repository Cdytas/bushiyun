package ForTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * 代理对象的类型是由接口列表决定的，因此只有实现了接口的类才能被代理
 */
public class JDKProxy {

    // 目标对象，需要增强的对象
    private Object target;

    // 有参构造器为目标对象进行赋值
    public JDKProxy(Object target) {
        this.target = target;
    }

    // 获取代理对象的方法
    public Object getProxyObject() {
        // 获取类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();

        // 获取目标对象实现的所有接口
        Class<?>[] interfaces = target.getClass().getInterfaces();

        // 调用Proxy.newProxyInstance()方法，创建代理对象
        Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, new MyInvocationHandler(target));

        // 将代理对象返回
        return proxyObject;
    }


    public static void main(String[] args) {
        // 创建目标对象，也就是需要被增强的对象
        CalculatorImpl calculator = new CalculatorImpl();

        // 获取代理对象
        JDKProxy myProxy = new JDKProxy(calculator);
        CalculatorImpl proxyObject = (CalculatorImpl) myProxy.getProxyObject();

        // 调用方法
        proxyObject.add(1, 2);
    }
}


class MyInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

        /**
         * @param proxy     代理对象
         * @param method    要执行的方法
         * @param args      执行方法时需要的参数
         * @return  调用目标对象方法后返回的执行结果
         */
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());

        //调用对应的方法
        Object res= method.invoke(target, args);
        System.out.println("结果是:" + res);

        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return res;
    }
}


/**
 * 计算器接口 有加减乘除功能
 */
interface Calculator {
    int add(int a, int b);  // 加法
    int sub(int a, int b);  // 减法
    int mul(int a, int b);  // 乘法
    int div(int a, int b);  // 除法
}

class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a  / b;
    }
}




