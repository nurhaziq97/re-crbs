import React from "react";
import { history } from '../helpers/history';

const parseJWT = (token) => {
    try {
        return JSON.parse(Buffer.from(token.split(".")[1], 'utf-8').toString('base64'));
    }catch (e) {
        return null;
    }
}

const AuthVerify = (props) => {
    history.listen(() => {
        const user = JSON.parse(localStorage.getItem("user"));
        if(user) {
            const decodedJwt = parseJWT(user.accessToken);

            if(decodedJwt.exp * 1000 < Date.now()) {
                props.logOut();
            }
        }
    });
    return <div></div>
};

export default AuthVerify;