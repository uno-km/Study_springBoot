import React from 'react';
import {ListItem, ListItemText, InputBase, Checkbox, ListItemSecondaryAction, IconButton
} from "@material-ui/core";
import { DeleteOutline } from '@material-ui/icons';

class TodoList extends React.Component{
    constructor(props) {
        super(props);
        this.state = { item: props.item,readOnly : true};
        this.delete = props.delete;
        this.update = props.update; //update를 this.update에 할당
      }
      deleteEventHandler = () => {
        this.delete(this.state.item);
      };
      offReadOnlyMode = () => {
          console.log("Event! ", this.state.readOnly)
          this.setState({readOnly:false},()=>{
              console.log("ReadOnly ? " , this.state.readOnly)
          });
      }

      enterKeyEventHandler = (e) => {
        if (e.key === "Enter") {
          this.setState({readOnly: true});
          this.update(this.state.item); //엔터누르면 저장
        }
      };
      editEventHandler = (e) => {
          const thisItem = this.state.item;
          thisItem.title = e.target.value;
          this.setState({item:thisItem});
      }
      checkboxEventHandler = (e) => {
        const thisItem = this.state.item;
         thisItem.done = !thisItem.done;
         this.setState({ item: thisItem });
         this.update(this.state.item); //체크박스가 변경되면 저장
        };
      render(){
        var item = this.state.item;
        return (
            <ListItem>
                <Checkbox checked = {item.done} onChange = {this.checkboxEventHandler}/>
                <ListItemText>
                <InputBase
                inputProps={{ "aria-label":"naked"
                ,readOnly: this.state.readOnly
                ,}}
                onClick={this.offReadOnlyMode}
                onKeyPress={this.enterKeyEventHandler}
                onChange={this.editEventHandler}
                type="text"
                id={item.id}
                name={item.id}
                value={item.title}
                multiline={true}
                fullWidth={true}
                />
                </ListItemText>
                <ListItemSecondaryAction>
                    <IconButton aria-label="Delete Todo"
                    onClick = {this.deleteEventHandler}>
                            <DeleteOutline/>
                    </IconButton>
                </ListItemSecondaryAction>
            </ListItem>
        );
    }

}
export default TodoList;