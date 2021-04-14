import React, {Component} from 'react';
import { Link } from 'react-router-dom';
//This file will contain the news feed of the social network and will consist of UserCard, SiteMap, SiteMenu (header), NewsContainer, Contacts
//The path to the site template: frontend/public/template.png
//Some sections from SiteMap might not be implemented or replaced with other features

export default class MainPage extends Component {
    render() {

        return (
            <div className = "App">
                <header className = "App-header">
                    <nav className = "navbar navbar-expand navbar-light fixed-top">
                        <div className = "container">
                            <Link to={'/'} className="navbar-brand">

                                Home
                            </Link>
                        </div>
                    </nav>
                </header>
            </div>
        )
    }
}
/*<img src = "PAD-JavaSpring-REACT-AWS [PAD2]/frontend/public/logo_example.png" alt="logo"/>*/