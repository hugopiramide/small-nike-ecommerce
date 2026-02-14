export interface ProductResponse {
  id: number;
  name: string;
  category: CategoryResponse;
  basePrice: number;
  imageUrl: string;
  description: string;
  active: boolean;
  variants: ProductVariantResponse[];
}

export interface CategoryResponse {
  id: number;
  name: string;
  description: string;
}

export interface ProductShortResponse {
  name: string;
  price: number;
  imageUrl: string;
  description: string;
  category: CategoryResponse;
}

export interface ProductVariantResponse {
  id: number;
  size: string;
  product: ProductShortResponse;
  stock: number;
  priceModifier: number;
}

export interface UserRequest {
  username: string;
  email: string;
  password: string;
  profileImgUrl: string;
}

export interface LoginRequest {
  username: string;
  password: string;
}

export interface CartItemResponse {
  id: number;
  productVariantId: ProductVariantResponse;
  quantity: number;
}

export interface CartResponse {
  id: number;
  user: UserResponse;
  cartItems: CartItemResponse[];
  updatedAt: string;
}

export interface CartRequest {
  userId: number;
  cartItems: CartItemRequest[];
}

export interface CartItemRequest {
  productVariantId: number;
  quantity: number;
}

export interface UserResponse {
  id: number;
  username: string;
  name: string;
  surnames: string;
  birthday: Date;
  email: string;
  profileImgUrl: string;
  role: string;
  createdAt: string;
}

export interface UserRequest {
  username: string;
  name: string;
  surnames: string;
  birthday: Date;
  email: string;
  password: string;
  profileImgUrl: string;
}

export interface Page<T> {
  content: T[];
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  first: boolean;
  last: boolean;
  empty: boolean;
}
