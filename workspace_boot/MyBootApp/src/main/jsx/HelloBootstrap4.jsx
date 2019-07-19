import 'bootstrap/dist/css/bootstrap.css'
import React from 'react';
import ReactDOM from 'react-dom';

class HelloBootstrap4 extends React.Component {
	render() {
		return <div>메인 페이지</div>;
	}
}
ReactDOM.render(<HelloBootstrap4/>, document.getElementById('d_root'));