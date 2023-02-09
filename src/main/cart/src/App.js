import React, {Component} from 'react';
//import logo from './logo.svg';
import './App.css';

import Table from 'react-bootstrap/Table';

class App extends Component {
 state = {
    categories: []
  };

  async componentDidMount() {
    const response = await fetch('http://localhost:8080/categories/list');
    const body = await response.json();
    this.setState({categories: body});
  }

  render() {
    const {categories} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            
            <div className="app-container">
              <h2>Categories</h2>
              <Table striped bordered hover size="md">
	              <thead>
	              	<th width="30%">ID</th>
	              	<th width="40%">Name</th>
	              	<th width="40%">Description</th>
	              </thead>
              	  <tbody>
              	  	
              {categories.map(category =>
                  <tr>
                  <td>{category.catId}</td>
                    <td>{category.catName}</td> 
                    <td>{category.catDescription}</td>
                  </tr>
              )}
                          	  
              	  	
              	  </tbody>
              </Table>
            </div>
          </header>
        </div>
    );
  }
}
export default App;