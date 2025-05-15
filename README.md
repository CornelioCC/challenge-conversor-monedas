<h1>Challenge Conversor Monedas</h1>

<h4>Funciones en clase Conversor</h4>

- `exhibirMenu`: Recibe un objeto Scanner, muestra un menu y utiliza el objeto Scanner para validar que la opcion tecleada existe, devuelve un entero con la opcion elegida.
  
- `obtenerValorActual`: Recibe un objeto String y un objeto Gson, agrega el objeto String a la direccion para solicitar los valores actuales en exchange rate con referencia a la moneda indicada en el objeto String y utiliza el objeto Gson para obtener los valores d
  el json obtenido. Por ultimo crea un objeto del tipo Monedas donde asigna los valores de las monedas disponibles para eleccion del usuario y devuelve el objeto Monedas.

<h4>Record Monedas</h4>
  Contiene las monedas disponibles para el usuario en tipo double, cada uno serializado con el nombre indicado en el json proporcionado por la exchange rate.

<h4>Clase Principal</h4>
Desde la clase Principal se asignan valores y se llaman las funciones con los valores correspondientes para realizar la operacion indicada por el usuario.

![image](https://github.com/user-attachments/assets/264f8875-1f89-4dac-bd5f-1b3bb2ddeeb2)


<h5>Autor</h5>
<h6>Cornelio Cano Castro</h6>
