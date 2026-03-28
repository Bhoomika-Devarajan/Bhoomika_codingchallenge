import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getPlayerById, updatePlayer } from "../services/PlayerService";

function UpdatePlayer() {

  const { id } = useParams();
  const navigate = useNavigate();

  const [player, setPlayer] = useState({});
  const [error, setError] = useState("");

  useEffect(() => {
    getPlayerById(id).then(res => setPlayer(res.data));
  }, [id]);

  const handleChange = (e) => {
    setPlayer({ ...player, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    updatePlayer(id, player)
      .then(() => navigate("/players"))
      .catch(() => setError("Update failed"));
  };

  return (
    <div className="container mt-4">

      <h2>Update Player</h2>

      {error && <div className="alert alert-danger">{error}</div>}

      <form onSubmit={handleSubmit}>

        <input className="form-control mb-2"
          name="playername"
          value={player.playername || ""}
          onChange={handleChange} />

        <input className="form-control mb-2"
          name="jerseyno"
          value={player.jerseyno || ""}
          onChange={handleChange} />

        <select className="form-control mb-2"
          name="role"
          value={player.role || ""}
          onChange={handleChange}>
          <option>Batsman</option>
          <option>Bowler</option>
          <option>Keeper</option>
          <option>All Rounder</option>
        </select>

        <input className="form-control mb-2"
          name="totalmatches"
          value={player.totalmatches || ""}
          onChange={handleChange} />

        <input className="form-control mb-2"
          name="teamname"
          value={player.teamname || ""}
          onChange={handleChange} />

        <input className="form-control mb-2"
          name="country"
          value={player.country || ""}
          onChange={handleChange} />

        <textarea className="form-control mb-2"
          name="description"
          value={player.description || ""}
          onChange={handleChange} />

        <button className="btn btn-primary w-100">
          Update Player
        </button>

      </form>
    </div>
  );
}

export default UpdatePlayer;