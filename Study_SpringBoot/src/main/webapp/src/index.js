import React from "react";
import ReactDOM from "react-dom";
import "./css/index.css";
import AppRouter from "./js/AppRouter";
import reportWebVitals from "./js/reportWebVitals";

ReactDOM.render(
  <React.StrictMode>
         <AppRouter/>
  </React.StrictMode>,
  document.getElementById("root")
);
reportWebVitals();