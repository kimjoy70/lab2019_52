import React from 'react';
import ReactDOM from 'react-dom';
import { DataGrid, GridColumn } from 'rc-easyui';
class BoardListVer2 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
	 conf: {
	        options: {
	          columns: [
	            { field: 'bm_title', title: '제목' },
	            { field: 'bm_writer', title: '작성자' },
	            { field: 'bm_date', title: '작성일' }
	          ],
	          url:'getBoardList.do'
	        }
	   }
    }
  }	
	render() {
		return (
	      <div>
	        <DataGrid data={this.state.data} style={{height:250}}>
	          <GridColumn field="bm_title" title="제목"></GridColumn>
	          <GridColumn field="bm_writer" title="작성자"></GridColumn>
	          <GridColumn field="bm_date" title="작성일" align="right"></GridColumn>
	        </DataGrid>
	      </div>
	    );  		
	}
}
ReactDOM.render(<BoardListVer2/>, document.getElementById('root'));