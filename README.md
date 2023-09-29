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
   <p>Writing wht happend...</p>
    <img src="https://github.com/Magucho/API_REST_With_SpringBoot/assets/98346054/617ce076-aa3c-4c3a-931d-7ccd0ea4c805"  width=800 height="350">

</div>

</html>

