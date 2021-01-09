package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ExpenseRepositoryTest {
    private ExpenseRepository expenseRep;
    private List<Expense> expenses;

    @Test
    void loadExpensesTest(){
        FakeDatabase db = new FakeDatabase();
        expenseRep = new ExpenseRepository(db);
        expenseRep.loadExpenses();
        //sprawdzenie czy pusta lista na pewno jest pusta
        assertEquals(0, expenseRep.getExpenses().size());
    }

    @Test
    void loadExpensesv2Test(){
        IFancyDatabase mockedDB = mock(IFancyDatabase.class);
        InOrder inOrder = inOrder(mockedDB);
        when(mockedDB.queryAll()).thenReturn(Collections.emptyList());
        expenseRep = new ExpenseRepository(mockedDB);
        expenseRep.loadExpenses();
        //Dzieki inOrder sprawdzamy czy akcje wykonywane sa w odpowiedniej kolejnosci
        inOrder.verify(mockedDB).connect();
        inOrder.verify(mockedDB).queryAll();
        inOrder.verify(mockedDB).close();
        assertEquals(0, expenseRep.getExpenses().size());
    }

    @Test
    void saveExpensesTest() {
        IFancyDatabase mockedDB = mock(IFancyDatabase.class);
        InOrder inOrder = inOrder(mockedDB);
        when(mockedDB.queryAll()).thenReturn(Collections.emptyList());
        expenseRep = new ExpenseRepository(mockedDB);
        IntStream.range(0, 5).forEach(i -> expenseRep.addExpense(new Expense()));
        expenseRep.saveExpenses();
        inOrder.verify(mockedDB).connect();
        inOrder.verify(mockedDB, times(5)).persist(any(Expense.class));
        inOrder.verify(mockedDB).close();
    }

}
