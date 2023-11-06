import {Markup} from "telegraf";
import {CANCEL_BUTTON_TEXT} from "../../../constants/buttons";

export const cancelMenu =
    Markup.keyboard([CANCEL_BUTTON_TEXT])
        .oneTime()
        .resize()
        .extra()