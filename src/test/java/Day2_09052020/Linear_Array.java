package Day2_09052020;

public class Linear_Array {
    public static void main(String[] args) {
        //linear String array example
        //array always starts from 0
        String[] username = new String[] {"John","Kenneth","Milad","Naim","2"};
        String[] lastName = new String[] {"John","Kenneth","Milad","Naim","2"};

        //print second value from string array
        System.out.println("second user name is " + username[1] + " last name is " + lastName[1]);

        //linear integer array example
        int[] numbers = new int[]{2000,100,300,500};
        System.out.println("first int value is " + numbers[0]);
        //I want to get sum of first 2 data
        System.out.println("total of first two int data is " + (numbers[0] + numbers[1]));
    }//end of psvm

}//end of java class
