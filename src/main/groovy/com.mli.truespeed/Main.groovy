package com.mli.truespeed

import com.mli.truespeed.parser.impl.EnglishParser

/**
 *
 * Created on 04/07/2017
 * @author Ming Li
 */
class Main {
    static void main(String[] args) {

        def parser = new EnglishParser()

        // one
        println parser.parse(1)

        // twenty one
        println parser.parse(21)

        // one hundred and five
        println parser.parse(105)

        // fifty six million nine hundred and forty five thousand seven hundred and eighty one
        println parser.parse(56945781)

        // nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine
        println parser.parse(999999999)
    }
}
