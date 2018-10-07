import React, { Component } from "react";
import "./App.css";
import axios from "axios";

class App extends Component {
  constructor(props){
    super(props);

    this.state = {
      status: ''
    };

    this.handleClick=this.handleClick.bind(this);
    this.handleChange=this.handleChange.bind(this);

  }
  async handleClick () {
      const res = await axios.get("/validate", {params: {"socialSecurityNumber": document.getElementById("ssn").value}});
      this.setState({status: res.data});

  }
//In case of continuous validation checkge. Call this on inputs onChange.
  handleChange() {
      axios.get("/validate", {params: {"socialSecurityNumber": document.getElementById("ssn").value}})
          .then(function (response) {
              console.log(response.data)
          });
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
