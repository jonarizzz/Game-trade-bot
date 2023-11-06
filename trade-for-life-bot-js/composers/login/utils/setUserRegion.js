import axios from "axios";
import {PUT_USER_REGION} from "../../../constants/resources";

export const setUserRegion = (userId, regionId) => {
    const data = {
        userId: userId,
        regionId: regionId
    }
    return axios.put(PUT_USER_REGION, data);
}