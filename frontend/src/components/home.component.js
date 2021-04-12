import React, {Component} from 'react';

export default class Home extends Component {
  render () {
    if(this.props.user){
      return (
        <h2>Hi {this.props.user.first_name} {this.props.user.last_name}</h2>
      )
    }

    return (
      <h2>You are not logged in</h2>
    )
  }
}
