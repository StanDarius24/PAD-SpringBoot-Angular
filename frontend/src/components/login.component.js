import axios from 'axios';
import React, {Component} from 'react';

export default class Login extends Component {

  handleSubmit = (evt) => {
    evt.preventDefault();

    const data = {
      email: this.email,
      password: this.password
    }

    axios.post('login', data)
      .then(res => {
        localStorage.setItem('token', res.data.token);
      })
      .catch(err => {
        console.log(err);
      })
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <h3>Login</h3>

        <div className="form-group">
          <label>Email</label>
          <input type="email" className="form-control" placeholder="Email"
              onChange={evt => this.email = evt.target.value}/>
        </div>

        <div className="form-group">
          <label>Password</label>
          <input type="password" className="form-control" placeholder="Password"
              onChange={evt => this.password = evt.target.value}/>
        </div>

        <button className="btn btn-primary btn-block">Login</button>
      </form>
    )
  }
}
