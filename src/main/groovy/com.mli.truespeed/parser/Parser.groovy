package com.mli.truespeed.parser

import com.mli.truespeed.parser.impl.ParseResult

/**
 *
 * Parser interface that defines common operations.
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
interface Parser {
    /**
     * Parse long number to natural language string stored in {@link ParseResult}
     * @param num long number
     * @return {@link ParseResult} that contains parsed results
     */
    ParseResult parse(long num)

    /**
     * Parse number represented in string value to natural language string stored in {@link ParseResult}.
     * @param num number represented in string
     * @return {@link ParseResult} that contains parsed results
     */
    ParseResult parse(String num)
}