package org.trade4life.bot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.trade4life.bot.handlers.LoginHandler;
import org.trade4life.bot.service.AuthService;
import org.trade4life.bot.service.RegionService;
import org.trade4life.bot.service.UserService;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;
import static org.trade4life.bot.constant.Messages.FIRST_LOGIN_SUCCESSFUL_TEXT;

@Component
public class TradeBot extends AbilityBot {

    private final LoginHandler loginHandler;
    private final UserService userService;


    @Autowired
    public TradeBot(AuthService authService, RegionService regionService, UserService userService) {
        super("960038286:AAGZZHaFHCj1VCxvkBhGTLAYYWxd7DT7JNk", "PS4 game trade bot");
        this.userService = userService;
        this.loginHandler = new LoginHandler(silent, authService, regionService);
    }

    public Ability startAbility() {
        return Ability
            .builder()
            .name("start")
            .info("Start command description")
            .input(0)
            .locality(USER)
            .privacy(PUBLIC)
            .action(loginHandler::handleLogin)
            .build();
    }
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String action = callbackQuery.getData();

            if (action.startsWith("userRegionSelected")) {
                String regionIdString = action.replace("userRegionSelected", "");
                Long userTelegramId = update.getCallbackQuery().getFrom().getId();
                Long regionId = Long.parseLong(regionIdString);
                userService.setUserRegion(userTelegramId, regionId);

                SendMessage message = new SendMessage();
                message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                message.setText(FIRST_LOGIN_SUCCESSFUL_TEXT);
                silent.execute(message);
            }

        }

        if (update.hasMessage() && update.getMessage().hasText()) {
            // Handle text messages from the user
        }

        super.onUpdateReceived(update);
    }


    @Override
    public long creatorId() {
        return 1L;
    }

}
