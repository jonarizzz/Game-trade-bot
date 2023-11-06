import axios from "axios";
import {GET_REGIONS_URL} from "../../../constants/resources";

export const getListOfRegions = () => {
    return axios.get(GET_REGIONS_URL);
}