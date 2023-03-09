import java.util.*;

public class Arrays {
    
    // 1(function) passing array by argument or call by referance 
    public static void update(int marks[]){
        for(int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;            // add 1 marks to aa elements
        }
    }

    // 2 linear search
    public static int linearSearch(int num[], int key){
        for(int i=0; i<num.length; i++){
            if(num[i] == key){
            return i;
            }
        }    
        return -1;
    }

    // 3 largest number , smallest number
    public static int getLargest(int number[]){
        int largest = Integer.MIN_VALUE;         // -infinity
        int smallest = Integer.MAX_VALUE;        // +infinity 
        for(int i=0; i<number.length; i++){
            if(number[i] > largest){
                largest = number[i];
            }
            if(number[i] < smallest){
                smallest = number[i];
            }
        }
        System.out.println("smallest value is : " + smallest);
        return largest;
    }

    // 4 binary search find index of key(given number)
    public static int binarySearch(int nums[], int key){
        int start=0 , end=nums.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == key){
                return mid;
            }
            if(nums[mid] < key){                 //  right half
                start = mid+1;
            }
            if(nums[mid] > key){                 // left half
                end = mid-1;
            }
        }
        return -1;                               // key not exist
    }

    // 5 reverse array 
    public static void reverse(int num[]){
        int start=0, end=num.length-1;
        while(start < end){
        // swap
        int temp = num[end];
        num[end] = num[start];
        num[start] = temp;

        start++;
        end--;
        }
    } 
    
    // 6 pairs of 2 in array like (2,4) (2,6)...
    public static void pairs(int num[]){
        int tp = 0;
        for(int i=0; i<num.length; i++){
            int current = num[i];
            for(int j=i+1; j<num.length; j++){
                System.out.print("(" + current + "," + num[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.print("Total pairs = " + tp);  // tp = n(n-1)/2 here tp=7(7-1)/2=21
    }
    
    // 7 sub arrays
    public static void subArrays(int num[]){
        int tsa = 0;
        for(int i=0; i<num.length; i++){
            int start = i;
            for(int j=i; j<num.length; j++){
                int end = j;
                for(int k=start; k<=end; k++){
                    System.out.print(num[k] + " ");
                }
                tsa++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("Total sub arrays = " + tsa);      
    }

    // 8 find max sum from subarrays (brute force) TC = O(n^3) bad tc
    public static void maxSum(int num[]){
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        System.out.println("sum of all sub arrays are : ");
        for(int i=0; i<num.length; i++){
            int start = i;
            for(int j=i; j<num.length; j++){
                int end = j;
                int currSum = 0;
                for(int k=start; k<=end; k++){
                    currSum  += num[k];
                }
                System.out.print(currSum);
                System.out.println();
                if(maxSum < currSum){
                    maxSum = currSum;
                }
                if(minSum > currSum){
                    minSum = currSum;
                }
            }
        }
        System.out.println("max sum is = " + maxSum);
        System.out.println("min sum is = " + minSum);
    }

    // 9 max sum from sub array (prefix array method) TC = O(n^2)
    public static void maximumSum(int num[]){
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];
        // making prefix array
        prefix[0] = num[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + num[i];
        }
        for(int i=0; i<num.length; i++){
            int start = i;
            for(int j=i; j<num.length; j++){
                int end = j;
                int currSum = 0;
                for(int k=start; k<=end; k++){
                    currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                }
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum from all sub arrays is : " + maxSum);
    }

    // 10 max sum from subarray (kadane's algorithm method)
    public static void kadanes(int num[]){
        int ms = Integer.MIN_VALUE; // maxsum
        int cs = 0;                 // currSum
        for(int i=0; i<num.length; i++){
            cs = cs + num[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println("maximum sum from all subarrays is = " + ms);
    }

    // 11 trapped rain water    TC = O(n) n=num of array elements
    public static int trapRainWater(int height[]){
        int n = height.length;
        // calc left max boundary-array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // calc right max boundary-array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int trappedWater = 0;
        // loop
        for(int i=0; i<n; i++){
        // water level
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
        // trapped rain water
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    // 12 buy and sell stocks   TC = O(n) n=num of array elements
    public static int buyAndSell(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
 

  
   
    // MAIN FUNCTION
        public static void main(String...arg){
        Scanner sc = new Scanner(System.in);
       
        // simple array 
        // int marks[] = new int[50];            // declare array
        // System.out.println("Enter marks of PCM respectively : ");
        // marks[0] = sc.nextInt();              // intput the values of array
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();
        // System.out.println("physics = " + marks[0]);
        // System.out.println("chemestry = " + marks[1]);
        // System.out.println("maths = " + marks[2]);

        // 1 passing array by argument or call by referance
        // int marks[] = {99, 98, 97};
        // update(marks);
        // for(int i=0; i<marks.length; i++){
        //       System.out.print(marks[i] + " ");         
        // }
        // System.out.println();

        // 2 linear search
        // int num[] = {2,3,4,5,6,34,2,7,9,45};
        // int key = 34;
        // int index = linearSearch(num, key);
        // if(index == -1){
        //     System.out.println("not found");
        // } else{
        //     System.out.println("key is at index : " + index);
        // }

        // 3 largest number 
        // int number[] = {1,4,6,3,7,2,5};
        // System.out.print("largest number is : " + getLargest(number)); 

        // 4 binary search
        // int nums[] = {2,4,6,8,10,12,14};
        // int key = 12;
        // System.out.print("index of key is : " + binarySearch(nums,key));

        // 5 reverse array
        // int num[] = {2,4,6,8,10,12,14};
        // reverse(num);
        // for(int i=0; i<num.length; i++){
        //     System.out.print(num[i] + " ");
        // }

        // 6 pairs of 2 in array           tc=O(n^2)
        // int num[] = {2,4,6,8,10,12,14};
        // pairs(num);

        // 7 sub arrays
        // int num[] = {2,4,6,8,10};
        // subArrays(num);

        // 8 max sum of subArrays
        // int num[] = {3,-2,5,4,1,6};
        // maxSum(num);

        // 9 max sum of subArrays prefix array method
        //  int num[] = {3,-2,5,4,1,6};
        //  maximumSum(num);

        // 10 kanade's algorithm
        // int num[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // kadanes(num);

        // 11 trapped rain water
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        // System.out.println("trapped water's volume is = " + trapRainWater(height)); 

        // 12 buy and sell stocks
        // int prices[] = {7, 1, 5, 3, 6, 4};
        // System.out.println("maximum profit is : " + buyAndSell(prices));


    }
}
