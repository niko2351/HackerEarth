import java.io.*;
import java.util.*;


public class TestClass {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for(int t_i=0; t_i<T; t_i++)
		{
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);
			char[][] A = new char[N][N];
			for(int i_A=0; i_A<N; i_A++)
			{
				String[] arr_A = br.readLine().split(" ");
				for(int j_A=0; j_A<arr_A.length; j_A++)
				{
					A[i_A][j_A] = arr_A[j_A].charAt(0);
				}
			}

			int out_ = solution(A, K);
			System.out.println(out_);
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	static int solution(char[][] A, int K){
		int num = 0;
		ArrayList<Integer> thief = new ArrayList<Integer>();
		ArrayList<Integer> police = new ArrayList<Integer>();
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				if(A[i][j]=='P')
					police.add(j);
				else
					thief.add(j);
			}
			int t=0, p=0;
			while(t<thief.size() && p<police.size()){
				if(Math.abs(thief.get(t) - police.get(p)) <= K){
					num++;
					t++;
					p++;
				}
				else if(thief.get(t) < police.get(p))
					t++;
				else
					p++;
			}
			while(thief.size()>0)
				thief.remove(0);
			while(police.size()>0)
				police.remove(0);
		}
		return num;
	}
}