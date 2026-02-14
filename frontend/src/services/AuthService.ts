import { type LoginRequest, type UserRequest, type UserResponse } from '../types/types' 

const API_URL = 'http://localhost:8080/api/users'

export const authService = {

    register: async (userData: UserRequest): Promise<UserResponse> => {
        const response = await fetch(`${API_URL}`, {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData),
    })

    if (!response.ok) {
      // En caso de error, lo recojemos en el back-end y lo mostremos aquí
      const errorData = await response.json().catch(() => ({}))
      throw new Error(errorData.message || 'Error al registrar el usuario')
    }

    return response.json()
  },

  login: async (credentials: LoginRequest): Promise<UserResponse> => {
    const response = await fetch(`${API_URL}/login`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(credentials),
    })

    if (!response.ok) {
      throw new Error('Credenciales incorrectas o error en el servidor')
    }

    return response.json()
  },

  // Esto es opcional
  logout: () => {
    localStorage.removeItem('user')
  }
}