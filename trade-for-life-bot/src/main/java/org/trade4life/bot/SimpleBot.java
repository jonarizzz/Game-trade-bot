package org.trade4life.bot;


import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

@Component
public class SimpleBot extends AbilityBot {

    private final ResponseHandler responseHandler;

    public SimpleBot() {
        super("960038286:AAGZZHaFHCj1VCxvkBhGTLAYYWxd7DT7JNk", "PS4 game trade bot");
        this.responseHandler = new ResponseHandler(silent);
    }

    public Ability startAbility() {
        return Ability
            .builder()
            .name("start")
            .info("Start command description")
            .input(0)
            .locality(USER)
            .privacy(PUBLIC)
            .action(ctx -> responseHandler.replyToStart(ctx.chatId()))
            .build();
    }



    @Override
    public long creatorId() {
        return 1L;
    }

}
