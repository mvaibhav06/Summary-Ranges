package DSA;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums){
        List<String> out = new ArrayList<>();

        if(nums.length==0) return out;
        if(nums.length==1){
            out.add(String.valueOf(nums[0]));
            return out;
        }

        String str = String.valueOf(nums[0]);
        int i=0;
        for (i=0; i<nums.length-1; i++){
            if (nums[i]+1 == nums[i+1]){
                continue;
            }else {
                str += "->" + nums[i];
                out.add(str);
                str = String.valueOf(nums[i+1]);
            }
        }
        if (nums[nums.length-2]+1 == nums[nums.length-1]){
            str += "->" + nums[nums.length-1];
            out.add(str);
        }else {
            out.add(String.valueOf(nums[nums.length-1]));
        }
        for (int k=0; k<out.size(); k++){
            String temp = out.get(k);
            String[] tempArr = temp.split("->");
            if (tempArr.length == 2) {
                if (tempArr[0].equals(tempArr[1])) {
                    out.set(k, tempArr[0]);
                }
            }
        }
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        List<String> out = summaryRanges(nums);
        System.out.println(out);
    }
}
