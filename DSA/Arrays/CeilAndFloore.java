package DSA.Arrays;
import java.util.*;
public class CeilAndFloore {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Entetr length of Array: ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Array Elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        sc.close();
        System.err.println("Ceil of "+key+" is "+ceil(arr, key));
        System.err.println("Floore of "+key+" is 9"+floore(arr, key));
        

    }
    static int ceil(int[] arr,int key){
        int low = 0;
            int high = arr.length-1;
            int mid = 0;
        for(;low<=high;){      
            mid=(low+high)/2;      
            if(key == arr[mid]){
                return arr[mid];
            }
            else if(key<arr[mid]){
                high=mid-1;
                
            }
            else{
                low = mid+1;
            }
        }
        if(low < arr.length){
            return arr[low];
        }
        else{
            return -1;
        }
        

    }
    static int floore(int[] arr,int key){
        int low = 0;
            int high = arr.length-1;
            int mid = 0;
        for(;low<=high;){      
            mid=(low+high)/2;      
            if(key == arr[mid]){
                return arr[mid];
            }
            else if(key<arr[mid]){
                high=mid-1;
            }
            else{
                low = mid+1;
            }

        }
        if(high>=0){
            return arr[high];
        }
        else{
            return -1;
        }
    }
}
