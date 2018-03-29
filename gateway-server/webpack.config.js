const path = require('path');
const resolve = require('path').resolve

module.exports = {
    entry: './src/main/resources/static/src/main.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, './src/main/resources/static/dist')
    },
    module: {
        rules: [{
            test: /\.vue$/,
            use: ['vue-loader']
        },
        {
            test: /\.js$/,
            use: ['babel-loader'],
            exclude: /node_modules/
        },
        {
            test: /\.css$/,
            use: ['style-loader', 'css-loader', 'postcss-loader']
        },
        {
            test: /\.(png|jpg|jpeg|gif|eot|ttf|woff|woff2|svg|svgz)(\?.+)?$/,
            use: [{
                loader: 'url-loader',
                options: {
                    limit: 10000
                }
            }]
        }
        ]
    },
    resolve: {
        alias: {
            '~': resolve(__dirname, './src/main/resources/static/src')
        },
        extensions: ['*', '.js', '.vue', '.json']
    }
};