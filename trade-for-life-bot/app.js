import Telegraf, {session} from 'telegraf';
// import {login} from "./composers/login/Login";
import {exploreGamesCommandsComposer} from "./composers/explore_games/exploreGames";
import {sellGamesCommandsComposer} from "./composers/sell_game/sellGame";
import {buyGameCommandsComposer} from "./composers/buy_game/buyGame";
import {personalInfoCommandsComposer} from "./composers/personal_info/personal";
import {loginComposer} from "./composers/login/login";
import {TELEGRAM_BOT_KEY} from "./constants/params";
import {pino} from "pino";
import {BOT_STARTED_LOG} from "./constants/logs";

export const logger = pino({
    level: 'debug',
    prettyPrint: {
        colorize: true,
        translateTime: true,
        ignore: 'hostname'
    }
}).child({});

const bot = new Telegraf(TELEGRAM_BOT_KEY);
bot.use(session());
bot.use(loginComposer);
bot.use(exploreGamesCommandsComposer);
bot.use(sellGamesCommandsComposer);
bot.use(buyGameCommandsComposer);
bot.use(personalInfoCommandsComposer);

bot.catch(error => {
    logger.error('telegraf error', error.response, error.parameters, error.on || error)
});

bot.start(() => {

});

bot.startPolling();

async function startup() {
    await bot.launch()
    logger.info(BOT_STARTED_LOG(bot.options.username));
}

startup().then();