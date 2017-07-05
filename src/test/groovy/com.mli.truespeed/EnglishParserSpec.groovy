package com.mli.truespeed

import com.mli.truespeed.parser.impl.EnglishParser
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
class EnglishParserSpec extends Specification{

     def @Shared parser


    def setupSpec(){
        parser = new EnglishParser()
    }

    def "invalid input" (){

        when:
        def error1 = parser.parse(null).error
        def error2 = parser.parse('nothing').error
        def error3 = parser.parse('').error

        then:
        error1 == 'null is not number'
        error2 == 'nothing is not number'
        error3 == ' is not number'
    }

    def "input number is too big" (){

        when:
        def error = parser.parse(1000000000).error

        then:
        error == 'too big'
    }

    def "input number has zeros at the beginning" (){

        when:
        def result1 = parser.parse('0004000').result
        def result2 = parser.parse('000').result

        then:
        result1 == 'four thousand'
        result2 == 'zero'
    }

    @Unroll
    def 'the result of paring #x should be #y'() {
        expect:
        parser.parse(x).result == y

        where:
        x << [1, 21, 105, 56945781, 999999999]
        y << ['one',
              'twenty one',
              'one hundred and five',
              'fifty six million nine hundred and forty five thousand seven hundred and eighty one',
              'nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine']
    }
}
