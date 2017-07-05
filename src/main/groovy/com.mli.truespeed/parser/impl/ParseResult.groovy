package com.mli.truespeed.parser.impl

/**
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
class ParseResult {
    boolean success
    String result
    String error
    int groupCount

    /**
     * Handy method that returns failed parsing result with error
     *
     * @param error error message
     * @return {@link ParseResult}
     */
    static ParseResult fail(String error){
        new ParseResult(success: false, error: error)
    }

    /**
     * Handy method that returns success parsing result
     *
     * @param result string value of parsing result
     * @param groupCount count of groups input number can be divided into
     * @return {@link ParseResult}
     */
    static ParseResult success(String result = null, int groupCount){
        new ParseResult(success: true, result: result, groupCount: groupCount)
    }

    @Override
    String toString() {
        if(success){
            return result
        } else {
            return error
        }
    }
}
