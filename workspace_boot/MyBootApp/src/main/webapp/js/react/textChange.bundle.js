/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./TextChange.jsx");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./TextChange.jsx":
/*!************************!*\
  !*** ./TextChange.jsx ***!
  \************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("throw new Error(\"Module build failed (from C:/workspace_boot/MyBootApp/node_modules/babel-loader/lib/index.js):\\nSyntaxError: C:\\\\workspace_boot\\\\MyBootApp\\\\src\\\\main\\\\jsx\\\\TextChange.jsx: Support for the experimental syntax 'classProperties' isn't currently enabled (9:19):\\n\\n\\u001b[0m \\u001b[90m  7 | \\u001b[39m    \\u001b[36mthis\\u001b[39m\\u001b[33m.\\u001b[39mstate \\u001b[33m=\\u001b[39m { username\\u001b[33m:\\u001b[39m \\u001b[32m''\\u001b[39m }\\u001b[33m;\\u001b[39m\\u001b[0m\\n\\u001b[0m \\u001b[90m  8 | \\u001b[39m  }\\u001b[0m\\n\\u001b[0m\\u001b[31m\\u001b[1m>\\u001b[22m\\u001b[39m\\u001b[90m  9 | \\u001b[39m  myChangeHandler \\u001b[33m=\\u001b[39m \\u001b[36mfunction\\u001b[39m() {\\u001b[0m\\n\\u001b[0m \\u001b[90m    | \\u001b[39m                  \\u001b[31m\\u001b[1m^\\u001b[22m\\u001b[39m\\u001b[0m\\n\\u001b[0m \\u001b[90m 10 | \\u001b[39m    \\u001b[36mthis\\u001b[39m\\u001b[33m.\\u001b[39msetState({username\\u001b[33m:\\u001b[39m event\\u001b[33m.\\u001b[39mtarget\\u001b[33m.\\u001b[39mvalue})\\u001b[33m;\\u001b[39m\\u001b[0m\\n\\u001b[0m \\u001b[90m 11 | \\u001b[39m  }\\u001b[0m\\n\\u001b[0m \\u001b[90m 12 | \\u001b[39m  render() {\\u001b[0m\\n\\nAdd @babel/plugin-proposal-class-properties (https://git.io/vb4SL) to the 'plugins' section of your Babel config to enable transformation.\\n    at Object.raise (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:6325:17)\\n    at Object.expectPlugin (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:7647:18)\\n    at Object.parseClassProperty (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10830:12)\\n    at Object.pushClassProperty (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10795:30)\\n    at Object.parseClassMemberWithIsStatic (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10734:14)\\n    at Object.parseClassMember (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10668:10)\\n    at withTopicForbiddingContext (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10623:14)\\n    at Object.withTopicForbiddingContext (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:9702:14)\\n    at Object.parseClassBody (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10600:10)\\n    at Object.parseClass (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10574:22)\\n    at Object.parseStatementContent (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:9871:21)\\n    at Object.parseStatement (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:9829:17)\\n    at Object.parseBlockOrModuleBlockBody (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10405:25)\\n    at Object.parseBlockBody (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:10392:10)\\n    at Object.parseTopLevel (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:9758:10)\\n    at Object.parse (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:11270:17)\\n    at parse (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\parser\\\\lib\\\\index.js:11306:38)\\n    at parser (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\core\\\\lib\\\\transformation\\\\normalize-file.js:170:34)\\n    at normalizeFile (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\core\\\\lib\\\\transformation\\\\normalize-file.js:138:11)\\n    at runSync (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\core\\\\lib\\\\transformation\\\\index.js:44:43)\\n    at runAsync (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\core\\\\lib\\\\transformation\\\\index.js:35:14)\\n    at process.nextTick (C:\\\\workspace_boot\\\\MyBootApp\\\\node_modules\\\\@babel\\\\core\\\\lib\\\\transform.js:34:34)\\n    at process._tickCallback (internal/process/next_tick.js:61:11)\");//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9UZXh0Q2hhbmdlLmpzeC5qcyIsInNvdXJjZXMiOltdLCJtYXBwaW5ncyI6IiIsInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///./TextChange.jsx\n");

/***/ })

/******/ });