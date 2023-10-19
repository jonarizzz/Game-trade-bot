import {GET_UPDATE_OFFER_URL} from "../constants/constants";
import axios from "axios";

export const changeOffer = (offer, newPrice) => {
    const url = GET_UPDATE_OFFER_URL(offer.id);
    const headers = {
        'Content-Type': 'application/json'
    }
    offer.price = newPrice;
    console.log(offer)
    return axios.put(url,{
        headers: headers,
        offer: offer
    })
}