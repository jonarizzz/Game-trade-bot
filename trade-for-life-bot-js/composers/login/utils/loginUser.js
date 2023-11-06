import axios from "axios";
import {LOGIN_URL} from "../../../constants/resources";

export const loginUser = (userInfo) => {
    if (userInfo.is_bot === true) {
        // TODO: throw "Bots are not allowed!"
    }

    const headers = {
        'Content-Type': 'application/json'
    }
    const data = {
        telegramId: userInfo.id,
        name: userInfo.first_name + (userInfo.last_name ? ' ' + userInfo.last_name : ''),
        nickname: userInfo.username,
    }

    return axios.post(LOGIN_URL, data, {headers: headers})
}