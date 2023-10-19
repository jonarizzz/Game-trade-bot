import axios from "axios";
import {GET_GAMES_BY_PART_OF_TITLE_URL} from "../constants/constants";

export const getTheListOfGamesByName = async (gameName) => {
    const getGamesByTitleUrl = GET_GAMES_BY_PART_OF_TITLE_URL(gameName);
    const headers = {
        'Content-Type': 'application/json'
    }
    return axios.get(getGamesByTitleUrl,{
        headers: headers
    })
}