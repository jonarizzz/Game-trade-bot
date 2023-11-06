import {GET_OFFERS_BY_GAME_ID} from "../constants/constants";
import axios from "axios";


export const getOffersForGameById = async (gameId) => {
    const url = GET_OFFERS_BY_GAME_ID(gameId);
    const headers = {
        'Content-Type': 'application/json'
    }
    return axios.get(url,{
        headers: headers
    })
}