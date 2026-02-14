# 1. Usuario (User)

1:1 con Carrito: Un usuario tiene un único carrito activo.

JPA: @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)

1:N con Pedidos: Un usuario puede tener muchos pedidos históricos.

JPA: @OneToMany(mappedBy = "user")

# 2. Categoría (Category)

1:N con Productos: Una categoría (ej. "Mujer") tiene muchos productos asociados.

JPA: @OneToMany(mappedBy = "category")

# 3. Producto (Product)

N:1 con Categoría: Muchos productos pertenecen a una categoría.

1:N con Variantes: Un producto (ej. "Camiseta Básica") tiene múltiples variantes por talla (S, M, L).

JPA: @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true). Usamos orphanRemoval para que, si borras una talla del producto, se elimine de la BD automáticamente.

# 4. Variante de Producto (ProductVariant)

N:1 con Producto: Muchas variantes pertenecen a un solo producto padre.

N:M (Indirecta) con Carrito y Pedidos: Las variantes son las que realmente se añaden al carrito y a las líneas de pedido.

# 5. Carrito e Ítems (Cart & CartItem)

1:N entre Carrito e Ítems: Un carrito contiene muchos productos.

N:1 entre Ítem y Variante: Muchos ítems de diferentes carritos pueden referenciar a la misma variante (ej. 10 personas tienen la "Talla L" en su carrito).

# 6. Pedido y Líneas de Pedido (Order & OrderItem)

1:N entre Pedido e Ítems: Una orden de compra tiene varios artículos.

N:1 entre Línea de Pedido y Variante: Cada línea apunta a la variante comprada para saber qué talla se vendió.