package ForTest;

public class String__ {
    public static void main(String[] args) {
        /**
         * 如果字符串常量池中不存在字符串对象“abc”的引用，
         * 那么它会在堆上创建两个字符串对象，其中一个字符串对象的引用会被保存在字符串常量池中。
         */
        String s1 = new String("abc");
        //String s1 = String.valueOf("abc");   这句赋值等价于String s1 = "abc"
        String s2 = s1.intern();   //返回的是另一个字符串的引用，不是s1
        System.out.println(s1 == s2);


        String a = "abc";  //以常量的形式创建字符串对象，会自动把其引用保存一份在字符串常量池，不会创建两个字符串对象
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(b == c);


        /**
         * 对于编译期可以确定值的字符串，也就是常量字符串 ，jvm 会将其存入字符串常量池。
         * 并且，字符串常量拼接得到的字符串常量在编译阶段就已经被存放字符串常量池，这个得益于编译器的优化
         * 引用的值在程序编译期是无法确定的，编译器无法对其进行优化。
         */
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }
}





