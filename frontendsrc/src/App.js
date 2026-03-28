import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./components/Home";
import AddPlayer from "./components/AddPlayer";
import PlayerList from "./components/PlayerList";
import UpdatePlayer from "./components/UpdatePlayer";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/add" element={<AddPlayer />} />
        <Route path="/players" element={<PlayerList />} />
        <Route path="/update/:id" element={<UpdatePlayer />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;