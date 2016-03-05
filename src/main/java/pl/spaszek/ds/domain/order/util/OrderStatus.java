package pl.spaszek.ds.domain.order.util;

public enum OrderStatus {
    NEW("Nowe"),
    TAKEN("Podjęte przez kuriera"),
    IN_DELIVERY("W drodze do klienta"),
    DELIVERED("Dostarczone do klienta"),
    FINALIZED("Zamknięte"),

    EXPIRED("Wygasłe"),
    NOT_ACCEPTED("Niezaakceptowane"),
    NOT_PICKED_UP("Nieodebrane");

    public final String message;

    OrderStatus(String message) {
        this.message = message;
    }
}
