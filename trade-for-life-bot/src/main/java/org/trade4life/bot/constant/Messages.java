package org.trade4life.bot.constant;

public class Messages {

    public static final String FIRST_TIME_LOGIN_CHOOSE_REGION_TEXT = """
        Привет! Это - телеграм бот, предназначеный для обмена играми для PS4!\s
        Бот в разработке, так что может не работать часть функций или все функции вообще.\s

        Для начала  выберите свой регион (имейте ввиду, что на данный момент доступно ограниченное количество регионов)
        """;

    public static String GREETING_TEXT(String userNickname) {
        return String.format("С возвращением, %s! Приятного пользования!", userNickname);
    }

}
