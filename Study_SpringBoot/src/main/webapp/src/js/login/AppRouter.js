import React from "react";
import "../../css/index.css";
import Login from "./Login";
import App from "../todo/App.js";
import SignUp from "./signup";
import { BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

function Copyright(){
    return(
        <Typography variant="body2" color = "textSecondary" align="center">
            {"Copuright @"}
            unoKim, {new Date().getFullYear()}
        </Typography>
    );

}
class AppRouter extends React.Component {
    render() {
      return (
        <div>
          <Router>
            <div>
              <Switch>
                <Route path="/login">
                  <Login />
                </Route>
                <Route path="/signup">
                  <SignUp />
                </Route>
                <Route path="/">
                  <App />
                </Route>
              </Switch>
            </div>
            <Box mt={5}>
              <Copyright />
            </Box>
          </Router>
        </div>
      );
    }
  }
  
  export default AppRouter;