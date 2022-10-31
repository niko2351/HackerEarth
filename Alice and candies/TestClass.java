import java.util.*;

public class TestClass{
	public static void main(String args[]){
		int d=new Scanner(System.in).nextInt(), tot=0;
		if(d<1)
			d=1;
		else if(d>1000000000)
			d=1000000000;
		String tmp="";
		for(int i=1;i<=d;){
			int count=0;
			boolean flag=true;
			for(int j=i;j<=d;j+=2){
				count+=j;
				tmp+=j;
				if(count==d){
					tot++;
					System.out.println(tmp);
					i=j;
					if(i==d){
						flag=false;
						// return;
					}
					// else
						break;
				}
				else if(count < d )
					tmp+=",";
				else{
					tmp="";
					i+=2;
					break;
				}
			}
			if(!flag)
				break;
			tmp="";
		}
		// System.out.println(tmp);
		System.out.println(tot);
	}
}