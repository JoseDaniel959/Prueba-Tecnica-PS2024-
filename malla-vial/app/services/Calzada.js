import axios from "axios";

const baseURL = 'http://localhost:9000/Calzadas'

const GetCalzada= async () => {
    const request =  await axios.get(baseURL)
    return request.data
  }

const PostCalzada = async (data) =>{
  const request = await axios.post(baseURL,data)
  return request.data
}

const PatchCalzada = async (data)=>{
  const request = await axios.patch(baseURL,data)
  return request.data
}
export default {GetCalzada,PostCalzada,PatchCalzada} ;
