import React, {Component} from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './components/home.component';
import Nav from './components/nav.component';
import Login from './components/login.component';
import Register from './components/register.component';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import axios from 'axios';


export default class App extends Component {
  state = {};

  componentDidMount = () => {
    axios.get('user').then(
      res => {
        this.setState({
          user: res.data
        });
      },

      err => {
        console.log(err);
      }
    )
  };

  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Nav user={this.state.user}/>
          <div className="auth-wrapper">
            <div className="auth-inner">
              <Switch>
                <Route exact path="/" component={() => <Home user={this.state.user} />} />
                <Route exact path="/login" component={Login} />
                <Route exact path="/register" component={Register} />
              </Switch>
            </div>
          </div>
        </div>
      </BrowserRouter>
    );
  }
}
