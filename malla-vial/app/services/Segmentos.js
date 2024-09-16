import axios from "axios";
const baseURL = 'http://localhost:9000/'

const GetDatos = async () => {
    const request =  await axios.get(baseURL)
    return request.data
  }

const CrearSegmento = async (segmentoNuevo)=>{
  const request = await axios.post(baseURL,segmentoNuevo)
  return request.data
}


  const DeleteDato = async(id) =>{
  const request =  await axios.delete(baseURL+id)
  console.log(baseURL+id)
  return request.data
} 

const PatchSegmento = async(data) =>{
  const request = await axios.patch(baseURL,data)
  return request.data
}

export default {GetDatos,DeleteDato,CrearSegmento,PatchSegmento};