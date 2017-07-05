package com.mli.truespeed.parser.impl

import com.mli.truespeed.parser.AbstractParser

import static com.mli.truespeed.utils.NumUtil.EnglishNumbers
import static com.mli.truespeed.utils.NumUtil.EnglishUnits

/**
 * A parser that parses number to British english words.
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
class EnglishParser extends AbstractParser {

    /**
     * {@inheritDoc}
     */
    @Override
    ParseResult doParse(String num, int groupCount) {

        if (num.length() == 0) {
            return ParseResult.success(EnglishNumbers.first(), 0)
        }

        String[] group = new String[groupCount]
        int i = num.length(), j = group.length - 1
        while (i > 0) {
            group[j--] = num.substring(Math.max(i - 3, 0), i)
            i -= 3
        }
        def buf = "" // result
        for (int k = 0; k < groupCount; k++) {
            int v = Integer.valueOf(group[k])
            if (v >= 100) { // grouped by every 3 bits, at most 999
                buf = "${buf}${EnglishNumbers[v.intdiv(100)]} ${EnglishUnits[0]}" // sort out the bit in hundreds
                v = v % 100 // check if any bit in decade and the unit
                if (v != 0) {
                    buf = "${buf} and "
                }
            }
            if (v != 0) { // need to sort out bits in decade and the unit
                if (v < 20 || v % 10 == 0) { // if less than 20 or exact division by 10, directly get the number
                    buf = "${buf}${EnglishNumbers[v]} "
                } else { // get the bit in decade and then the unit
                    buf = "${buf}${EnglishNumbers[v - v % 10]} ${EnglishNumbers[v % 10]} "
                }
                if (k != groupCount - 1) { // Append extra unit for number greater than 100
                    buf = "${buf}${EnglishUnits[groupCount - 1 - k]} "
                }
            }
        }
        return ParseResult.success(buf.toString().trim(), groupCount)
    }
}
