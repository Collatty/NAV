//Proxy to backend-server for dev purposes

const proxy = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(proxy('/validate', {target: 'http://localhost:3001'}));

};