import {GET_OFFERS_BY_USERNAME} from "../constants/constants";
import axios from "axios";

export const getOffersForUser = (username, page) => {
    const url = GET_OFFERS_BY_USERNAME(username, page);
    const headers = {
        'Content-Type': 'application/json'
    }
    return axios.get(url,{
        headers: headers
    })
}
