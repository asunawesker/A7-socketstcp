# Socket TCP

Este proyecto se realizó en netbeans y se puede ejecutar desde ahí o desde la terminal. Para la terminal las siguientes instrucciones guían como ejecutarlo correctamente.

Antes de de ejecutarlo en terminal se recomienda copiar las clases en otra carpeta creada por el interesado y ejecutar los siguientes comandos en la carpeta de destino.

## Compilar
Se compila la solución y si se codifica de forma correcta, se generan archivos .class de cada archivo .java
```console
your@terminal:~$ cd carpeta
your@terminal:~$ javac *.java
```

## Terminal 2
Se inicia el servidor
```console
your@terminal:~$ cd carpeta
your@terminal:~$ java ServidorTCP
```

## Terminal 3
Se inicia el cliente y se agrega la dirección IP del servidor a conectarse
```console
your@terminal:~$ cd carpeta
your@terminal:~$ java ClienteTCP <<DIRECCION_IP>>
```
