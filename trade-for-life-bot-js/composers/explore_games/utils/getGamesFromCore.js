import axios from "axios";
import {GET_GAMES_URL} from "../constants/constants";

export const getGamesFromCore = async (page, size) => {
    const getGamesURL = GET_GAMES_URL(page, size);
    console.log(getGamesURL);
    return axios.get(getGamesURL);
}