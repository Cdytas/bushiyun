package com.barca.bushiyun.ForTest;

public class swkitch
{
	public static void main(String[] args)
	  {
	    int x = 3, y = 3;
	    switch(x + 3)
	      {
	        case 6: y = 1;
			  case 7 : y += 10;        //���һ��û��break����ôִ�е�,�ᰴ˳��ִ����ȥ
	        default: y += 1;
	      }
        System.out.print(y);
	  }

}
