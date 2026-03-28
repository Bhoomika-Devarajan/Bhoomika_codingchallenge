import React from "react";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">

      <div className="text-center">
        <h1 className="mb-4">Cricket Team Management</h1>

        <div className="d-grid gap-3 col-12 mx-auto">
          <button
            className="btn btn-primary btn-lg"
            onClick={() => navigate("/add")}
          >
            Add Player
          </button>

          <button
            className="btn btn-success btn-lg"
            onClick={() => navigate("/players")}
          >
            View Players
          </button>
        </div>
      </div>

    </div>
  );
}

export default Home;