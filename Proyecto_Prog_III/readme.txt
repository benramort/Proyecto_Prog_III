AQUÍ ESTÁN LOS PASOS PARA USAR LA APLICACIÓN:

1. Inicie la aplicación

2. Al iniciarla, tendrá dos opciones: "INICIAR SESIÓN" o "CREAR CUENTA". Si no tiene cuenta, cree una nueva.

3. Ahora habrá entrado en la ventana principal de la aplicación, el álbum. Aquí verá varias cosas:
	
	- Por un lado están sus cartas coleccionadas, que si ha creado una cuenta nueva, estarán todas bloqueadas
	
	- También hay un porcentaje en la parte izquierda de la pantalla. Ese es el porcentaje de cartas coleccionadas.
	
	- Arriba a la derecha está el indicador de monedas. Si ha creado una cuenta nueva, tendrá 100.000

	- Y por último, abajo verá una botonera con 6 botones.
	
	- Al pulsar en alguno de esos botones, accederá a otras ventanas de la aplicación. Cada una de esas ventanas dispone de un botón "ÁLBUM" que si lo pulsa volverá a su álbum.

4. BOTÓN ENTRENAR (símbolo de la mancuerna):
		
	- Al pulsarlo, entrará en la ventana de entrenamiento.	

	- Hay 3 slots para poner cartas a "ENTRENAR". Si pulsa en alguno de ellos, podrá elegir que carta de su colección pondrá a entrenar. (Solo puede poner una carta igual a la vez, es decir, aunque tenga una carta repetida varias 	veces, solo la podrá poner una vez. Las cartas que hayan agotado su resistencia tampoco podrá ponerlas a entrenar.
	
	- Solo podrá pulsar el botoón de entrenar si los 3 slots tienen alguna carta elegida.
	
	- Cada carta tiene 3 estadísitcas: Monedas por minuto, resistencia y recuperación:
		
		- Las monedas por minuto son las monedas por minuto que genera cada carta en el modo entrenamiento
		
		- La resistencia es lo que aguanta cada carta entrenando sin canasarse. (Representada en el modo enttrenamiento con las barras de progreso debajo de cada carta)

		- La recuperacion es cuanto tarda en recuperarse la carta. Cuanta mayor recuperación, menos tardará en recuperarse.
	
	- Una vez pulsado el botón de entrenar, se ponen en marcha 3 indicadores:
		
		- Las barras de progreso empiezan a disminuir, cada una a su ritmo, represenando la resistencia que le queda a cada carta.

		- El indicador de monedas generadas es el total de monedas que se ha generado en esa sesión de entrenamiento.

		- El indicador de monedas por minuto son las monedas que se están generando por minuto. Cuando alguna carta se quede sin resistencia, disminuirá.
	
	- Al pulsar el botón entrenar, en su lugar aparecerá un nuevo botón de "RECOGER MONEDAS". Al pulsar este botón, detendrá la sesión de entrenamiento y se sumarán las monedas generadas a su indicador de monedas.

	- Si pulsa el botón "CLEAR" se vaciarán todos los slots de cartas y podrá poner cartas nuevas a entrenar.
	
	- - - NOTA - - - PARA FACILITAR LAS PRUEBAS TANTO EL ENTRENAMIENTO COMO LA RECUPERACIÓN DE CARTAS ESTÁN ACELERADOS

5. BOTÓN MERCADO (símbolo del puesto de venta):
	
	- Al pulsarlo, entrará en la ventana de mercado. Aquí podrá comprar y vender cartas.

	- En la parte central hay una tabla con las cartas que están vendiendo otros jugadores. Podrá ver la imagen de la carta, su precio y el nombre del usuario que la está vendiendo. Si hace clic en la imagen de alguna carta, 	aparecerá un mensaje de si realmente quiere comprarla, para evitar 'missclicks'.

	- En la parte inferior izquierda hay un botón "VENDER". Al pulsarlo, le aparecerá una ventana similar a la que aparece cuando pulsa uno de los slots para entrenar un carta. En esta ventana le aparecerán las cartas que puede 	vender, pero solo le aparacerán las que tenga repetidas.

	- Al pulsar la carta que quiere vender, aparecerá un rectángulo azul a su alrededor, para confirmar que está seleccionada, y en la parte inferior aparecerá un panel en el que le podrá poner el precio a la carta. Cuando pulse el 	botón aceptar, la carta que ha puesto a vender aparecerá la última en la tabla de cartas vendiéndose.

	- En la parte izquierda hay filtros con los que podrá buscar la carta que quiera comprar, siempre que esté disponible para comprar.

6. BOTÓN TIENDA (símbolo del carro de la compra):

	- Al pulsarlo, accederá a la tienda de sobres.

	- Aquí podrá comprar sobres para desbloquear cartas. Hay 4 sobres disponibles. En el más barato solo hay 1 carta, y en el más caro hay 4.


7. BOTÓN FILTROS (símbolo de la lupa):
	
	- Al pulsar este botón, cambiará el porcentaje de colección por unos filtros, con los que podrá buscar una carta en su álbum.

	- Para cerrar estos filtros, haga clic en la x de la parte superior derecha de los filtros.

8. BOTÓN AJUSTES (símbolo del engranaje):

	- Todavía sin programar

9. BOTÓN SALIR (símbolo de la puerta y la flecha):
	
	- Al pulsarlo aparecerá un mensaje para salir de la aplicación.
	
Programas auxiliares ubicados dentro de la carpeta src en la carpeta setUp:
    - ConversorFicheroDB: esta clase se encarga de cargar el contenido del fichero modeloCartas.csv en la base de datos.
    - VentasAlAzar: esta clase se encarga de añadir tanto a la base de datos como a ficheros varias ventas al azar.

Cambio de método de guardado entre base de datos y ficheros ubicado en la carpeta conf:
Dentro del fichero si asignamos a la variable FuenteDatos la palabra Ficheros, todos los datos del programa se guardarán en ficheros pero si ponemos BaseDeDatos, se guardarán en la base de datos.
    











