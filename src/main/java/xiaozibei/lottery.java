package xiaozibei;
import java.util.Scanner;

public class lottery
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入彩票号码（两位数）：");
        int guess = input.nextInt();
        int lottery1 = (int)(Math.random()*10);
        int lottery2 = (int)(Math.random()*10);
        while(lottery1 == lottery2)
        {
            lottery2 = (int)(Math.random()*10);
        }
        int lottery = lottery1 * 10 + lottery2;
        int guess1 = guess / 10;
        int guess2 = guess % 10;
        if(lottery == guess || guess == 77)
        {
            if(guess == 77)
            {
                System.out.print("恭喜您触发小紫依隐藏号码77！中奖100元！");
            }
            else
                System.out.print("彩票号码为"+lottery+"。号码和顺序都匹配，恭喜您中奖10元！");
        }
        else if(lottery1 == guess2 && lottery2 == guess1)
        {
            System.out.print("彩票号码为"+lottery+"。号码匹配，恭喜您中奖5元！");
        }
        else if(lottery1 == guess1 || lottery1 == guess2 || lottery2 == guess1 || lottery2 == guess2)
        {
            System.out.print("彩票号码为"+lottery+"。单个号码匹配，恭喜您中奖1元！");
        }
        else
        {
            System.out.print("彩票号码为"+lottery+"。很遗憾您一个号码也没中..");
        }
        input.close();
    }
}
