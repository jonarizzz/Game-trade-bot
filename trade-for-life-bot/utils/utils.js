import {POST_USER_URL} from "../constants";
import axios from 'axios';

export const postUserInfo = async (ctx) => {
    let userInfo = ctx.update.message.from;
    const postUserUrl = POST_USER_URL;
    const headers = {
        'Content-Type': 'application/json'
    }
    const data = {
        telegramId: userInfo.id,
        name: userInfo.first_name + userInfo.last_name,
        nickname: userInfo.username,
    }
    return axios.post(postUserUrl, data, {
        headers: headers
    });
}

