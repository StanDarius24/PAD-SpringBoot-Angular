import React, {Component} from 'react';

export default class Nav extends Component {
  render () {
    return (
      <nav className="navbar navbar-expand navbar-light fixed-top">
        <div className="container">
          <a href="" className="navbar-brand">Home</a>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="" className="nav-link">Login</a>
              </li>
              <li className="nav-item">
                <a href="" className="nav-link">Sign Up</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    )
  }
}
