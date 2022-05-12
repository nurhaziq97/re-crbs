import axios from "axios";
import { URL } from "../config";
import authHeader from "./auth-header";

// Get all the services that relate to the customer side of rental booking
const API_URL = URL + "/customer/";


const getProfile = () => {
    return axios.get(API_URL + "/profile", {header: authHeader() });
}