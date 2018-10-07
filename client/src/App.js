import React, { Component } from "react";
import "./App.css";
import axios from "axios";

class App extends Component {
  constructor(){
    super();

    this.state = {
      status: ''
    }

    this.handleClick=this.handleClick.bind(this);
    this.handleChange=this.handleChange.bind(this);

  }
  handleClick () {
    axios.get("/validate", {params: {"socialSecurityNumber": document.getElementById("ssn").value}})
        .then(res => this.setState({status: res.data.status}))
  }
//In case of continuous validation checkge. Call this on inputs onChange.
  handleChange() {
      axios.get("/validate", {params: {"socialSecurityNumber": document.getElementById("ssn").value}})
          .then(res => this.setState({status: res.data.status}))
  }

  render() {
    return (
      <div id="container">
        <h2 id="header">Sjekk om et fødselsnummer er gyldig her!</h2>
        <div id="input" className="input-field">
          <input id="ssn" type="text"/>
          <label className="active">
            Fødselsnummer (11 siffer)
          </label>
        </div>
          <button
              id="button"
              className="btn waves-effect waves-light"
              type="submit"
              name="action"
              onClick={this.handleClick}
          >
              Valider
              <i className="material-icons right">send</i>
          </button>
        <p>
          {this.state.status}
        </p>
      </div>
    );
  }
}

export default App;
