import axios from 'axios';

function getUser(onSuccess, onError) {
    axios.get('/user').then(response => {
            onSuccess(response);
        }).catch(error => {
            onError(error);
        });
}

function logout(onSuccess, onError) {
    axios.post('/logout', {}).then(response => {
        onSuccess(response);
    }).catch(error => {
        onError(error);
    });
}

export {
    getUser,
    logout
}