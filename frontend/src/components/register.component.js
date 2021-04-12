import React, {Component} from 'react';

export default class Register extends Component {

  render() {
    return (
      <form>
        <h3>Sign Up</h3>

        <div className="form-group">
          <label>First Name</label>
          <input type="text" className="form-control" placeholder="First Name" />
        </div>

        <div className="form-group">
          <label>Last Name</label>
          <input type="text" className="form-control" placeholder="Last Name" />
        </div>

        <div className="form-group">
          <label>Email</label>
          <input type="email" className="form-control" placeholder="Email" />
        </div>

        <div className="form-group">
          <label>Password</label>
          <input type="password" className="form-control" placeholder="Password" />
        </div>

        <div className="form-group">
          <label>Confirm Password</label>
          <input type="password" className="form-control" placeholder="Confirm Password" />
        </div>

        <button className="btn btn-primary btn-block">Sign Up</button>
      </form>
    )
  }
}
