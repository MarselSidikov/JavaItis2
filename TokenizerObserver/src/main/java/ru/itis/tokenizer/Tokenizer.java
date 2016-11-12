package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.observer.TokenizerObservable;
import ru.itis.tokenizer.tokens.Number;
import ru.itis.tokenizer.tokens.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements TokenizerObservable {

    // ассоциативный массив, где ключем является название обработчика токенов
    // а значением - сам обработчик
    private Map<String, TokenHandler> handlers;

    public Tokenizer() {
        handlers = new HashMap<String, TokenHandler>();
    }

    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getName(), handler);
    }

    public void removeTokenHandler(String handlerName) {
        handlers.remove(handlerName);
    }

    public void notifyHandlers(Token token) {
        // получаем множество ключей-значений из мапа
        Set<Map.Entry<String, TokenHandler>> entries =
                handlers.entrySet();

        // на каждой итерации цикла мы в entity кладем значение из entries
        for (Map.Entry<String, TokenHandler> entity : entries) {
            // из текущего entity забираем значение - обработчик
            TokenHandler currentHandler = entity.getValue();
            // оповещаем обработчик
            currentHandler.handleToken(token);
        }
    }

    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        boolean onNumber = false;
        String currentToken = "";
        for (int i = 0; i < textAsCharArray.length; i++) {
            Token currentNumber = new Number();
            if (Character.isDigit(textAsCharArray[i])) {

                if (!onNumber) {
                    onNumber = true;
                    currentToken += textAsCharArray[i];
                } else {
                    currentToken += textAsCharArray[i];
                }

            } else {
                if (onNumber) {
                    currentNumber.setText(currentToken);
                    onNumber = false;
                    currentToken = "";
                    notifyHandlers(currentNumber);
                }
            }
        }
    }
}
























