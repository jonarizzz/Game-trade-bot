package org.trade4life.bot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.trade4life.bot.dto.RegionDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReplyMarkupKeyboardFactory {

    public static ReplyKeyboard selectRegionKeyboard(List<RegionDto> regions) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> buttons = new ArrayList<>();

        regions.forEach(regionDto -> {
            InlineKeyboardButton button = new InlineKeyboardButton(regionDto.getNameRu());
            button.setCallbackData("userRegionSelected" + regionDto.getId());
            buttons.add(button);
        });

        List<List<InlineKeyboardButton>> rows = buttons.stream()
            .map(Collections::singletonList)
            .collect(Collectors.toList());

        keyboard.setKeyboard(rows);
        return keyboard;
    }
}
