import axios from 'axios';

function getUser() {
    return new Promise((resolve, reject) => {
        axios.get('/auth/user').then(response => {
            resolve(response);
        }).catch(error => {
            reject(error);
        });
    });
}

function logout() {
    return new Promise((resolve, reject) => {
        axios.post('/auth/logout', {}).then(response => {
            resolve(response);
        }).catch(error => {
            reject(error);
        });
    });
}

export {
    getUser,
    logout
}