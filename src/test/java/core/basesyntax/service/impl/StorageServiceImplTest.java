package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.OperationHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StorageServiceImplTest {
    static Map<Operation, OperationHandler> map = new HashMap<>();
    List<FruitTransaction> fruitTransactions = new ArrayList<>();
    static StorageService storageService;
    static OperationHandler operationHandlerReturn;
    static OperationHandler operationHandlerBalance;
    static OperationHandler operationHandlerSupply;
    static OperationHandler operationHandlerPurchase;

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
    void process_Return_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.RETURN, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerReturn).execute(fruitTransaction);
    }

    @Test
    void process_Balance_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.BALANCE, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerBalance).execute(fruitTransaction);
    }

    @Test
    void process_Supply_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.SUPPLY, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerSupply).execute(fruitTransaction);
    }

    @Test
    void process_Purchase_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.PURCHASE, "apple", 230);
        fruitTransactions.add(fruitTransaction);
        storageService.process(fruitTransactions);
        verify(operationHandlerPurchase).execute(fruitTransaction);
    }

}