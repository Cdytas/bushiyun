package xiaozibei;

public class StringbuildTset {
    public static void main(String[] args) {
        StringBuilder build = new StringBuilder(16);
        char c[] = {'a','b','c','d','e','f','g','h','i','j','k'};
        build.insert(0,c,0,5);
        System.out.println(build.toString()+" "+build.length()+" "+build.capacity());
        build.delete(0,4);
        System.out.println(build.toString()+" "+build.length()+" "+build.capacity());
        System.out.println(build.charAt(0));  //下标自动改变。本来e的下标为4，现在变为0

        StringBuilder buildd = new StringBuilder();
        buildd.append('f');
        buildd.insert(0,'h');
        buildd.insert(0,'k');   //先插入的数据会被挤到后面
        System.out.println(buildd.toString());
    }
}
