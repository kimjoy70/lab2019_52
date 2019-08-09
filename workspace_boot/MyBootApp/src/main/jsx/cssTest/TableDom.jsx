import React from 'react';
import ReactDOM from 'react-dom';

class TableDom extends React.Component {
	 render() {
		return (
			<div>
			<table style={{width:"700px", border:"1px solid"}}>
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
ReactDOM.render(<TableDom/>, document.getElementById('root'));