import axios from "axios"; 

const baseURL = "http://localhost:9000/bordillos"
const GetBordillos = async () =>{
    const request = await axios.get(baseURL)
    console.log(request)
    return request.data
}

const PostBordillos = async (data) =>{
    const request = await axios.post(baseURL,data)
    return request.data
}

const PatchBordillos = async (data)=>{
    const request = await axios.patch(baseURL,data)
    return request.data
}

export default {GetBordillos,PostBordillos,PatchBordillos}