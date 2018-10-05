import React, { Component } from "react";
import "./App.css";

class App extends Component {
  render() {
    return (
      <div id="container">
        <h2 id="header">Sjekk om et fødselsnummer er gyldig her!</h2>
        <div id="input" className="input-field col s6">
          <i className="material-icons prefix">create</i>
          <input id="ssn" type="text" className="validate" />

          <label className="active" for="ssn">
            Fødselsnummer (11 siffer)
          </label>
        </div>
      </div>
    );
  }
}

export default App;
