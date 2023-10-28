import WizardScene from 'telegraf/scenes/wizard';
import {
    CHOOSE_FROM_THE_LIST_TEXT,
    SELL_GAME_NAME,
} from "../constants/constants";
import {getTheListOfGamesByName} from "../utils/getListOfGamesByName";
import {proposedTitlesMenu} from "../keyboards/proposedTitlesMenu";
import {CANCEL_BUTTON_TEXT} from "../../../constants/buttons";
import {cancelMenu} from "../../login/keyboards/cancelMenu";
import {mainMenu} from "../../login/keyboards/mainMenu";


export const findGameScene = new WizardScene('findGameScene',
    (ctx) => {
        ctx.reply(SELL_GAME_NAME, cancelMenu);
        return ctx.wizard.next();
    },
    (ctx) => {
        let gameName = ctx.message.text;

        if (gameName === CANCEL_BUTTON_TEXT){
            ctx.reply('Canceled', mainMenu);
            return ctx.scene.leave();
        }

        getTheListOfGamesByName(gameName)
            .then(response => {
                ctx.session.listOfGames = response.data.games;
                ctx.reply(CHOOSE_FROM_THE_LIST_TEXT,
                    {reply_markup: proposedTitlesMenu(response.data.games)}).then();
                return ctx.scene.leave();
            })
    });