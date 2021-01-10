import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "./Home";
import NavBar from "./NavBar";
import Orders from "./Orders";

function Routes() {
  return (
    <BrowserRouter>
      <NavBar />
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route path="/orders">
          <Orders />
        </Route>
      </Switch>
    </BrowserRouter>
  )
}

export default Routes;