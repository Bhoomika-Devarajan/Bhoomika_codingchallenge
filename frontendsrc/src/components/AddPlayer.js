import React, { useState } from "react";
import { addPlayer } from "../services/PlayerService";

function AddPlayer() {

  const [player, setPlayer] = useState({
    playername: "",
    jerseyno: "",
    role: "",
    totalmatches: "",
    teamname: "",
    country: "",
    description: ""
  });

  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");

  const handleChange = (e) => {
    setPlayer({ ...player, [e.target.name]: e.target.value });
  };

  const validate = () => {
    const validRoles = ["Batsman", "Bowler", "Keeper", "All Rounder"];

    if (!player.role) return "Role is required";

    if (!validRoles.includes(player.role.trim())) {
      return "Role must be Batsman, Bowler, Keeper, or All Rounder";
    }

    return "";
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const err = validate();
    if (err) {
      setError(err);
      setSuccess("");
      return;
    }

    addPlayer(player)
      .then(() => {
        setSuccess("Player added successfully!");
        setError("");

        setPlayer({
          playername: "",
          jerseyno: "",
          role: "",
          totalmatches: "",
          teamname: "",
          country: "",
          description: ""
        });
      })
      .catch(() => {
        setError("Error adding player");
        setSuccess("");
      });
  };

  return (
    <div className="container mt-4">

      <h2>Add Player</h2>

     
      {success && <div className="alert alert-success">{success}</div>}

      
      {error && <div className="alert alert-danger">{error}</div>}

      <form onSubmit={handleSubmit}>

        <input
          className="form-control mb-2"
          name="playername"
          placeholder="Name"
          value={player.playername}
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          name="jerseyno"
          placeholder="Jersey"
          value={player.jerseyno}
          onChange={handleChange}
        />

       
        <input
          className="form-control mb-2"
          name="role"
          placeholder="Enter Role (Batsman/Bowler/Keeper/All Rounder)"
          value={player.role}
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          name="totalmatches"
          placeholder="Matches"
          value={player.totalmatches}
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          name="teamname"
          placeholder="Team"
          value={player.teamname}
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          name="country"
          placeholder="Country"
          value={player.country}
          onChange={handleChange}
        />

        <textarea
          className="form-control mb-2"
          name="description"
          placeholder="Description"
          value={player.description}
          onChange={handleChange}
        />

        <button className="btn btn-success w-100">
          Add Player
        </button>

      </form>
    </div>
  );
}

export default AddPlayer;