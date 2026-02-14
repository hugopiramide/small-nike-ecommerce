import { type CartItemRequest, type CartRequest, type CartResponse } from '../types/types'

const API_URL = 'http://localhost:8080/api/carts'

async function handleResponse<T>(response: Response): Promise<T> {
  if (!response.ok) {
    const errorData = await response.json().catch(() => ({}))
    throw new Error(errorData.message || `Error: ${response.status} ${response.statusText}`)
  }

  if (response.status === 204) return {} as T

  return response.json()
}

export const CartService = {
  getCart: async (userId: number): Promise<CartResponse> => {
    const response = await fetch(`${API_URL}/${userId}`)
    return handleResponse<CartResponse>(response)
  },

  saveCart: async (cartRequest: CartRequest): Promise<CartResponse> => {
    const response = await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(cartRequest),
    })
    return handleResponse<CartResponse>(response)
  },

  addItem: async (userId: number, item: CartItemRequest): Promise<CartResponse> => {
    const response = await fetch(`${API_URL}/user/${userId}/add`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ userId, ...item }),
    })
    return handleResponse<CartResponse>(response)
  },

  removeItem: async (userId: number, cartItemId: number): Promise<void> => {

    const response = await fetch(`${API_URL}/user/${userId}/item/${cartItemId}`, {
      method: 'DELETE',
    });
    return handleResponse<void>(response)
  },

}