package org.audience.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * author:Audience
 * date:2018/9/10
 * time:15:56
 */

public class RandomParams {
    static Logger logger=Logger.getLogger(RandomParams.class);

    private static String[] telFirst = "130,131,132,133,134,135,136,137,138,139,150,151,152,157,158,159,155,156,153,180,188".split(",");

    private static int getNum(int start,int end){
        return (int)(Math.random()*(end-start+1)+start);
    }

    public static String getTel(){
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

}
