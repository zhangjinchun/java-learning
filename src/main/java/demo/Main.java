package demo;

import java.util.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer(); //断点
        stringBuffer.append("hello");
        stringBuffer.append("hello11");
        stringBuffer.append("hello22");

        String nullStr = null;
        stringBuffer.append(nullStr);
    }

}

