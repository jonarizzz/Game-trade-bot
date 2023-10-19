import axios from "axios";
import {PUBLISH_NEW_OFFER_URL, SELL_OFFER_TYPE} from "../constants/constants";

export const publishNewOffer = async(gameId, telegramUserId, price) => {
    const publishOfferURL = PUBLISH_NEW_OFFER_URL();
    return axios.post(publishOfferURL, {
        gameId: gameId,
        telegramUserId: telegramUserId,
        type: SELL_OFFER_TYPE,
        price: price
    })
}