
// set header for the html request

/**
 * Get the logged in user authorization that was stored in local storage
 * @returns user-authorization
 */
export default function authHeader() {
    const user = JSON.parse(localStorage.getItem("user"));

    if(user && user.accessToken) {
        return { "Authorization" : user.accessToken };
    }else {
        return {};
    }
}