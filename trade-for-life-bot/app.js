import Telegraf, {session} from 'telegraf';
// import {login} from "./composers/login/Login";
import {exploreGamesCommandsComposer} from "./composers/explore_games/exploreGames";
import {sellGamesCommandsComposer} from "./composers/sell_game/sellGame";
import {buyGameCommandsComposer} from "./composers/buy_game/buyGame";
import {personalInfoCommandsComposer} from "./composers/personal_info/personal";
import {loginComposer} from "./composers/login/login";
import {TELEGRAM_BOT_KEY} from "./constants/params";


const bot = new Telegraf(TELEGRAM_BOT_KEY);
bot.use(session());
bot.use(loginComposer);
bot.use(exploreGamesCommandsComposer);
bot.use(sellGamesCommandsComposer);
bot.use(buyGameCommandsComposer);
bot.use(personalInfoCommandsComposer);

bot.catch(error => {
    console.log('telegraf error', error.response, error.parameters, error.on || error)
});

bot.start(() => {

});

bot.startPolling();

async function startup() {
    await bot.launch()
    console.log(new Date(), 'Bot started as', bot.options.username)
}

startup().then();