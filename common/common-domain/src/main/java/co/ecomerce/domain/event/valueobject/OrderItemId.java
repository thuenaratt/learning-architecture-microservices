package co.ecomerce.domain.event.valueobject;

public class OrderItemId {
//    private final Product product;
    private final Integer quantity;
    private final Money price;
    private final Money subTotal;
    private OrderId orderId;

    public OrderItemId(Integer quantity, Money price, Money subTotal) {
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }

    public OrderItemId(long l) {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
