const path = require('path');
const resolve = require('path').resolve

const static_res_dir = './src/main/resources/static'

module.exports = {
    entry: static_res_dir + '/src/main.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, static_res_dir + '/dist')
    },
    devtool: 'inline-source-map',
    module: {
        rules: [{
            test: /\.vue$/,
            use: ['vue-loader']
        },
        {
            test: /\.js$/,
            use: ['babel-loader'],
            include: [ // use `include` vs `exclude` to white-list vs black-list
                path.resolve(__dirname, static_res_dir + "/src"), // white-list your app source files
                require.resolve("bootstrap-vue"), // white-list bootstrap-vue
            ],
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