import React from 'react';
import TodoList from './TodoList';
import AddTodo from './AddTodo';
import Header from "../test.js";
import { Paper, List, Container }  from "@material-ui/core";
import '../../css/App.css';
import { call } from '../service/ApiService';

var todoURL = "/todo";

class App extends React.Component{
  constructor(props){
    super(props);
    this.state={
       items : [],
      };
  }
  
  componentDidMount() {
    call(todoURL, "GET", null).then((response) =>
      this.setState({ items: response.data })
    );
  }

  add = (item) => {
    call(todoURL, "POST", item).then((response) =>
      this.setState({ items: response.data })
    );
  };

  delete = (item) => {
    call(todoURL, "DELETE", item).then((response) =>
      this.setState({ items: response.data })
    );
  };

  update = (item) => {
    call(todoURL, "PUT", item).then((response) =>
      this.setState({ items: response.data })
    );
  };

  render() {
    var todoItems = this.state.items.length > 0 && (
      <Paper style={{ margin: 16 }}>
        <List>
          {this.state.items.map((item, idx) => (
            <TodoList
              item={item}
              key={item.id}
              delete={this.delete}
              update={this.update}
            />
          ))}
        </List>
        
      </Paper>
    );
    return (
      <div className="App">
      <div>
                 <Header />
      </div>
        <Container maxWidth="md">
          <AddTodo add={this.add} />
          <div className="TodoList">{todoItems}</div>
        </Container>
      </div>
    );
  }
}

 

export default App;
