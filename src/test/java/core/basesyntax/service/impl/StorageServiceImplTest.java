package core.basesyntax.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.OperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorageServiceImplTest {
    private static Map<Operation, OperationHandler> map = new HashMap<>();
    private static StorageService storageService;
    private static OperationHandler operationHandlerReturn;
    private static OperationHandler operationHandlerBalance;
    private static OperationHandler operationHandlerSupply;
    private static OperationHandler operationHandlerPurchase;
    private List<FruitTransaction> fruitTransactions = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        operationHandlerReturn = mock(OperationHandler.class);
        operationHandlerBalance = mock(OperationHandler.class);
        operationHandlerSupply = mock(OperationHandler.class);
        operationHandlerPurchase = mock(OperationHandler.class);
        map.put(Operation.RETURN, operationHandlerReturn);
        map.put(Operation.BALANCE, operationHandlerBalance);
        map.put(Operation.SUPPLY, operationHandlerSupply);
        map.put(Operation.PURCHASE, operationHandlerPurchase);
        storageService = new StorageServiceImpl(map);
    }

    @BeforeEach
    void beforeEach() {
        fruitTransactions.clear();
    }

    @Test
    void process_returnTransaction_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.RETURN, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerReturn).execute(fruitTransaction);
    }

    @Test
    void process_balanceTransaction_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.BALANCE, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerBalance).execute(fruitTransaction);
    }

    @Test
    void process_supplyTransaction_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.SUPPLY, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerSupply).execute(fruitTransaction);
    }

    @Test
    void process_purchaseTransaction_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.PURCHASE, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerPurchase).execute(fruitTransaction);
    }

}
