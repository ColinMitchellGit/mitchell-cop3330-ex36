/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Colin Mitchell
 */

package ex36;
import java.util.*;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class App
{
    public static void main( String[] args )
    {
        int[] nums = {};

        startNumLoop(nums);
    }

    public static void startNumLoop(int[] nums) {
        Scanner input = new Scanner(System.in);
        int num;
        String temp;

        do {
            while(true){
                try{
                    System.out.print("Enter a number: ");
                    temp = input.nextLine();
                    if(temp.equals("done")) {
                        break;
                    }
                    num = parseInt(temp);

                    break;
                }catch(Exception e) {
                    System.out.println("Invalid input.");
                }
            }

            if(temp.equals("done")) {
                calculateFunctions(nums);
            }
            else{
                num = parseInt(temp);

                nums = Arrays.copyOf(nums, nums.length + 1);
                nums[nums.length - 1] = num;
            }
        }while(!temp.equals("done"));
    }

    public static void calculateFunctions(int[] nums) {
        double average = average(nums);
        int min = min(nums);
        int max = max(nums);
        double std = std(nums);

        System.out.print("Numbers: ");

        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();

        System.out.println("The average is " + average);
        System.out.println("The minimum is " + min);
        System.out.println("The maximum is " + max);
        System.out.println("The standard deviation is " + String.format("%.2f", std));
    }

    public static double average(int[] nums) {
        double temp = 0;

        for(int i = 0; i < nums.length; i++) {
            temp += nums[i];
        }

        return temp / nums.length;
    }

    public static int min(int[] nums) {
        int min = MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    public static int max(int[] nums) {
        int max = MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static double std(int[] nums) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = nums.length;

        for(double num : nums) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: nums) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}