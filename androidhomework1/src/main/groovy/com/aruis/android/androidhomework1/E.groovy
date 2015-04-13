package com.aruis.android.androidhomework1

/**
 * Created by liurui on 15/4/11.
 */
enum E {
    POINT('.'),
    ZERO('0'),
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),

    PLUS('+'),
    MINUS('-'),
    MULTIPLY('×'),
    DIVIDE('÷'),
    EQUAL('='),

    AC('ac'),
    PN('+/-'),
    PER('%')


    private String text

    E(String text) {
        this.text = text
    }


    String toString() {
        text
    }
}