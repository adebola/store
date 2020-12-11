package io.factorialsystems.store.util;

public class NumberToWordConverter {
    public static String convert(int number) {

        // variable to hold string representation of number
        String words = "";

        String unitsArray[] = { "zero", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };

        String tensArray[] = { "Zero", "Ten", "Twenty", "Thirty", "Fourty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety" };

        if (number == 0) {
            return "Zero";
        }

        // add minus before conversion if the number is less than 0
        if (number < 0) {
            // convert the number to a string
            String numberStr = "" + number;
            // remove minus before the number
            numberStr = numberStr.substring(1);
            // add minus before the number and convert the rest of number
            return "minus " + convert(Integer.parseInt(numberStr));
        }

        // check if number is divisible by 1 million
        if ((number / 1000000) > 0) {
            words += convert(number / 1000000) + " Million ";
            number %= 1000000;
        }

        // check if number is divisible by 1 thousand
        if ((number / 1000) > 0) {
            words += convert(number / 1000) + " Thousand ";
            number %= 1000;
        }

        // check if number is divisible by 1 hundred
        if ((number / 100) > 0) {
            words += convert(number / 100) + " Hundred ";
            number %= 100;
        }

        if (number > 0) {
            // check if number is within teens
            if (number < 20) {
                // fetch the appropriate value from unit array
                words += unitsArray[number];
            } else {
                // fetch the appropriate value from tens array
                words += tensArray[number / 10];
                if ((number % 10) > 0) {
                    words += "-" + unitsArray[number % 10];
                }
            }
        }

        return words;
    }
}
