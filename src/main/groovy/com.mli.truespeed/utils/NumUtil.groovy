package com.mli.truespeed.utils

/**
 *
 * Number util that stores all numeric vocabularies in languages.
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
class NumUtil {

    /**
     * English numeric words
     */
    public static final String[] EnglishNumbers = [
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "", "", "", "", "", "", "", "", "", "thirty", "", "", "",
            "", "", "", "", "", "", "forty", "", "", "", "", "", "", "", "",
            "", "fifty", "", "", "", "", "", "", "", "", "", "sixty", "", "",
            "", "", "", "", "", "", "", "seventy", "", "", "", "", "", "", "",
            "", "", "eighty", "", "", "", "", "", "", "", "", "", "ninety"]

    /**
     * English numeric unit
     */
    public static final String[] EnglishUnits = ["hundred", "thousand", "million"/*, "billion", "trillion", "quintillion"*/]

    static String removeLeadingZeros(String num){
        return num?.replaceAll("^[0]*([1-9]*)", "\$1")
    }
}
