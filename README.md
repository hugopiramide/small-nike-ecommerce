# Small Nike E-commerce

Aplicación de e-commerce desarrollada con Spring Boot (backend) y React + Vite (frontend), utilizando MySQL como base de datos.

## Requisitos Previos

Antes de comenzar, necesitas tener instalado **Docker** y **Docker Compose** en tu sistema.

### Instalar Docker

- **Windows/Mac**: Descarga e instala [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- **Linux**: Sigue las instrucciones de [Docker Engine](https://docs.docker.com/engine/install/) y [Docker Compose](https://docs.docker.com/compose/install/)

Para verificar que Docker está instalado correctamente, ejecuta:
```bash
docker --version
docker-compose --version
```

## Configuración e Instalación

### 1. Clonar el Repositorio

```bash
git clone https://github.com/hugopiramide/small-nike-ecommerce.git
cd small-nike-ecommerce
```

### 2. Configurar Variables de Entorno

Crea un archivo `.env` en la raíz del proyecto con las siguientes variables:

```env
# Configuración MySQL
DB_NAME=nike_db
DB_USER=user_nike
DB_PASSWORD=password_nike
DB_ROOT_PASSWORD=root_password_nike

# Configuración Spring Boot
SPRING_LOCAL_PORT=8080
SPRING_DOCKER_PORT=8080

# Configuración Frontend
VITE_API_URL=http://localhost:8080/api
FRONT_LOCAL_PORT=5173
FRONT_DOCKER_PORT=5173
```

> **Nota**: Estos son valores por defecto que funcionan correctamente. Puedes modificarlos si lo deseas, pero asegúrate de mantener la coherencia entre las diferentes variables (especialmente las URLs y puertos).

### 3. Iniciar el Proyecto

Una vez configurado el archivo `.env`, ejecuta el siguiente comando para construir e iniciar todos los servicios:

```bash
docker-compose up -d
```

Este comando:
- Descargará las imágenes necesarias (MySQL 8.0)
- Construirá las imágenes del backend y frontend
- Iniciará los 3 contenedores (MySQL, Backend y Frontend)
- Los ejecutará en segundo plano (modo detached con `-d`)

### 4. Verificar que los Servicios Están Funcionando

```bash
docker-compose ps
```

Deberías ver 3 servicios en estado "Up":
- `mysqldb` - Base de datos MySQL
- `backend` - API Spring Boot
- `frontend` - Aplicación React

## Acceder a la Aplicación

Una vez iniciados todos los servicios:

- **Frontend**: [http://localhost:5173](http://localhost:5173)
- **Backend API**: [http://localhost:8080/api](http://localhost:8080/api)
- **Base de datos MySQL**: `localhost:3306`

## Comandos Útiles

### Iniciar el Proyecto

```bash
# Iniciar todos los servicios
docker-compose up -d

# Iniciar y ver los logs en tiempo real
docker-compose up
```

### Parar el Proyecto

```bash
# Detener todos los servicios
docker-compose down

# Detener y eliminar volúmenes (elimina los datos de la base de datos)
docker-compose down -v
```

### Ver Logs

```bash
# Ver logs de todos los servicios
docker-compose logs -f

# Ver logs de un servicio específico
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f mysqldb
```

### Reconstruir las Imágenes

Si realizas cambios en el código y necesitas reconstruir las imágenes:

```bash
# Reconstruir y reiniciar
docker-compose up -d --build

# Reconstruir un servicio específico
docker-compose up -d --build backend
```

### Reiniciar un Servicio

```bash
# Reiniciar un servicio específico
docker-compose restart backend
docker-compose restart frontend
```

## Estructura del Proyecto

```
small-nike-ecommerce/
├── backend/                # Aplicación Spring Boot
│   ├── src/
│   ├── pom.xml
│   └── Dockerfile
├── frontend/               # Aplicación React + Vite
│   ├── src/
│   ├── package.json
│   └── Dockerfile
├── docker-compose.yml      # Orquestación de contenedores
├── .env                    # Variables de entorno (no incluido en Git)
└── README.md              # Este archivo
```

## Solución de Problemas

### Los contenedores no inician

```bash
# Ver logs detallados
docker-compose logs

# Verificar que los puertos no estén en uso
# Windows
netstat -ano | findstr :8080
netstat -ano | findstr :5173
netstat -ano | findstr :3306

# Linux/Mac
lsof -i :8080
lsof -i :5173
lsof -i :3306
```

### El backend no se conecta a la base de datos

Asegúrate de que el servicio `mysqldb` esté completamente iniciado antes de que el backend intente conectarse. Puedes verificar los logs:

```bash
docker-compose logs mysqldb
```

### Limpiar y empezar de cero

```bash
# Detener y eliminar contenedores, volúmenes y redes
docker-compose down -v

# Eliminar imágenes construidas
docker-compose down --rmi all -v

# Iniciar de nuevo
docker-compose up -d --build
```

