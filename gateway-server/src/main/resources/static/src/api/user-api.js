import axios from 'axios';

function getUser() {
    return new Promise((resolve, reject) => {
        axios.get('/user').then(response => {
            resolve(response);
        }).catch(error => {
            reject(error);
        });
    });
}

function logout() {
    return new Promise((resolve, reject) => {
        axios.post('/logout', {}).then(response => {
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