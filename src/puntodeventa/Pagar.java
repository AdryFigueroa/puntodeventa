package puntodeventa;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pagar {

		private static LocalDateTime fecha;
		private ArrayList<DetalleProductos> detalleProductos = new ArrayList<>();
		
		
		public Pagar() {
			
		}
		public Pagar(LocalDateTime fecha, ArrayList<DetalleProductos> detalleProductos) {
			this.fecha = fecha;
			this.detalleProductos = detalleProductos;
		}
		
		
		public static LocalDateTime getFecha() {
			return fecha;
		}
		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}
		public ArrayList<DetalleProductos> getDetalleProductos() {
			return detalleProductos;
		}
		public void setLineasDetalle(ArrayList<DetalleProductos> detalleProductos) {
			this.detalleProductos = detalleProductos;
		}
		
		public void agregarLineaDetalle(DetalleProductos detalleProductos) {
			this.detalleProductos.add(detalleProductos);
			this.fecha = LocalDateTime.now();
		}

		public int calcularTotal() {
			int total = 0;	
			for (DetalleProductos l: this.detalleProductos) {
				total = total + l.calcularSubtotal();
			}
			return total;
		}
		public String productosTotales() {
			String productos = " Productos comprados: ";		
			for (DetalleProductos l: this.detalleProductos) {
				productos = productos+ " | " +l.getCantidad() +" "+ l.getProducto().getNombre()+ " | ";
			}	
			return productos;
		}
		public void agregarDetalleProductos(DetalleProductos detalleProductos2) {
			// TODO Auto-generated method stub
			
		}
		public void add(Pagar pago) {
			
			
		}
		
	
}
