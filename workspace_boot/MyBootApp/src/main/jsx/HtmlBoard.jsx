import React from 'react';
import ReactDOM from 'react-dom';

class HtmlBoard extends React.Component {
	render() {
		return (
			<div className="main">
			<table border="1" width="800px">
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</table>
			</div>
		);
	}
}
ReactDOM.render(<HtmlBoard/>, document.getElementById('d_list'));