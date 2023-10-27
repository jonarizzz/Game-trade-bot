import WizardScene from 'telegraf/scenes/wizard';
import {mainMenu} from "../../../keyboard/keyboard";
import {loginUser} from "../utils/loginUser";
import {getListOfRegions} from "../utils/regionUtils";
import {regionsMenu} from "../keyboards/selectRegionKeyboard";
import {FIRST_LOGIN_GREETING, GREETING_TEXT} from "../../../constants/messages";


export const loginScene = new WizardScene('loginScene',
    (ctx) => {
        let userInfo = ctx.update.message.from;


        loginUser(userInfo)
            .then(loginResult => {
                ctx.session.userId = loginResult.data.userId;


                if (loginResult.data.new === true) {
                    getListOfRegions()
                        .then(regionsResponse => {
                            let regions = regionsResponse.data.regions;
                            ctx.session.regions = regions;
                            ctx.reply(FIRST_LOGIN_GREETING, {reply_markup: regionsMenu(regions)});
                        });

                } else {
                    ctx.reply(GREETING_TEXT, mainMenu).then();
                }
            })
        return ctx.scene.leave();
    }

)