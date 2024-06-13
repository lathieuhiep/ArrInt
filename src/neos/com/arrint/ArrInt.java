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

    // phương thức in dãy con kề nhau liên tiếp dài nhất có tổng <20
    public void printCouple() {
        int[][] coupleArr = new int[9][10];
        int[] coupleLengthArr = new int[9];

        System.out.println("Dãy con kề nhau liên tiếp có tổng < 20");

        // tập dãy con kề nhau có tổng < 20
        for (int i = 0; i < arrInt.length - 1; i++) {
            int currentSum = arrInt[i];
            int indexCol = 0;
            int coupleLength = 0;

            coupleArr[i][indexCol] = arrInt[i];

            for (int j = i + 1; j < arrInt.length; j++) {
                indexCol ++;
                coupleLength ++;
                currentSum += arrInt[j];

                if (currentSum < 20) {
                    coupleArr[i][indexCol] =  arrInt[j];
                } else {
                    break;
                }
            }

            coupleLengthArr[i] = coupleLength;
        }

        // in dãy con có tổng < 20
        for (int i = 0; i < coupleArr.length; i++) {
            int sum = 0;

            for (int j = 0; j < coupleArr.length; j++) {
                if ( coupleArr[i][j] != 0 ) {
                    sum += coupleArr[i][j];

                    System.out.print(coupleArr[i][j] + " ");
                }
            }

            System.out.print("=> tổng = " + sum + "\n");
        }

        // tìm dãy con có tổng < 20 dài nhất
        int maxLengthCouple = coupleLengthArr[0];
        int biggestPosition = 0;

        for (int i = 0; i < coupleLengthArr.length; i++) {
            int coupleLength = coupleLengthArr[i];

            if (maxLengthCouple < coupleLength) {
                maxLengthCouple = coupleLength;
                biggestPosition = i;
            }
        }

        // in kết quả dãy dài nhất
        System.out.print("=> KẾT QUẢ: Dãy hợp lệ dài nhất là: ");
        int sumCoupleArr = 0;

        for (int i = 0; i < coupleArr[biggestPosition].length; i++) {
            if (coupleArr[biggestPosition][i] != 0) {
                sumCoupleArr += coupleArr[biggestPosition][i];
                System.out.print( coupleArr[biggestPosition][i] + " " );
            }
        }

        System.out.println("==> tổng = " + sumCoupleArr);
    }
}
