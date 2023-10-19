import {GET_NEW_OFFER_URL} from "../constants/constants";
import axios from "axios";

export const placeOffer = async (gameId, telegramUserId, price) => {
    const placeOfferURL = GET_NEW_OFFER_URL();
    return axios.post(placeOfferURL, {
        gameId: gameId,
        telegramUserId: telegramUserId,
        price: price,
        type: "SELL"
    })
}