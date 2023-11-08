package org.trade4life.bot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.trade4life.bot.handlers.LoginHandler;
import org.trade4life.bot.service.AuthService;
import org.trade4life.bot.service.RegionService;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

@Component
public class TradeBot extends AbilityBot {

    private final LoginHandler loginHandler;

    @Autowired
    public TradeBot(AuthService authService, RegionService regionService) {
        super("960038286:AAGZZHaFHCj1VCxvkBhGTLAYYWxd7DT7JNk", "PS4 game trade bot");
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
        super.onUpdateReceived(update);
    }


    @Override
    public long creatorId() {
        return 1L;
    }

}
