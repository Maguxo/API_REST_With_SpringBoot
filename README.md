<html>
  
  <div align="center">
  <h8>⛏️⛏️⛏️⛏️⛏️⛏️Working in the API⛏️⛏️⛏️⛏️⛏️⛏️</h8>  
    <h1>🛠️Challenge ONE | Back End | Foro Alura💻</h1>
  
  </div>
  <div align="center">
   <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/f91b0de5-4842-4263-ae58-f17cd3b13cc8">
  </div>

  ---
  <div align="center">
    <h1>📜Hablando un poco del proyecto📜</h1>
    <p>Mediante reglas de negocio se construye una API REST con la necesidad de tratar datos para que se relacione un topico con una respuesta teniendo encuenta la realización de validaciones.
    Por el momento se trabajara a nivel back-end apoyandonos en << Insomnia >> para la realización de pruebas.</p>

  </div>


---
  <div align="center">
    <h1>🗳️Modelo relacional💾</h1>
    <p>Con ayuda de Mysql Workbench se realiza el diagrama entidad relacion con la que trabajarenos y construiremos.</p>
   <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/7b7a9a61-59b4-4f46-8af0-4a3d75cc97f4">
  </div>


---
<div align="center">
  <h1>🛠️Herramientas utiliadas⚒️</h1>
<table>
  <thead>
    <tr>
      <th>Intellij IDE</th>
       <th>Mysql Workbench</th>
       <th>Spring Boot</th>
       <th>Insomnia</th>
       <th>Spring Security</th>  
       <th>Fayway</th>
       <th>JPA</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td align="center"> <a align="center"> <img src="https://www.qbssoftware.de/wp-content/uploads/2022/07/JetBrains-Intellij-IDEA.png" width=50 height="50"/> </a> </td>
      <td align="center"> <a> <img src="https://dashboard.snapcraft.io/site_media/appmedia/2020/04/mysql-workbench.png" width=60 height="50"> </a> </td>
      <td align="center"> <a> <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/c6fca234-34f8-4933-95bf-95fc591bde7c"  width=100 height="50"> </a> </td>
      <td align="center"> <a> <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/d11dc2cd-7a5d-4294-914e-edf51b64a9b9"  width=50 height="50"> </a> </td>
      <td align="center"> <a> <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/225036b6-780a-4ba4-8a9a-155aac72ecae"  width=50 height="50"> </a> </td>
      <td align="center"> <a> <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/1bec0552-84d6-45bd-b5b4-0156e91c4e6d"  width=50 height="50"> </a> </td>
      <td align="center"> <a> <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/e3050cfd-efe2-4c76-bba4-297fadd67356"  width=100 height="50"> </a> </td>
    </tr>
  </tbody>
</table>  
</div>

---
<div align="center">
<h1>⌛Contrucción, dessarrollo y prueba challenge API Foro Alura🧩</h1>
<p>Apoyandonos en Insomnia para la pruebas de la API y que las reglas del negocio salieran a lo sigerido, en los datos requeridos en las solicitudes del POST,GET, PUT Y DELETE; mostrados a continuación: </p>

  <h1>🔐Log in</h1>
  <p>Antes de hacer cualquier actividad en la API, se solicita generar un log in con Spring Security generando un toquen que tendrá caducidad a las 2 horas; este se tendrá que enviar y compara con la tabla autor 
 si existe dicho registro creado en MySQL Workbench, dando permiso a la solicitud que se desea hacer.</p>
 <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/db1bec12-5212-44e0-bced-babe312b0180"  width=800 height="350">

  <h1>🗳️Registro topico</h1>
  <p>Teniendo encuneta la solicitud POST para la URL/topicon; los datos, tenidos encuenta para esta tarea son: titulo, mensaje, autor, curso y respuesta. Que se  deben enviarse en el cuerpo de la solicitud, en formato JSON.</p>
  <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/424959aa-5020-4a4d-ad92-63ae441e1382"  width=800 height="350">

   <h1>🪪Detallando topico</h1>
   <p>Teniendo encuenta la solicitud GET para la URI/topicos{id} se debe mostrar titulo, mensaje, fecha de creación, estatus autor y curso con la respuesta, en formato JSON. </p>
    <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/8e750716-fec9-43e3-9b40-aa2b3ea153ef"  width=800 height="350">
  
   <h1>📜Mostrando topico</h1>
   <p>Teniendo encuenta la solicitud GET para la URI/topicos se debe mostrar titulo, mensaje, fecha de creación, estatus autor y respuesta, en formato JSON. </p>
    <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/755c3bf8-f7cd-44c0-abdd-b3e79a4d4811"  width=800 height="350">

   <h1>🔄️Actualiza topico</h1>
   <p>Teniendo encueta la solicitud PUT para la URI/topicos{id} se aplica las mismas reglas de negocio para el registro de un tópico por la cual se deben ser aplicadas la actualización del mismo.</p>
    <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/fd7f5f18-11dd-4d27-b021-1da93b1a4638"  width=800 height="350">

   <h1>🗑️Eliminación topico</h1>
   <p>La API  tener un endpoint para la eliminación de tópicos y aceptar requisiciones DELETE para el URI /topicos/{id}; esto determina la eliminación del registro directamente de nuestra base de datos MySQL:</p>
    <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/96e66e80-d216-4957-a910-186f76b017ec"  width=800 height="350">
   <p>En la siguiente imagen veremos directamente en la base de datos que cumple con el requerimiento sugerido eliminando el registro << 1 >> como se ve en la imagen anterior: </p>
    <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/617ce076-aa3c-4c3a-931d-7ccd0ea4c805"  width=800 height="350">


  ---
  <h1>🎬Video</h1>

[ForoApiRest_3.webm](https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/d7e40839-f7e7-45be-be58-eb89ca1b95ad)

  <p>Muestra resumidamente lo que te logra hacer con Insomnia y la manipulacion de los datos del topico.</p>
</div>



---
<div align= "center">
   <h1>📽Video expicado</h1>
  <p>🚨El video esta programado para el 69 de octubre del 2023.🚨</p>
  <a  href="https://www.linkedin.com/feed/update/urn:li:activity:7105255538795401216/" target="_blank" >
  <img src="https://img.shields.io/hackernews/user-karma/11?color=blue&label=LinkedIn&logo=data:image/png;base64,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&logoColor=blue&style=for-the-badge"
           alt="linkedin"/>
</a>
  <a href="https://www.facebook.com/magucho.gomez/videos/1850066102079662">
  <img src="https://img.freepik.com/fotos-premium/logotipo-facebook-neon-espacio-texto-graficos-fondo-azul_494516-176.jpg?w=360" alt="Facebook Badge" width=100/></a>
    
<p>Tener presente que al oprimir en algunos de los dos etiquetas(facebook y Linkedin) antes de la fecha programada, los llevará al challenge hotel alura.</p>
  </div>
</div>

---

<div align="center">
  <h1>🙏Agradecimientos🥇🎉</h1>
  
  <div align="center">
   <img src="https://img.shields.io/badge/Alura_ONE-Challenge%234-orange"> 
  </div>
   
   <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/1f9d0363-abac-47f7-8038-712995d5da3b" />
</div>


</html>

