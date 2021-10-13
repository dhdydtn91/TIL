package sortingSearching;


import java.util.ArrayList;
import java.util.List;

public class MoveZeros {
    public void  moveZeroes(int[] nums){
        int resultIndex = 0 ;
        for(int i = 0 ; i < nums.length ; i ++){
            if (nums[i] != 0) {
                nums[resultIndex] = nums[i];
                resultIndex++;
            }
        }
        for(int i = resultIndex; i < nums.length ; i++){
            nums[i] = 0;
        }
    }
}
