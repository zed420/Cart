import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

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
            
            <div className="App-intro">
              <h2>Categories</h2>
              {categories.map(category =>
                  <div key={category.catId}>
                    {category.catName} ({category.catDescription})
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;