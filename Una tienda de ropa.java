public class TiendaRopa {
    public static void main(String[] args) {
        // Precios originales
        double precioCamiseta = 25.0;
        double precioPantalon = 30.0;

        // Descuento del 15%
        double descuento15 = 0.15;

        // Precio después del descuento del 15%
        double precioCamisetaConDescuento = precioCamiseta - (precioCamiseta * descuento15);
        double precioPantalonConDescuento = precioPantalon - (precioPantalon * descuento15);

        // Precio de la segunda camiseta con un 5% adicional sobre el precio ya descontado
        double precioSegundaCamisetaConDescuento = precioCamisetaConDescuento - (precioCamisetaConDescuento * 0.05);

        // Precio total
        double precioTotal = precioCamisetaConDescuento + precioPantalonConDescuento + precioSegundaCamisetaConDescuento;

        // Mostrar resultados
        System.out.printf("Precio total después de aplicar descuentos: $%.2f%n", precioTotal);
    }
}