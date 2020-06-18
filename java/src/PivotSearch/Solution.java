package PivotSearch;

class Solution {
    int foundDurPivot = -1;
    public int search(int[] nums, int target) {
        if(nums.length == 0){return -1;}
        if(nums.length == 1 ){
            if(nums[0] == target){return 0;}
            return -1;
        }
        if(nums.length == 2){
            if(nums[0] == target){return 0;}
            if (nums[1] == target){return 1;}
            return -1;
        }
        if(nums[nums.length-1] < nums[0]){
            int pivot = locatePivot(nums,target);
            if(foundDurPivot!= -1){return foundDurPivot;}
            if(target > nums[nums.length -1]){
                return binarySearch(nums,0,pivot -1,target);
            }
            else{
                return binarySearch(nums,pivot,nums.length -1 ,target);
            }
        }
        else{
            return binarySearch(nums,0,nums.length -1, target);
        }
    }

    public int binarySearch(int[] nums, int l , int r, int x){
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == x){
                return mid;
            }

            else if (x < nums [mid]){
                r = mid -1;
            }
            else if(x > nums[mid]){
                l = mid +1;
            }

        }
        return -1;
    }
    public int locatePivot(int[]nums,int target){
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == target){
                foundDurPivot = i;
            }
            if(nums[i-1] > nums[i]){
                return i;
            }
        }
        return -1;
    }
}