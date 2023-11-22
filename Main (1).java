import java.util.Scanner;
import java.util.*;
class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int numCows= sc.nextInt();
      int numBuses = sc.nextInt();
      int capacityPerBus = sc.nextInt();

      int[] cowArrivalTimes= new int[numCows];
      for(int i=0;i<numCows;i++){
        cowArrivalTimes[i]=sc.nextInt();
      }

    Arrays.sort(cowArrivalTimes);
    int left=0;
    int right=cowArrivalTimes[cowArrivalTimes.length-1];
    while(left<=right){
      int mid=(left+right)/2;
      if(hasBus(mid,cowArrivalTimes,numBuses,capacityPerBus)){
        right=mid-1;
      } else{
        left=mid+1;
      }
    }
    System.out.println(left);
  }


  private static boolean hasBus(int minWaitTime, int[]cowArrivalTimes,int numBuses, int capacityPerBus){
    int firstCowArrival=cowArrivalTimes[0];
    int busesUsed=1;
    int currBusCapacity=0;
    for(int i=0;i<cowArrivalTimes.length;i++){
      if(cowArrivalTimes[i]-firstCowArrival>minWaitTime||currBusCapacity >=capacityPerBus){
        busesUsed++;
        currBusCapacity=0;
        firstCowArrival=cowArrivalTimes[i];
      }
      currBusCapacity++;
    }
    return busesUsed<=numBuses;
  }
  
}