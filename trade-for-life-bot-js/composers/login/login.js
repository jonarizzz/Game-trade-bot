import {Composer, Stage} from "telegraf";
import {setUserRegion} from "./utils/setUserRegion";
import {loginScene} from "./scenes/loginScene";
import {REGION_PROPOSITION_SIZE} from "../../config/params";
import {FIRST_LOGIN_SUCCESSFUL_TEXT, SET_USER_REGION_FAILED_TEXT} from "../../constants/messages";
import {mainMenu} from "./keyboards/mainMenu";
import {
    SET_USER_REGION_IS_ATTEMPTED, SET_USER_REGION_IS_FAILED,
    USER_REGION_IS_SET,
    USER_STARTED_THE_BOT
} from "../../constants/logs";
import {logger} from "../../config/loggerConfig";

export const loginComposer = new Composer();
const stage = new Stage([loginScene]);
loginComposer.use(stage.middleware());

loginComposer.start(ctx => {
    logger.info(USER_STARTED_THE_BOT(ctx.update.message.from.username));
    ctx.scene.enter('loginScene').then();
});

for (let i = 0; i < REGION_PROPOSITION_SIZE; i++) {
    loginComposer.action('userRegionSelected' + i, ctx => {

        let userId = ctx.session.userId;
        let regionId = ctx.session.regions.at(i).id;
        let userNickname = ctx.session.userNickname;
        let regionNameRu = ctx.session.regions.at(i).nameRu;
        let regionCurrencyCode = ctx.session.regions.at(i).currency;

        logger.debug(SET_USER_REGION_IS_ATTEMPTED(userId, regionId));

        setUserRegion(userId, regionId)
            .then(() => {
                logger.debug(USER_REGION_IS_SET(userId, regionId));
                ctx.reply(FIRST_LOGIN_SUCCESSFUL_TEXT(userNickname, regionNameRu, regionCurrencyCode), mainMenu).then();
            })
            .catch((error) => {
                logger.error(SET_USER_REGION_IS_FAILED(userId, regionId, error));
                ctx.reply(SET_USER_REGION_FAILED_TEXT).then();
            });

    });
}

