package edu.sjsu.android.temperature;

public class ConverterUtil {

    // converts to Celsius
    public static float calculate(float borrowed, float interest, int months, float insurance) {
        if(interest==0){
            float res = (borrowed/months) + insurance;
            return res;
        } else{
            float denom = (float) (1-Math.pow((1+interest),-1*months));
            float res = borrowed * (interest/denom) + insurance;
            return res;
        }
    }

}
