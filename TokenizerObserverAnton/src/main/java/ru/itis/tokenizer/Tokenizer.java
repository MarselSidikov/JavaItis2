package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.observer.TokenizerObservable;
import ru.itis.tokenizer.tokens.Number;
import ru.itis.tokenizer.tokens.Separator;
import ru.itis.tokenizer.tokens.Token;
import ru.itis.tokenizer.tokens.Letter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements TokenizerObservable {

    // ассоциативный массив, где ключем является название обработчика токенов
    // а значением - сам обработчик
    private Map<Class, TokenHandler> handlers;

    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n\t ";

    public Tokenizer() {
        handlers = new HashMap<Class, TokenHandler>();
    }

    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getWorkClass(), handler);
    }

    public void removeHandlerByWorkClass(Class tokenClass) {
        handlers.remove(tokenClass);
    }

    public void notifyHandlers(Token token) {
        // получаем множество ключей-значений из мапа
        Set<Map.Entry<Class, TokenHandler>> entries =
                handlers.entrySet();

//         на каждой итерации цикла мы в entity кладем значение из entries
        for (Map.Entry<Class, TokenHandler> entity : entries) {
            // из текущего entity забираем значение - обработчик
            TokenHandler currentHandler = entity.getValue();
            // оповещаем обработчик
            currentHandler.handleToken(token);

        }
//        TokenHandler currentHandler = handlers.get(token.getClass());
//        currentHandler.handleToken(token);
//
//        handlers.get(Token.class).handleToken(token);

    }

    public void tokenize(String text) {
        // конвертируем строку в массив символов
        char[] textAsCharArray = text.toCharArray();
        // флаги - на числе мы, или на слове
        boolean onNumber = false;
        boolean onWord = false;
        // StringBuilder - (изучить), текущий просматриваемый токен
        StringBuilder currentToken = new StringBuilder();
        // начало текущего токена
        int begin = 0;
        // идем по всем символам
        for (int i = 0; i < textAsCharArray.length; i++) {
            // берем текущий символ
            char c = textAsCharArray[i];
            // проверяем, бука ли это
            if (Character.isLetter(c)) {
                if (!onWord) {
                    begin = i;
                }
                // ПРИСОЕДИНЯЕМ БУКВУ К ТОКЕНУ
                currentToken.append(c);
                // МЫ СЕЙЧАС НА БУКВУ
                onWord = true;
                // если мы в конце текста - создаем токен и сразу оповещаем всех
                if (textAsCharArray.length-1 == i)
                    notifyHandlers(new Letter(begin, i, currentToken.toString(),Character.isUpperCase(currentToken.charAt(0))));
            }
            // если мы были на слове
            else if (onWord) {
                // сейчас мы не на слове
                onWord = false;
                i -= 1;
                notifyHandlers(new Letter(begin, i, currentToken.toString(),Character.isUpperCase(currentToken.charAt(0))));
                currentToken.delete(0,currentToken.length());
                continue;
            }
            if (Character.isDigit(c)) {
                begin = !onNumber ? i : begin;
                currentToken.append(c);
                onNumber = true;
                if (textAsCharArray.length-1==i)
                    notifyHandlers(new Number(begin, i, currentToken.toString(), Integer.valueOf(currentToken.toString())));
            } else if (onNumber) {
                onNumber = false;
                i -= 1;
                notifyHandlers(new Number(begin, i, currentToken.toString(), Integer.valueOf(currentToken.toString())));
                currentToken.delete(0,currentToken.length());
                continue;
            }
            if (PUNCT.contains(String.valueOf(c))) {
                notifyHandlers(new Separator(i, i, String.valueOf(c), c));
            }
        }
    }
}
























