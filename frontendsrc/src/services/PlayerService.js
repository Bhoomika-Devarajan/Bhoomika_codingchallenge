import axios from "axios";

const API = "http://localhost:8080/api/players";

export const getPlayers = () => axios.get(API + "/get");
export const getPlayerById = (id) => axios.get(API + "/get/" + id);
export const addPlayer = (data) => axios.post(API + "/add", data);
export const updatePlayer = (id, data) => axios.put(API + "/update/" + id, data);
export const deletePlayer = (id) => axios.delete(API + "/" + id);