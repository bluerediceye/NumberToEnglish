package com.mli.truespeed.parser

import com.mli.truespeed.parser.impl.ParseResult
import com.mli.truespeed.utils.NumUtil

import static com.mli.truespeed.utils.NumUtil.EnglishNumbers
import static com.mli.truespeed.utils.NumUtil.EnglishUnits

/**
 * Abstract parser that extracts common operations that can be used by all descendant parsers.
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
abstract class AbstractParser implements Parser {

    /**
     * {@inheritDoc}
     */
    @Override
    final ParseResult parse(long num) {
        parse(String.valueOf(num))
    }

    /**
     * {@inheritDoc}
     */
    final ParseResult parse(String num) {
        ParseResult result = validate(num)

        if (!result.success) {
            return result
        }

        return doParse(NumUtil.removeLeadingZeros(num), result.groupCount)
    }

    /**
     * Validate input number and pre-determine {@link ParseResult}
     * @param num number represented in string value
     * @return {@link ParseResult} that contains validation results
     */
    static private final ParseResult validate(String num) {

        // Check if input is numeric
        if (!num || !num.matches("\\d+")) {
            return ParseResult.fail("$num is not number")
        }

        // Remove all leading zeros
        num = NumUtil.removeLeadingZeros(num)

        if (num.length() > 9) { // number greater than 999999999 is not considered
            return ParseResult.fail("too big")
        }

        // Calculate group count
        int count = (num.length() % 3 == 0) ? num.length().intdiv(3) : num.length().intdiv(3) + 1
        if (count > EnglishUnits.length) {
            return ParseResult.fail("too big")
        }

        return ParseResult.success(count)
    }

    /**
     * This is where actual paring happens. The input number is guaranteed to be valid.
     * @param num number represented in string value
     * @param groupCount the number of group the input number can be divided into according to the target language.
     * @return
     */
    abstract ParseResult doParse(String num, int groupCount)
}
