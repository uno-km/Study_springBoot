import React from 'react';
import TodoList from './TodoList';
import AddTodo from './AddTodo';
import { Paper, List, Container,Grid,Button,AppBar,Toolbar,Typography }  from "@material-ui/core";
import '../../css/App.css';
import { call,signout } from '../service/ApiService';
var todoURL = "/todo";

class App extends React.Component{
  constructor(props){
    super(props);
    this.state={
       items : [],
       /*(로딩중이라는 상태를 표현할 변수를 생성자에 상태 변수를 추가합니다.)*/
        loading: true,
      };
  }
  
  componentDidMount() {
    /*componetDidMount에서 Todo리스트를 가져오는 Get요청이 성공적으로 리턴하는 경우 loading을 false로 고칩니다. 
    더 이상 로딩중이 아니라는 뜻이 됩니다.*/
    call(todoURL, "GET", null).then((response) =>
      this.setState({ items: response.data, loading: false })
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
    //navigationBar 추가
    var navigationBar = (
      <AppBar position='static'>
      <Toolbar>
      <Grid justify="space-between" container>
          <Grid item>
            <Typography variant="h6">오늘의 할일 :: TO DO</Typography>
          </Grid>
          <Grid>
            <Button color="inherit" onClick={signout}>
              로그아웃
            </Button>
          </Grid>
        </Grid>
      </Toolbar>
      </AppBar>
    );
    var todoListPage=(
      <div>
        {navigationBar}{/*내비게이션 바 렌더링*/}
          <Container maxWidth="md">
            <AddTodo add={this.add}/>
            <div className='TodoList'>{todoItems}</div>
          </Container>
      </div>
    );

    /* 로딩중일 때 렌더링 할 부분 */
    var loadingPage = <h1> 로딩중.. </h1>;

    var content = loadingPage;

    if (!this.state.loading) {
      /* 로딩중이 아니면 todoListPage를 선택*/
      content = todoListPage;
    }

    /* 선택한 content 렌더링 */
    return <div className="App">{content}</div>;
  }
}
 

export default App;
