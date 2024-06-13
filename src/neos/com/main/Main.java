package neos.com.main;

import neos.com.arrint.ArrInt;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 5, 5, 1, 4, 9, 9, 3};
        ArrInt arrInt = new ArrInt(arr);

        // gọi phương thức in phần tử
        arrInt.printArr();

        // gọi phương thức in số chia hết cho nhiều số khác nhất
        arrInt.printPerfectNumber();

        //
        arrInt.printCouple();
    }
}
