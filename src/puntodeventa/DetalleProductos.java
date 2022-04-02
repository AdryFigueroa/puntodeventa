package puntodeventa;

public class DetalleProductos {

		private int cantidad;
		private Producto producto;
		
		public DetalleProductos() {

		}

		public DetalleProductos(int cantidad, Producto producto) {
			this.cantidad = cantidad;
			this.producto = producto;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		
		public int calcularSubtotal() {
			return cantidad * producto.getPrecio();
		}
		
	}

