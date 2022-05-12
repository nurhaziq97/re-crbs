import axios from "axios";
import authHeader from "./auth-header";
import { URL } from "../config";

const API_URL  = URL + "/test/";

const getPublicContent = () => {
    return axios.get(API_URL + "all");
}

const getCustomerBoard = () => {
    return axios.get(API_URL + "user", {headers: authHeader() });
}

const getCarOwnerBoard = () => {
    return axios.get(API_URL + "car_owner", {headers : authHeader() });
}

const getAdminBoard = () => {
    return axios.get(API_URL + "admin", { headers: authHeader() });
}

export default {
    getPublicContent,
    getCustomerBoard, 
    getCarOwnerBoard,
    getAdminBoard
};