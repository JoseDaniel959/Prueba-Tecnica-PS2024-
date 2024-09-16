import { Layout,Modal,Form, Input,Button } from "antd"
import { useState,forwardRef,useImperativeHandle } from "react";
import segmentoService from "../services/Segmentos";
import BordillosService from "../services/Bordillos";
import CalzadaServices from "../services/Calzada";

const ModalEditarSegmento = forwardRef(({},ref) =>{
const [isModalOpen, setIsModalOpen] = useState(false);
const [form] = Form.useForm();
const [previusID,setPreviusID]  = useState(0)
if(isModalOpen == true){
    console.log("entrooo al componente")
}
  const showModal = (datosSegmento) => {
    setPreviusID(datosSegmento.id_segmento)
    form.setFieldsValue(datosSegmento)
    form.setFieldValue("bordillos",JSON.stringify(datosSegmento.bordillos))
    form.setFieldValue("calzadas",JSON.stringify(datosSegmento.calzadas))
    setIsModalOpen(true);
  };


  const handleCancel = () => {
    setIsModalOpen(false);
  };

  const HandleButton = async() =>{ 
    form.setFieldValue("bordillos",eval(form.getFieldValue("bordillos")))
    form.setFieldValue("calzadas",eval(form.getFieldValue("calzadas")))


    console.log(form.getFieldValue("bordillos"))
    segmentoService.DeleteDato(previusID)
    await segmentoService.PatchSegmento(form.getFieldsValue())
    BordillosService.PostBordillos({bordillos:form.getFieldValue("bordillos")})
    CalzadaServices.PostCalzada({calzadas:form.getFieldValue("calzadas")})
    window.location.reload();
    setIsModalOpen(false);
  }

  useImperativeHandle(ref,()=>{
    return{
        showModal
    }
  })
    return(
        <Modal title="Edición de segmento,bordillos y calzadas" open={isModalOpen} onOk={HandleButton} onCancel={handleCancel}>
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
                        
                        <Form.Item name="bordillos" label="bordillos">
                            <Input/>
                        </Form.Item>
                        
                        <Form.Item name="calzadas" label="calzadas">
                            <Input/>
                        </Form.Item>
                        
                        
                    
                </Form>
      </Modal>
    )
})

export default ModalEditarSegmento