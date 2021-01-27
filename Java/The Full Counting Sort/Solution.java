import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] frequencies = new int[100];
        StringBuilder sb = new StringBuilder("");
        Map<Integer,Queue<StringBuilder>> order = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            String[] tmp = br.readLine().split(" ");
            int num = Integer.parseInt(tmp[0]);
            
            StringBuilder s = new StringBuilder(tmp[1]);
            if(i < n/2) s = new StringBuilder("-");
            
            if(!order.containsKey(num))
            {
                Queue<StringBuilder> strs = new LinkedList();
                order.put(num, strs);
            }
                order.get(num).add(s);
                
            frequencies[num] = frequencies[num] + 1;
        }
        
        for(int i = 0; i < frequencies.length; i++)
        {
            for(int j = 0; j < frequencies[i]; j++)
            {
                sb.append(order.get(i).poll().toString() + " ");
            }
        }
        System.out.print(sb);
    }
}