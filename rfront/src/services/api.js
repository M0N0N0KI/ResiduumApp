import axios from "axios"

const api = axios.create({
    baseURL:"http://localhost:8080",
    auth:
    {
        username: "rfront",
        password: "RESIDUUM2022br$",
    },
})

export default api;