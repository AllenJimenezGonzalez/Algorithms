package SelfStudy;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//Reference: https://www.hackerrank.com/challenges/non-divisible-subset/problem?isFullScreen=true
public class NonDivisibleSubset {
    
    public static int nonDivisibleSubset(int divider, List<Integer> set) {
        if (divider == 1) return 1;
        int maximalSubsetSize = set.size();
        HashMap<Integer, Integer> failures = new HashMap<>();

        for (int i = 0; i < set.size() - 1; i++) {
            int x = set.get(i);
            for (int j = i + 1; j < set.size(); j++) {
                int y = set.get(j);
                if ((x + y) >= divider && (x + y) % divider == 0 && !failures.containsKey(y)) {
                    if (failures.containsKey(x)) {
                        x = failures.get(x);
                        if ((x + y) >= divider && (x + y) % divider == 0) {
                            maximalSubsetSize--;
                            break;
                        }
                    } else {
                        failures.put(x, y);
                        failures.put(y, x);
                        maximalSubsetSize--;
                    }
                    break;
                }
            }
        }
        return maximalSubsetSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = NonDivisibleSubset.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
