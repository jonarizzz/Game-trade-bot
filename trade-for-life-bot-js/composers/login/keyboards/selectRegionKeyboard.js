import {Markup} from "telegraf";

export const regionsMenu = (regions) => {
    let regionsAsButtons = [];
    for (let i = 0; i < regions.length; i++) {
        let region = regions[i];
        regionsAsButtons.push(
            [Markup.callbackButton(region.nameRu,'userRegionSelected' + i, false)]
        )
    }
    return {
        inline_keyboard: regionsAsButtons,
        "columns": 1
    }
}