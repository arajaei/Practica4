# Las clases Java Socket y ServerSocket 

El objetivo de esta sesión práctica es mostrar el modo de funcionamiento de sockets de flujo (stream) en Java.

## Ejercicios.

    1. Modificar el ejemplo `Cliente de Eco` del directorio de código fuente de manera que:
       Se especifique en la línea de comandos el nombre de la máquina servidora y 
       el número de puerto. 
       Si no se especifica nada, el servidor por defecto será `localhost`
       y el puerto el número 8187.
       Para indicar el final de una sesión cliente el usuario ha de introducir por teclado
       un punto `.`. 
       Cuando se introduzca un punto se ha de salir del bucle de entrada
       y se ha de cerrar el socket de datos.

    2. Implementar un `Servidor de Eco` como el que proporcionan los servidores Unix en
       el puerto 7. Partiendo del código fuente proporcionado, diseñe un servidor iterativo, 
       que verifique lo siguiente:

         * Se ha de especificar en la línea de comandos el número de puerto en el que
           el servidor acepta conexiones (por ejemplo, 8180). 
           Si no se especifica nada, el número de puerto por defecto será el 8187.

         * Abrir un flujo de entrada desde el socket servidor. 

         * Abrir un flujo de salida al socket. 

         * El programa ha de actuar como repetidor, recogiendo las líneas que llegan por el
           canal de entrada y escribiéndolas en el canal de salida, hasta que el usuario le
           indique que ha terminado, escribiendo un punto “.”. 

         * Cuando ya no haya más líneas que leer, se recibirá un punto, lo cual hará que 
           el servidor salga del bucle de entrada y cierre el socket servidor.

         * Para probar que funciona, ejecute el programa servidor en un consola, 
           y en otra terminal el `Cliente de Eco`.

    3. Con los dos programas anteriores realice las siguientes operaciones:

         * Ejecute los programas empezando por el servidor y a continuación el cliente.

         * En una terminal diferente arranque a otro cliente.

         * Dibuje el **diagrama de secuencia**. ¿Se pueden realizar las dos sesiones en paralelo?

         * Explique su respuesta.

    4. Modificar el `Servidor de eco` del ejercicio 2, para que sea un servidor concurrente.

    5. Con el programa anterior y el `Cliente de Eco` del ejercicio 1 realice las siguientes
       operaciones:

         * Ejecute los programas empezando por el servidor y a continuación el cliente.

         * En una terminal diferente arranque a otro cliente.

         * Dibuje el diagrama de secuencia. ¿Se pueden realizar las dos sesiones del cliente en
           paralelo? Explique su respuesta.

    6. Describa las diferencias, desde el punto de vista del cliente, entre un servidor iterativo
       y un servidor concurrente para un servicio que involucre múltiples rondas de intercambios 
       de mensajes.
