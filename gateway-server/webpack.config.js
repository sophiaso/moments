const path = require('path');
const resolve = require('path').resolve
const HtmlWebpackPlugin = require('html-webpack-plugin');
const static_dist_dir='./src/main/resources/static/dist'
const webapp_dir = './src/main/webapp'

module.exports = {
    entry: webapp_dir + '/src/main.js',
    output: {
        filename: 'js/bundle.js',
        path: path.resolve(__dirname, static_dist_dir)
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
                path.resolve(__dirname, webapp_dir + "/src"), // white-list app source files
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
    plugins: [
        new HtmlWebpackPlugin({
            template: webapp_dir + '/index.html'
        })
    ],
    resolve: {
        alias: {
            '~': resolve(__dirname, webapp_dir + "/src")
        },
        extensions: ['*', '.js', '.vue', '.json']
    },
    devServer: {
        contentBase: "/assets/",
        port: 9090,
        proxy: {
            '**': {
                target: 'http://localhost:8080',
                secure: false,
                prependPath: false
            }
        },
        allowedHosts: [
            'localhost'
        ],
        historyApiFallback: true
    }
};