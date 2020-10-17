package Day2_09052020;

public class for_loop {
    public static void main(String[] args) {
        //dynamic array example with String data
        String[] zipCode = new String[8]; //defining and setting boundary for array values
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "10001";
        zipCode[3] = "11201";
        zipCode[4] = "11217";
        zipCode[5] = "11216";
        zipCode[6] = "11215";
        zipCode[7] = "11214";

        //iterate through all of zipcode data and print each one

        /* .length command is useful to use so you don't need to
            hard code your end point on i < whatever the end point is
         */
        System.out.println("my array list is " + zipCode.length);

        for(int i = 0;i < zipCode.length;i++){ // ++ is same as +1 by default
            //code goes here
            //System.out.println("My zipcode is " + zipCode[i]);
            if(zipCode[i] == "11218"){
                System.out.println("My zipcode is " + zipCode[i]);
            }
            if(zipCode[i] == "11215"){
                System.out.println("My zipcode is " + zipCode[i]);
            }
            //i = i+1; //this is to skip specific index(s) from array
        }//end of for loop

    }//end of main method
}//end of class
