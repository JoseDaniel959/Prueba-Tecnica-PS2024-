"use client"
import Image from "next/image";
import styles from "./page.module.css";
import { useState,useEffect, useReducer, useRef } from "react";
import segmentoService from "./services/Segmentos";
import bordillosService from "./services/Bordillos"
import calzadaService from "./services/Calzada"
import { Table,Button} from "antd";
import Link from 'next/link'
import ModalEditarSegmento from "./Componentes/ModalEditarSegmento";
export default function Home() {
  const [dataState,setDataState] = useState([])

  const modalRef = useRef(null)
  const HandleButtonEliminarSegmento = async (id)=>{
    await segmentoService.DeleteDato(id)
    setDataState(dataState.filter(segmento => segmento.id_segmento != id))   
  }

  const HandleButtonEditarSegmento = (datosSegmento) =>{
    
    modalRef.current.showModal(datosSegmento)
  }


  
  const columns = [
    {
      title: 'id_segmento',
      dataIndex: 'id_segmento',
      key: 'id_segmento',
    },
    Table.EXPAND_COLUMN,
    {
      title: 'longitud',
      dataIndex: 'longitud',
      key: 'longitud',
    },
    {
      title: 'direccion',
      dataIndex:  'direccion',
      key:  'direccion',
    },
    {
      title: 'Editar Segmento',
      dataIndex: '',
      key: 'editar',
      render: (record) => <Button onClick={()=> HandleButtonEditarSegmento(record)} type="dashed" >Editar</Button>,
    },
    {
      title: 'Elimminar Segmento',
      dataIndex: '',
      key: 'eliminar',
      render: (record) => 
      <Button onClick={()=> HandleButtonEliminarSegmento(record.id_segmento)}  type="primary" danger>Eliminar</Button>,
    },
  ];

  useEffect( () => {
    const dataFetch = async () => {
      const result = await segmentoService.GetDatos()
      const bordillos = await bordillosService.GetBordillos()
      const calzadas = await calzadaService.GetCalzada()
      const nuevo = result.map((segmento) =>{
        return{...segmento,key:segmento.id_segmento,
          bordillos: bordillos.filter(bordillo => bordillo.segmento == segmento.id_segmento),
          calzadas : calzadas.filter(calzada => calzada.segmento == segmento.id_segmento)}
      })
      setDataState(nuevo)
    }
    dataFetch()
   
  }, []);
  
  return (
    <div>
      <ModalEditarSegmento ref={modalRef} ></ModalEditarSegmento> 
      <Table dataSource={dataState} columns={columns}   
      expandable={{expandedRowRender: (record) =>{
        return(
        <div> 
          <h2>
            Bordillos asociados al segmento
          </h2>
          <p style={{ margin: 0 }}>{JSON.stringify(record.bordillos)}</p>
          <h2>
            Calzadas asociadas al segmento
          </h2>
          <p style={{ margin: 0 }}>{JSON.stringify(record.calzadas)}</p>
        </div>)
        } }}/>
      <Link href="/CrearSegmento">
        <Button type="primary">
          Crear Segmento
        </Button>
      </Link>
    </div>
  );
}
