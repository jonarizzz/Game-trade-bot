import {Composer, Stage} from "telegraf";
import {setUserRegion} from "./utils/setUserRegion";
import {mainMenu} from "../../keyboard/keyboard";
import {loginScene} from "./scenes/loginScene";
import {REGION_PROPOSITION_SIZE} from "../../constants/params";
import {FIRST_LOGIN_SUCCESSFUL_TEXT} from "../../constants/messages";

export const loginComposer = new Composer();
const stage = new Stage([loginScene]);
loginComposer.use(stage.middleware());

loginComposer.start(ctx => {
    ctx.scene.enter('loginScene').then();
});

for (let i = 0; i < REGION_PROPOSITION_SIZE; i++) {
    loginComposer.action('userRegionSelected' + i, ctx => {

        let userId = ctx.session.userId;
        let regionId = ctx.session.regions.at(i).id;

        setUserRegion(userId, regionId)
            .then(() => {
                console.log('User region is set');
                ctx.reply(FIRST_LOGIN_SUCCESSFUL_TEXT, mainMenu).then();
            })
            .catch(() => {

            });

    });
}

