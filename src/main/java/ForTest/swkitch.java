package ForTest;

public class swkitch
{
	public static void main(String[] args)
	  {
	    int x = 3, y = 3;
	    switch(x + 3)
	      {
	        case 6: y = 1;
			  case 7 : y += 10;        //检查一下没有break是怎么执行的,会按顺序执行下去
	        default: y += 1;
	      }
        System.out.print(y);
	  }

}
