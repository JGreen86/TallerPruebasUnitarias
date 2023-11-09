package org.ites.sistemas;

import java.util.ArrayList;
import java.util.HashMap;

public class CarritoDeCompras {

    private final HashMap<String, Item> items = new HashMap<>();

    public CarritoDeCompras() {

    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    public void agregarProducto(Producto producto) {
        items.put(producto.getCodigo(), new Item(producto, 1));
    }

    public void agregarProducto(Producto producto, int cantidad) {
        items.put(producto.getCodigo(), new Item(producto, cantidad));
    }

    public void decrementarProducto(Producto producto, int cantidad) {
        Item item = items.get(producto.getCodigo());
        item.setCantidad(item.getCantidad() - cantidad);
        items.put(producto.getCodigo(), item);
    }

    public void eliminarProducto(String codigo) {
        items.remove(codigo);
    }

    public void limpiarCarrito() {
        items.clear();
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }

    public double getTotal() {
        ArrayList<Item> items = this.getItems();
        double total = 0;
        for(Item item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }

}
