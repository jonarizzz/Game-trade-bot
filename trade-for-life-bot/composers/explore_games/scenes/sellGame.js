import {COST_VALIDATION_ERROR_MESSAGE, ERROR_PLACING_OFFER, SELL_GAME_COST, SELL_GAME_TEXT} from "../constants/constants";
import WizardScene from 'telegraf/scenes/wizard';
import {placeOffer} from "../utils/placeOffer";
import {CANCEL_BUTTON_TEXT} from "../../../constants/buttons";
import {cancelMenu} from "../../login/keyboards/cancelMenu";
import {mainMenu} from "../../login/keyboards/mainMenu";

export const sellGameFromExploreScene = new WizardScene('sellGameFromExploreScene',
    (ctx) => {
        ctx.reply(SELL_GAME_COST, cancelMenu);
        return ctx.wizard.next();
    },
    (ctx) => {

        let gameName = ctx.scene.state.gameName;
        let gameId = ctx.scene.state.gameId;
        let gameCost = ctx.message.text;

        if (!isNaN(+gameCost.trim().replace(",", "."))){

            placeOffer(gameId, ctx.message.from.username, gameCost)
                .catch(() => {
                    ctx.reply(ERROR_PLACING_OFFER);
                })
                .then(() => {
                    ctx.reply(SELL_GAME_TEXT(gameName, gameCost), mainMenu);
                })
        } else if (gameCost === CANCEL_BUTTON_TEXT){
            ctx.reply('Canceled', mainMenu);
        } else {
            ctx.reply(COST_VALIDATION_ERROR_MESSAGE, mainMenu);
        }
        return ctx.scene.leave();
    });