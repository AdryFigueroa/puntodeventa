package puntodeventa;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class AppVentas {
	
	Scanner scanner;
	//arraylist
	private static ArrayList<Producto> productos = new ArrayList<Producto>();

	// constantes
	public final static int OPCION_MENU_SALIR = 6;
	public final static int OPCION_MENU_PAGAR = 5;
	public final static int OPCION_MENU_CARRO = 4;
	public final static int OPCION_MENU_ELIMINAR = 3;
	public final static int OPCION_MENU_PRODUCTOS = 2;
	public final static int OPCION_MENU_CREAR = 1;
	private static final Pagar[] pagar = null;

	//main
	public static void main(String[] args) {
	int opcionSeleccionada;
	do {
	opcionSeleccionada = menu();
	switch( opcionSeleccionada ) {
	case OPCION_MENU_CREAR:
	crearProducto();
	break;
	case OPCION_MENU_PRODUCTOS:
	verProductos();
	break;
	case OPCION_MENU_ELIMINAR:
	eliminarProducto();
	break;
	case OPCION_MENU_CARRO:
	agregarProductoAlCarro();
	break;
	case OPCION_MENU_PAGAR:
	pagar();
	break;
	}
	} while( opcionSeleccionada != OPCION_MENU_SALIR );

	System.out.printf("Seleccionó la opción %d", opcionSeleccionada);
	}

	private static void crearProducto() {
	try (Scanner scanner = new Scanner( System.in )) {
		System.out.println("Ingrese un código:");
		String codigoProducto = scanner.nextLine();

		System.out.println("Ingrese un nombre:");
		String nombreProducto = scanner.nextLine();

		System.out.println("Ingrese un precio:");
		int precioProducto = scanner.nextInt();

		Producto productoNuevo = new Producto(codigoProducto, nombreProducto, precioProducto);
		productos.add( productoNuevo );
	}
	}

	private static void verProductos() {
	for(Producto producto : productos ) {
	System.out.printf("Código: %s Producto: %s Precio: %d %n"
	, producto.getCodigo()
	, producto.getNombre()
	, producto.getPrecio()
	);
	}
	}

	private static Producto buscarProducto(String codigo) {
		for (Producto p: productos) {
			if (p.getCodigo().equalsIgnoreCase(codigo)) {
				return p;
			}
		}
		return null;
	}
	
	private static void eliminarProducto() {
		Scanner scanner = null;
		scanner.nextLine();
		System.out.println("Escriba el codigo del producto: ");
		String codigo = scanner.nextLine();
		System.out.println(codigo);
		
		Producto producto = buscarProducto(codigo);
		if (producto != null) {
			productos.remove(producto);
			System.out.printf("Producto eliminado: %s %n%n", producto.getNombre());
		}else {
			System.out.printf("No existe el producto %n%n");
		}
		
	}

	private static void agregarProductoAlCarro() {
		Pagar pago = new Pagar();
		boolean seguirAgregandoProductos = true;
		
		do {
		
		verDetalleProductos();
		scanner.nextLine(); 
		System.out.println("Escriba el codigo del producto: ");
		String codigo = scanner.nextLine();

		Producto producto = buscarProducto(codigo);
		
		System.out.println(" ¿Cuantos productos quier comprar? ");
		int cantidad = scanner.nextInt();
		
		
		DetalleProductos detalleProductos  = new DetalleProductos (cantidad,producto);
		pago.agregarDetalleProductos(detalleProductos);
		
		System.out.println("Quiere agregar mas productos al carro? (si/no)");
		
		seguirAgregandoProductos = scanner.next().equalsIgnoreCase("SI") ? true : false;
		}while (seguirAgregandoProductos == true);
		
		pago.add(pago);
		
		
	}

	private static void verDetalleProductos() {
					}


static DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	private static void pagar() {
	
			System.out.println("\n PAGAR");
			System.out.println("==============");
			
			for (Pagar pago : pago) {			
				System.out.printf(" Fecha: %s %n", fecha.format(pago.getFecha()));
				System.out.println(pago.productosTotales());
				System.out.printf(" Total: %s %n", pago.calcularTotal());
				System.out.println("--------------------------------------------------");
			}
			System.out.println("\n\n");			

	}

	private static int menu() {
	System.out.println("MENU PUNTO DE VENTA\n===================\n");
	System.out.println("1. Crear Producto");
	System.out.println("2. Ver Productos");
	System.out.println("3. Eliminar Producto");
	System.out.println("4. Agregar Producto al Carro");
	System.out.println("5. Pagar");
	System.out.println("6. SALIR");

	System.out.println("\nPor favor digite la opción deseada:");
	Scanner scanner = new Scanner( System.in );
	int opcionSeleccionada = scanner.nextInt();
	return opcionSeleccionada;
	}

	


}
