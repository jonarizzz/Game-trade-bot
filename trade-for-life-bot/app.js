import Telegraf, {session} from 'telegraf';
import {exploreGamesCommandsComposer} from "./composers/explore_games/exploreGames";
import {sellGamesCommandsComposer} from "./composers/sell_game/sellGame";
import {buyGameCommandsComposer} from "./composers/buy_game/buyGame";
import {personalInfoCommandsComposer} from "./composers/personal_info/personal";
import {loginComposer} from "./composers/login/login";
import {TELEGRAM_BOT_KEY} from "./config/params";
import {BOT_STARTED_LOG} from "./constants/logs";
import {logger} from "./config/loggerConfig";



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
    // any additional logic when user is starting the bot goes here
});

bot.startPolling();

async function startup() {
    await bot.launch()
    logger.info(BOT_STARTED_LOG(bot.options.username));
}

startup().then();