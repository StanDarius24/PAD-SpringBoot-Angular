import axios from 'axios';
import React, {Component} from 'react';

export default class Register extends Component {

  handleSubmit = (evt) => {
    evt.preventDefault();

    const data = {
      first_name: this.firstName,
      last_name: this.lastName,
      email: this.email,
      password: this.password,
      password_confirm: this.confirmPassword
    };

    axios.post('register', data).then(
      res => {
        console.log(res)
      }
    ).catch(
      err => {
        console.log(err);
      }
    )
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <h3>Sign Up</h3>

        <div className="form-group">
          <label>First Name</label>
          <input type="text" className="form-control" placeholder="First Name"
              onChange={evt => this.firstName = evt.target.value} />
        </div>

        <div className="form-group">
          <label>Last Name</label>
          <input type="text" className="form-control" placeholder="Last Name"
              onChange={evt => this.lastName = evt.target.value}/>
        </div>

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

        <div className="form-group">
          <label>Confirm Password</label>
          <input type="password" className="form-control" placeholder="Confirm Password"
              onChange={evt => this.confirmPassword = evt.target.value}/>
        </div>

        <button className="btn btn-primary btn-block">Sign Up</button>
      </form>
    )
  }
}
