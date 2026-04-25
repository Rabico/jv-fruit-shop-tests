package core.basesyntax.model;

public class FruitTransaction {
    private String name;
    private int quantity;
    private Operation operation;

    public FruitTransaction(String operation, String name, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Fruit name cannot be null or blank");
        }
        this.name = name;
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative");
        }
        this.quantity = quantity;
        this.operation = Operation.fromCode(operation);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }
}
