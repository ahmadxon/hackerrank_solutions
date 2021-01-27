import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int sortedSwaps = 0;
        int[] homework = new int[n];
        Integer[] homeworkSorted = new Integer[n];
        Map<Integer,Integer> original = new HashMap<>();
        
        int sortedReverseSwaps = 0;    
        int[] homework2ndCopy = new int[n];        
        Map<Integer,Integer> original2ndCopy = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            homeworkSorted[i] = input.nextInt();
            homework[i] = homeworkSorted[i];
            homework2ndCopy[i] = homeworkSorted[i];
            original.put(homework[i],i);
            original2ndCopy.put(homework2ndCopy[i],i);
        }
            
        Arrays.sort(homeworkSorted);
        
        for(int i = 0; i < n; i++)
        {
            if(homework[i] != homeworkSorted[i])
            {
                int tmp = homework[i];
                homework[i] = homework[original.get(homeworkSorted[i])];
                homework[original.get(homeworkSorted[i])] = tmp;
                original.put(tmp,original.get(homeworkSorted[i]));
                sortedSwaps++;               
            }
        }
        
        Arrays.sort(homeworkSorted, Collections.reverseOrder());
        for(int i = 0; i < n; i++)
        {
            if(homework2ndCopy[i] != homeworkSorted[i])
            {
                int tmp = homework2ndCopy[i];
                homework2ndCopy[i] = homework2ndCopy[original.get(homeworkSorted[i])];
                homework2ndCopy[original2ndCopy.get(homeworkSorted[i])] = tmp;
                original2ndCopy.put(tmp, original2ndCopy.get(homeworkSorted[i]));
                sortedReverseSwaps++;
            }
        }
        System.out.println(Math.min(sortedSwaps,sortedReverseSwaps));
    }
}