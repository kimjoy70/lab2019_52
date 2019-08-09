/**
 * 
 */
var path = require('path');
module.exports = {
	context: path.resolve(__dirname, 'src/main/jsx'),
	entry: {
	main: './MainPage.jsx',
	page1: './Page1Page.jsx',
	getBoardList: './BoardList.jsx',	/* 게시판 연습 페이지 */
	getBoardListVer2: './BoardListVer2.jsx',	/* 게시판 연습 페이지 Ver2 */
	htmlBoardList: './HtmlBoard.jsx',	/* html 게시판 연습 페이지 */
	helloBootstrap: './HelloBootstrap4.jsx',	/* 부트스르랩 연습 페이지 */
	routerTest: './RouterTestPage.jsx',	/* react router 연습 페이지 */
	reactNJSP: './ReactNJSPTest.jsx',	/* 리액트와 jsp연동페이지 */
	markdown: './MarkdownEditor.jsx',
	tableDomPage: './cssTest/TableDom.jsx'
},
devtool: 'sourcemaps',
cache: true,
output: {
path: __dirname,
filename: './src/main/webapp/js/react/[name].bundle.js'
},
mode: 'none',
module: {
rules: [ {
test: /\.jsx?$/,
exclude: /(node_modules)/,
use: {
	loader: 'babel-loader',
	options: {
				presets: [ '@babel/preset-env', '@babel/preset-react' ]
	}
	}
}, {
test: /\.css$/,
use: [ 'style-loader', 'css-loader' ]
} ]
}};