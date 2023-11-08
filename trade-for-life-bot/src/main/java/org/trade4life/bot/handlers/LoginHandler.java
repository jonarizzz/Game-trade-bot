package org.trade4life.bot.handlers;

import lombok.RequiredArgsConstructor;
import org.telegram.abilitybots.api.objects.MessageContext;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.trade4life.bot.dto.LoginRequestDto;
import org.trade4life.bot.dto.LoginResponseDto;
import org.trade4life.bot.dto.RegionDto;
import org.trade4life.bot.service.AuthService;
import org.trade4life.bot.service.RegionService;

import java.util.List;

import static org.trade4life.bot.constant.Messages.FIRST_TIME_LOGIN_CHOOSE_REGION_TEXT;
import static org.trade4life.bot.constant.Messages.GREETING_TEXT;
import static org.trade4life.bot.keyboard.ReplyMarkupKeyboardFactory.selectRegionKeyboard;

@RequiredArgsConstructor
public class LoginHandler {

    private final SilentSender sender;

    private final AuthService authService;
    private final RegionService regionService;


    public void handleLogin(MessageContext messageContext) {

        String userTelegramId = String.valueOf(messageContext.user().getId());
        String userName = messageContext.user().getFirstName() +
                (messageContext.user().getLastName() == null ? "" : " " + messageContext.user().getLastName());
        String userNickname = messageContext.user().getUserName();

        LoginResponseDto loginResponse = authService.loginUser(LoginRequestDto.builder()
            .telegramId(userTelegramId)
            .name(userName)
            .nickname(userNickname)
            .build());

        if (loginResponse.getIsNew()) {
            List<RegionDto> regions = regionService.getListOfRegions();
            SendMessage message = new SendMessage();
            message.setChatId(messageContext.chatId());
            message.setText(FIRST_TIME_LOGIN_CHOOSE_REGION_TEXT);
            message.setReplyMarkup(selectRegionKeyboard(regions));
            sender.execute(message);

//            request list of regions => send to user => collect his choice => perform set user region in core
            // else greetings again message and main keyboard
        } else {
            SendMessage message = new SendMessage();
            message.setChatId(messageContext.chatId());
            message.setText(GREETING_TEXT(userNickname));
            // TODO: attach main menu
            sender.execute(message);
        }

    }
}
