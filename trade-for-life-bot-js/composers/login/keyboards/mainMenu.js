import {Markup} from "telegraf";
import {
    BUY_GAMES_BUTTON_TEXT,
    EXPLORE_BUTTON_TEXT,
    PERSONAL_INFO_BUTTON_TEXT,
    SELL_GAMES_BUTTON_TEXT
} from "../../../constants/buttons";

export const mainMenu =
    Markup.keyboard([BUY_GAMES_BUTTON_TEXT, SELL_GAMES_BUTTON_TEXT, PERSONAL_INFO_BUTTON_TEXT, EXPLORE_BUTTON_TEXT], {
        columns: 2
    })
        .oneTime()
        .resize()
        .extra()