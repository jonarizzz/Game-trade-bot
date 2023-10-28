import WizardScene from 'telegraf/scenes/wizard';
import {loginUser} from "../utils/loginUser";
import {getListOfRegions} from "../utils/regionUtils";
import {regionsMenu} from "../keyboards/selectRegionKeyboard";
import {FIRST_LOGIN_GREETING, GREETING_TEXT} from "../../../constants/messages";
import {mainMenu} from "../keyboards/mainMenu";
import {
    USER_FIRST_TIME_LOGIN_IS_SUCCESSFUL,
    USER_LOGIN_IS_ATTEMPTED,
    USER_LOGIN_IS_SUCCESSFUL
} from "../../../constants/logs";
import {logger} from "../../../app";

export const loginScene = new WizardScene('loginScene',
    (ctx) => {
        let userInfo = ctx.update.message.from;
        let userNickname = userInfo.username;
        let userTelegramId = userInfo.id;

        logger.debug(USER_LOGIN_IS_ATTEMPTED(userNickname, userTelegramId));

        loginUser(userInfo)
            .then(loginResult => {
                let userId = loginResult.data.userId;
                ctx.session.userId = userId;

                if (loginResult.data.new === true) {
                    logger.debug(USER_FIRST_TIME_LOGIN_IS_SUCCESSFUL(userNickname, userTelegramId, userId));
                    getListOfRegions()
                        .then(regionsResponse => {
                            let regions = regionsResponse.data.regions;
                            ctx.session.regions = regions;
                            ctx.reply(FIRST_LOGIN_GREETING, {reply_markup: regionsMenu(regions)});
                        });

                } else {
                    logger.debug(USER_LOGIN_IS_SUCCESSFUL(userNickname, userTelegramId, userId));
                    ctx.reply(GREETING_TEXT(userNickname), mainMenu).then();
                }
            })
        return ctx.scene.leave();
    }

)