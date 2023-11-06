import {GET_GAME_BY_TITLE_PART_URL} from "../constants/constants";
import axios from "axios";


export const getListOfGamesByName = async (titlePart) => {
    const url = GET_GAME_BY_TITLE_PART_URL(titlePart);
    const headers = {
        'Content-Type': 'application/json'
    }
    return axios.get(url,{
        headers: headers
    })
}