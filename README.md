# DeliveryBack

Proyecto creado como trabajo final de la materia Laboratorio de Computación 4 de la Tecnicatura Universitaria en Programación de la Universidad Tecnológica Nacional-Facultad Regional Mendoza

“El Buen Sabor”
El Delivery de comidas de la ciudad “El Buen Sabor”, ofrece a sus clientes una amplia variedad de bebidas y de comidas de fabricación propia, posee un horario de atención de lunes a domingos de 20:00 a 12:00, y de sábados y domingos de 11:00 a 15:00. Los clientes tienen a disposición un menú que describe para cada una de las comidas, el nombre, los ingredientes y el precio. Los clientes realizan sus pedidos en el mostrador del local mediante una PC o pueden hacerlo en forma remota desde su casa o su celular personal. (La aplicación debe ser responsive)
El cliente debe proceder a registrarse en la aplicación como paso inicial para realizar el pedido o ejecutar el login en la misma si ya se encuentra registrado, el identificador único y nombre de usuario para el cliente será su email.
El pedido debe contener la fecha del pedido, el nombre del Cliente, teléfono, su domicilio y el detalle de las comidas y bebidas deseadas. Además el cliente deberá indicar si retira el pedido en el local (en este caso se le otorga un 10% de descuento en la compra) o desea que se lo envíen a su domicilio. El local admite diversas formas de pago (debito, crédito y efectivo) pero solo si el pago se realiza en el local, si el pedido se entrega a domicilio solo se acepta pago en efectivo.
El sistema debe validar que el stock de artículos insumos que se posee sean suficientes para llevar a cabo el pedido, por ejemplo si el cliente pide una pizza de jamón crudo y rucula, pero el stock de rucula es 0, el sistema deberá emitir un mensaje indicando la situación e impidiendo la carga de dicho artículo manufacturado al pedido.
Finalizada la carga del pedido el sistema le informara al cliente cuanto es el tiempo estimado para el retiro o entrega de su pedido, este tiempo surgirá de la siguiente formula:
Σ Sumatoria del tiempo estimado de los artículos manufacturados solicitados por el cliente en el pedido actual
+
Σ Sumatoria del tiempo estimado de los artículos manufacturados que se encuentran en la cocina / cantidad cocineros
+
10 Minutos de entrega por Delivery, solo si corresponde.
El pedido realizado por el cliente ingresa a la bandeja de entrada de pedidos pendientes del cajero, este usuario (cajero) revisa el pedido y si está correcto, lo aprueba, dicha acción envía el pedido a la cocina. El usuario cocinero consulta los pedidos aprobados que debe preparar y cuando el
pedido está listo lo marca con estado terminado, esta acción envía el pedido nuevamente al usuario cajero pero a la bandeja de pedidos listos para entregar, ahora el pedido puede seguir 2 caminos, el primero es que sea entregado al cliente directamente en el local lo cual originara la factura correspondiente, con la forma de pago que corresponda y será entregada al cliente, dejando el pedido con el estado final FACTURADO, o segundo el pedido es enviado mediante Delivery al domicilio del cliente asignando al pedido el estado “En Delivery” hasta que el empleado que realizo el envió retorna con el cobro y lo rinda al cajero con lo cual el estado final FACTURADO.

El dueño del Delivery ha manifestado la necesidad de acceder al menos a la siguiente información, la cual desea pueda exportarse a un archivo Excel:
 Ranking comidas más pedidas en un periodo de tiempo determinado
 Ingresos (recaudaciones) por períodos de tiempo. Diario / Mensual
 Cantidad de pedidos agrupados por cliente en un determinado periodo de tiempo.
 Control de Stock, mostrar artículos por debajo del stock mínimo.
Las interfaces de usuario principales del sistema serán:
 Portal WEB donde el cliente podrá registrarse y realizar los pedidos vía PC o celular.
 Interfaces de administración de pedidos y facturas por parte del empleado cajero.
 Interface de pedidos pendientes para el cocinero.
 Interface de administración de artículos y artículos manufacturados.
 Reportes estadísticos para toma de decisiones.
Tecnologías para el desarrollo de la Aplicación.
PORTAL WEB
Puede ser desarrollado con cualquier tipo de framework HTML/JavaScript, más el uso de cualquier otro lenguaje de acceso al servidor (PHP, JSP, ASP, Node, etc), es importante que el portal sea responsive para adaptarse a diferentes dispositivos.
MODULO DE ADMINISTRACIÓN
Front End
Debe ser desarrollado por cualquier framework o librería que desee siempre y cuando la misma sea reactiva (RxJs, React, Vue, Angular, etc)
Back End
Puede desarrollarlo con cualquier lenguaje de programación que desee (JAVA, C#, PHP, Node, Python, etc)


El front podrá encontrarse en: https://github.com/AndreTati/DeliveryFront
