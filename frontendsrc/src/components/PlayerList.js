import React, { useEffect, useState } from "react";
import { getPlayers, deletePlayer, getPlayerById } from "../services/PlayerService";
import { useNavigate } from "react-router-dom";

function PlayerList() {

  const [players, setPlayers] = useState([]);
  const [searchId, setSearchId] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  useEffect(() => {
    loadData();
  }, []);

  const loadData = () => {
    getPlayers()
      .then(res => {
        setPlayers(res.data);
        setError(res.data.length === 0 ? "No Players Available" : "");
      })
      .catch(() => {
        setPlayers([]);
        setError("Error loading players");
      });
  };

  const handleSearch = () => {
    if (!searchId) {
      setPlayers([]);
      setError("Please enter player ID");
      return;
    }

    getPlayerById(searchId)
      .then(res => {
        setPlayers([res.data]);
        setError("");
      })
      .catch((err) => {
        setPlayers([]);
        setError( "Player Id not found");
      });
  };

  const handleReset = () => {
    setSearchId("");
    loadData();
  };

  const handleDelete = (id) => {
    if (!window.confirm("Are you sure?")) return;

    deletePlayer(id)
      .then(() => {
        alert("Deleted successfully");
        loadData();
      })
      .catch(() => setError("Error deleting player"));
  };

  const handleEdit = (id) => {
    navigate(`/update/${id}`);
  };

  return (
    <div className="container mt-4">

      <h2 className="text-center mb-3">Players</h2>

     
      <div className="d-flex mb-3">
        <input
          type="number"
          className="form-control me-2"
          placeholder="Enter Player ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />

        <button className="btn btn-primary me-2" onClick={handleSearch}>
          Search
        </button>

        <button className="btn btn-secondary" onClick={handleReset}>
          Reset
        </button>
      </div>

      
      {players.length > 0 ? (

        <div className="table-responsive">
          <table className="table table-striped table-hover">

            <thead className="table-dark">
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Jersey</th>
                <th>Role</th>
                <th>Matches</th>
                <th>Team</th>
                <th>Country</th>
                <th>Description</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
              {players.map(p => (
                <tr key={p.playerid}>
                  <td>{p.playerid}</td>
                  <td>{p.playername}</td>
                  <td>{p.jerseyno}</td>
                  <td>{p.role}</td>
                  <td>{p.totalmatches}</td>
                  <td>{p.teamname}</td>
                  <td>{p.country}</td>
                  <td>{p.description}</td>

                  <td>
                    <button
                      className="btn btn-warning btn-sm me-2"
                      onClick={() => handleEdit(p.playerid)}>
                      Edit
                    </button>

                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleDelete(p.playerid)}>
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>

          </table>
        </div>

      ) : (

        <div className="alert alert-danger text-center">
          {error || "No Players Available"}
        </div>

      )}

    </div>
  );
}

export default PlayerList;