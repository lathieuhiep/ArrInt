package neos.com.arrint;

import java.util.Arrays;

public class ArrInt {
    private int[] arrInt;

    public ArrInt(int[] arrInt) {
        this.arrInt = arrInt;
    }

    // phương thức in phần tử mảng
    public void printArr() {
        System.out.println("Phần tử mảng: " + Arrays.toString(arrInt));
    }

    // phương thức in số chia hết cho nhiều số khác nhất
    public void printPerfectNumber() {
        System.out.println("Số chia hết cho nhiều số khác nhất:");

        StringBuilder divisors = new StringBuilder();
        StringBuilder divisorTotal = new StringBuilder();

        // tìm các số chia hết cho nhiều số khác nhất
        for (int i = 0; i < arrInt.length; i++) {
            int number = arrInt[i];
            int divisorCount = 0;

            for (int j = 0; j < arrInt.length; j++) {
                int divisor = arrInt[j];

                if ( number != divisor && number % divisor == 0 ) {
                    divisorCount ++;
                }
            }

            if (divisors.indexOf(number + "") == -1 && divisorCount >= 2) {
                divisors.append(number);
                divisorTotal.append(divisorCount);
            }
        }

        // tìm số có tổng số chia hết lớn nhất
        if (!divisorTotal.isEmpty()) {
            StringBuilder targetIndexTotalChars = getStringBuilder(divisorTotal, divisors);

            System.out.println(targetIndexTotalChars);
        } else {
            System.out.println("Không có số hoàn hảo");
        }
    }

    private static StringBuilder getStringBuilder(StringBuilder divisorTotal, StringBuilder divisors) {
        char maxDivisorTotal = divisorTotal.charAt(0);
        StringBuilder maxDivisorTotalChars = new StringBuilder();
        StringBuilder targetIndexTotalChars = new StringBuilder();

        for (int i = 0; i < divisorTotal.length(); i++) {
            char total = divisorTotal.charAt(i);

            if (maxDivisorTotal < total) {
                maxDivisorTotal = total;
                maxDivisorTotalChars.append(total);
                targetIndexTotalChars.append(divisors.charAt(i));

            } else if (maxDivisorTotal == total) {
                maxDivisorTotalChars.append(total);
                targetIndexTotalChars.append(divisors.charAt(i));
            }
        }
        return targetIndexTotalChars;
    }
}
