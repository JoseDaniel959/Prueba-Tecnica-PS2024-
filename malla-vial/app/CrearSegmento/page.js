"use client"
import { Form,Input,Button } from"antd";
import { useState } from "react";
import SegmentosServices from "../services/Segmentos";
import BordilloServices from "../services/Bordillos"
import CalzadaServices from "../services/Calzada"
export default function CrearSegmento() {
    const [form] = Form.useForm();
    const HandleButtonCrearSegmento = ()=>{
        const id_segmento = parseInt(form.getFieldsValue().id_segmento)
        const longitud = parseInt(form.getFieldsValue().longitud)
        const direccion = form.getFieldsValue().direccion
        const bordillos = form.getFieldsValue().bordillos
        const calzadas = form.getFieldsValue().calzadas
        const ListaBordillos = eval(bordillos)
        const ListaCalzadas = eval(calzadas)
        const segmentoNuevo = {id_segmento:id_segmento,longitud:longitud,direccion:direccion} 
        const bordilloNuevo = ListaBordillos == undefined ? undefined : {bordillos:ListaBordillos.map((bordillo) => { return{...bordillo,segmento:id_segmento}})}
        const calzadaNueva = ListaCalzadas == undefined ? undefined : {calzadas:ListaCalzadas.map((calzada) =>{return{...calzada,segmento:id_segmento}})}
        form.setFieldsValue({id_segmento:"",longitud:"",direccion:"",bordillos:"",calzadas:""})
        SegmentosServices.CrearSegmento(segmentoNuevo)
        
        form.setFieldsValue()
        if(bordilloNuevo == undefined && calzadaNueva != undefined){
            console.log("entroo")
            CalzadaServices.PostCalzada(calzadaNueva)
            alert("Segmento y Calzadas creadas");
        }
        else if(bordilloNuevo != undefined &&  calzadaNueva == undefined){
            BordilloServices.PostBordillos(bordilloNuevo)
            alert("Segmento y Bordillos creadas");

        }
        else if(bordilloNuevo == undefined &&  calzadaNueva == undefined){
            alert("Segmento Creado");
            
        }
        else{
            BordilloServices.PostBordillos(bordilloNuevo)
            CalzadaServices.PostCalzada(calzadaNueva)
            alert("Segmento, Bordillos y calzadas creadas");
        }
        
        

 
    }
    
    return (
        <>
        <h1>Crear segmento</h1>
            <p>En el siguiente formulario puede llenar los datos para la creación de un nuevo segmento.</p>
            <p>Para crear bordillos asociados al segmento se debe de copiar como muestra el siguiente ejemplo [&#123; id_bordillo: 1,longitud:100 &#125;,&#123; id_bordillo: 2,longitud:150 &#125;]</p>
            <p>Para crear las calzadas asociados al segmento se debe de copiar como muestra el siguiente ejemplo [&#123; id_calzada: 1,longitud:100 &#125;,&#123; id_calzada: 2,longitud:150 &#125;]</p>

            <div style={{marginLeft: "100px", marginRight: "100px"}}>
                
                <Form layout="vertical" form={form}>
                        <Form.Item name="id_segmento" label="id segmento">
                            <Input />
                        </Form.Item>
                        
                        <Form.Item name="longitud" label="longitud">
                            <Input/>
                        </Form.Item>

                        <Form.Item name="direccion" label="direccion">
                            <Input/>
                        </Form.Item>

                        <Form.Item name="bordillos" label="Digete los bordillos">
                            <Input/>
                        </Form.Item>
                        
                        <Form.Item name="calzadas" label="Digete las calzadas">
                            <Input/>
                        </Form.Item>

                        <Button  htmlType="button" onClick={HandleButtonCrearSegmento}>
                        Crear segmento nuevo 
                        </Button>
                    
                </Form>
            </div>
        </>
    )
}
