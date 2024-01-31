# ejercicio
Luego de descargar el proyecto se debe abrir desde intellij idea.
Una vez abrierto desde Intellij se debe compilar y subir el proyecto.
Luego desde el postman se debe comppiar los sugientes curl's

1- Curl de insercion, copiar y pegar en postman

curl --location 'http://localhost:8080/api/usuario' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "juan1@rodriguez.org",
    "password": "W#$=@-De33w$%&/(/!°=",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        },
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}' 

2 de listado de usuario

curl --location 'http://localhost:8080/api/usuarios'
