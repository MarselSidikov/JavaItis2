package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenizerObservable;

/**
 * Created by admin on 12.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        String text = "abb 123 abb 34 a";
        TokenizerObservable tokenizer = new Tokenizer();
        tokenizer.addTokenHandler(new TokenHandlerNumbersImpl());
        tokenizer.addTokenHandler(new TokenHandlerStandardOutputImpl());

        tokenizer.tokenize(text);
    }


}
